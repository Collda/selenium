package webtest.page.app

import webtest.page.common.AbstractTechnicalPage
import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef

class ShoppingCartPage:AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(cartContents).isDisplayed

    private val cartContents: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.className("cart_contents_container"))
    private val checkoutButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Checkout", By.id("checkout"))
    fun clickOnCheckoutButton():CheckOutStepOnePage {
        elements().performClick(checkoutButton)
        return CheckOutStepOnePage()
    }
    fun cartItem(): List<ElementDef>{
        val mainPage = MainPage()
        val cartItemList: List<ElementDef> = listOf(mainPage.getBackpackItem(),mainPage.getOnesieItem(),mainPage.getBikeLightItem())

        return cartItemList
    }
}