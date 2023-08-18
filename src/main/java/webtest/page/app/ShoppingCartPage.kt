package webtest.page.app

import webtest.page.common.AbstractTechnicalPage
import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef

class ShoppingCartPage:AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(cartContents).isDisplayed

    private val cartContents: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.className("cart_contents_container"))
}