package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CartPage : AbstractTechnicalPage() {
    override fun isOpen() : Boolean { return elements().isDisplayed(cartContentFrame) }

    private val cartContentFrame: ElementDef = ElementDef(ComponentType.FRAME, "Cart Contents", By.id("cart_contents_container"))

}