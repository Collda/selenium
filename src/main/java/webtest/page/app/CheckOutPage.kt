package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import kotlin.math.roundToInt

class CheckOutPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(labelItemTotal).isDisplayed

    val labelItemTotal: ElementDef = ElementDef(ComponentType.BUTTON,"Item Total", By.className("summary_subtotal_label"))

    fun verifyTotalPriceEqualToTotalTitemPrice(): Boolean{
        val shoppingCardPage = ShoppingCartPage()
        val itemTotal = elements().findElement(labelItemTotal).text
        val intItemTotal = itemTotal.removePrefix("Item total: $").toDouble().roundToInt()


        return shoppingCardPage.totalPrice==intItemTotal
    }

}