package webtest.page.app

import webtest.base.ComponentType
import webtest.page.common.AbstractTechnicalPage
import webtest.base.ElementDef
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import kotlin.math.roundToInt

class ShoppingCartPage: AbstractTechnicalPage() {


    override fun isOpen(): Boolean = elements().findElement(cartContent).isDisplayed


    private val cartContent: ElementDef = ElementDef(ComponentType.FRAME,"", By.ByClassName("cart_contents_container"))
    private val checkoutButton: ElementDef = ElementDef(ComponentType.BUTTON,"Checkout", By.id("checkout"))
    public var totalPrice: Double = 0.0

    private val cartItemFrame: ElementDef = ElementDef(ComponentType.FRAME,"", By.className("cart_item"))
    private val inventoryItemName: ElementDef = ElementDef(ComponentType.LABEL,"", By.className("inventory_item_name"))
    private val inventoryItemPrice: ElementDef = ElementDef(ComponentType.LABEL, "",By.className("inventory_item_price"))


    fun getCartItemsPriceSummary(): Double = totalPrice

    //TODO rozdelit scitani konecne ceny do samostatne meody
    private fun getShoppingCartItems(): MutableMap<String, Double> {
        val cartItems = mutableMapOf<String, Double>()
        val cartItemList: MutableList<WebElement>? = elements().findElements(cartItemFrame)

        val name = elements().findElement(inventoryItemName).text
        val price = elements().findElement(inventoryItemPrice).text.removePrefix("$").toDoubleOrNull()

        for (product in cartItemList!!) {
            if (name.isNotEmpty() && price != null) {
                cartItems[name] = price
                totalPrice += price

            }
        }
        return cartItems
    }




    fun verifyRightProductInserted(product: String): Boolean{

        val productText: ElementDef = ElementDef(ComponentType.LABEL,  "", By.xpath("//div[@class='inventory_item_name' and text()='${product}']"))
        return elements().isDisplayed(productText)

    }

    fun addItemPriceToCurrentPrice(prodNumber: Int){
        val priceLabel: ElementDef = ElementDef(ComponentType.LABEL,"Price", By.xpath("(//div[@class='inventory_item_price'])[${prodNumber}]"))

        val price = elements().findElement(priceLabel)
        val priceOfProduct = price.getText().removePrefix("$").toDouble()

        totalPrice = (totalPrice + priceOfProduct)

    }

    fun clickOnCheckoutButton()=  elements().performClick(checkoutButton)











}