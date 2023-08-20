package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutFirstPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = currentUrl.equals("https://www.saucedemo.com/checkout-step-one.html")

    private val firstNameInput: ElementDef = ElementDef(ComponentType.INPUT, "First Name", "first-name")
    private val lastNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Last Name", "last-name")
    private val zipCodeInput: ElementDef = ElementDef(ComponentType.INPUT, "Zip/Postal Code", "postal-code")
    private val continueButton: ElementDef = ElementDef(ComponentType.BUTTON, "Continue", "continue")

    fun fillInfoAndContinue() : CheckoutSecondPage{
        elements().setValue(firstNameInput, "Jan")
        elements().setValue(lastNameInput, "Kemr")
        elements().setValue(zipCodeInput, "66666")
        elements().performClick(continueButton)

        return CheckoutSecondPage()
    }
}