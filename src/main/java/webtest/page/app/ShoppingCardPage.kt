package webtest.page.app

import webtest.base.ComponentType
import webtest.page.common.AbstractTechnicalPage
import webtest.base.ElementDef
import org.openqa.selenium.By
import kotlin.math.roundToInt

class ShoppingCartPage: AbstractTechnicalPage() {


    override fun isOpen(): Boolean = elements().findElement(cartContent).isDisplayed


    private val cartContent: ElementDef = ElementDef(ComponentType.FRAME,"", By.ByClassName("cart_contents_container"))
    private val checkoutButton: ElementDef = ElementDef(ComponentType.BUTTON,"Checkout", By.id("checkout"))
    public var totalPrice: Double = 0.0




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