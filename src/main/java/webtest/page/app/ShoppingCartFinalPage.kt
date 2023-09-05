package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartFinalPage: AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(summaryContainer).isDisplayed


    private val summaryContainer: ElementDef = ElementDef(ComponentType.ANY, "", "checkout_summary_container")
    private val itemTotalLabel: ElementDef = ElementDef(ComponentType.LABEL, "Total", By.className("summary_subtotal_label"))

    fun getTotalPrice(): Double = elements().findElement(itemTotalLabel).text.substringAfter("$").toDouble()

    fun validateTotalPrice(expectedPrice: Double, actualPrice: Double) {
        if (!expectedPrice.equals(actualPrice)) {
            Info.of(this)
                .message("Ocekavana hodnota $expectedPrice se skutecnou hodnotou $actualPrice se neshoduji")
                .build()
        }

    }
}