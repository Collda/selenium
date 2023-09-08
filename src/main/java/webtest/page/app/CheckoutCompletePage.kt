package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutCompletePage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkoutCompleteContainer).isDisplayed

    private val checkoutCompleteContainer: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.ByClassName("checkout_complete_container"))
}