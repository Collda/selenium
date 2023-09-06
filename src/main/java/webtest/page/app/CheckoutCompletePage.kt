package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutCompletePage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(summaryContainer).isDisplayed
    private val summaryContainer: ElementDef = ElementDef(ComponentType.ANY, "", "checkout_complete_container")


    private val backHomeButton: ElementDef = ElementDef(ComponentType.BUTTON, "Back Home", "back-to-products")

    fun clickOnBackHomeButton(): MainPage {
        elements().performClick(backHomeButton)
        return MainPage()
    }
}