package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(cartContents).isDisplayed


    private val cartContents: ElementDef = ElementDef(ComponentType.FRAME, "",By.className("cart_contents_container"))
    private val checkout: ElementDef = ElementDef(ComponentType.BUTTON, "", "checkout")

    private val cartItemFrame: ElementDef = ElementDef(ComponentType.FRAME,"", By.className("cart_item"))
    private val inventoryItemName: ElementDef = ElementDef(ComponentType.LABEL,"", By.className("inventory_item_name"))
    private val inventoryItemPrice: ElementDef = ElementDef(ComponentType.LABEL, "",By.className("inventory_item_price"))
    private var priceSummary: Double = 0.0

    fun getCartItemsPriceSummary(): Double = priceSummary

    private fun getShoppingCartItems(): MutableMap<String, Double> {
        val cartItems = mutableMapOf<String, Double>()
        val cartItemList: MutableList<WebElement>? = elements().findElements(cartItemFrame)

        val name = elements().findElement(inventoryItemName).text
        val price = elements().findElement(inventoryItemPrice).text.removePrefix("$").toDoubleOrNull()

        for (product in cartItemList!!) {
            if (name.isNotEmpty() && price != null) {
                cartItems[name] = price
                priceSummary += price

            }
        }
        return cartItems
    }

    fun clickOnCheckout(): FillYourInformationPage {
        elements().performClick(checkout)
        return FillYourInformationPage()
    }

}