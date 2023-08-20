package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CartPage : AbstractTechnicalPage() {
    override fun isOpen() : Boolean { return elements().isDisplayed(cartContentFrame) }

    private val cartContentFrame: ElementDef = ElementDef(ComponentType.FRAME, "Cart Contents", "cart_contents_container")
    private val checkoutButton: ElementDef = ElementDef(ComponentType.BUTTON, "Checkout", "checkout")

    private var cartItemsSum = 0.0

    fun cartCheckout(): CheckoutFirstPage{
        val cartItems = extractCartItems()
        cartItems.forEach {(itemName, itemPrice) ->
            println("Found item [$itemName with the price of $$itemPrice] in cart.")
        }
        println("Total  price items in cart is: $$cartItemsSum")
        elements().performClick(checkoutButton)

        return CheckoutFirstPage()
    }

    private fun extractCartItems(): Map<String, Double>{
        val cartItems = mutableMapOf<String, Double>()

        val cartList: List<WebElement> = elements().findElementsByClassName(ComponentType.FRAME,"cart_item")
        for (cartItem in cartList) {
            val cartItemName = cartItem.findElement(By.className("inventory_item_name")).text
            val cartItemPrice = cartItem.findElement(By.className("inventory_item_price")).text.removePrefix("$").toDoubleOrNull()

            if (cartItemName.isNotEmpty() && cartItemPrice != null){
                cartItems[cartItemName] = cartItemPrice
                cartItemsSum += cartItemPrice
            }
        }
        return cartItems
    }

    fun getCartItemSum(): Double{
        return cartItemsSum
    }
}