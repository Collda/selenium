package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckOutOverview: AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(summary).isDisplayed

    private val summary: ElementDef =
        ElementDef(ComponentType.FRAME, "Payment Information", By.className("summary_info_label"))
    private val itemTotalElement: ElementDef =
        ElementDef(ComponentType.LABEL, "Item total", By.className("summary_subtotal_label"))

    fun getItemTotal(): Double? {
        val itemTotalText = elements().findElement(itemTotalElement).text
        val regex = """Item total: \$(\d+\.\d{2})""".toRegex()
        val matchResult = regex.find(itemTotalText)

        return matchResult?.groups?.get(1)?.value?.toDoubleOrNull()
    }
    fun compare() {
       val itemTotal = getItemTotal()
            if (itemTotal != null) {
                     if (itemTotal == TotalStorage.totalValue) {
                        println("Item Total na Checkout stránce je: $$itemTotal, Kontrolní součet je stejný!")
                    } else {
                        println("Item Total na Checkout stránce je: \$$itemTotal, Kontrolní součet nesedí!")
                    }
            }
        }
    }
