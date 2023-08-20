package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartPage: AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(cartContent).isDisplayed

    private val cartContent: ElementDef = ElementDef(ComponentType.FRAME, "", By.ByClassName("cart_contains_container"))
    private val checkout: ElementDef = ElementDef(ComponentType.BUTTON, "", "checkout")
    private val itemBackpackInCart: ElementDef = ElementDef(ComponentType.BUTTON, "Backpack", By.id("item_4_title_link"))
    private val itemFleeceJacketInCart: ElementDef = ElementDef(ComponentType.BUTTON, "Fleece Jacket", By.id("item_5_title_link"))
    private val itemBoltTShirtInCart: ElementDef = ElementDef(ComponentType.BUTTON, "Bolt T-Shirt", By.id("item_1_title_link"))
    private val itemBackpackPrice: ElementDef = ElementDef(ComponentType.FRAME, "$29.99", By.xpath("(//div[@class='inventory_item_price'])[1]"))
    private val itemFleeceJacketPrice: ElementDef = ElementDef(ComponentType.FRAME, "$15.99", By.xpath("(//div[@class='inventory_item_price'])[2]"))
    private val itemBoltTShirtPrice: ElementDef = ElementDef(ComponentType.FRAME, "$49.99", By.xpath("(//div[@class='inventory_item_price'])[3]"))

    fun getTotalCartPrice() : Double {
        val backPackPrice = elements().findElement(itemBackpackPrice).text.removePrefix("$").toDouble()
        val fleeceJacketPrice = elements().findElement(itemFleeceJacketPrice).text.removePrefix("$").toDouble()
        val boltTShirtPrice = elements().findElement(itemBoltTShirtPrice).text.removePrefix("$").toDouble()

        return backPackPrice + fleeceJacketPrice + boltTShirtPrice
    }
    fun verifyItemsInCart() : Boolean {
        return elements().findElement(itemBackpackInCart).isDisplayed &&
               elements().findElement(itemFleeceJacketInCart).isDisplayed &&
               elements().findElement(itemBoltTShirtInCart).isDisplayed
    }

    /*companion object {
        private val cartItems = mutableListOf<String>()
        fun getCartItems(): List<String> {
            return cartItems.toList()
        }
    }*/
    fun clickOnCheckout(): ShoppingCartPage {
        elements().performClick(checkout)
        return ShoppingCartPage()
    }

}