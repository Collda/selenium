package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutYourInformationPage: AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkoutInfo).isDisplayed

    private val checkoutInfo: ElementDef = ElementDef(ComponentType.BUTTON, "", "checkout_info_container")

    private val firstNameInput: ElementDef = ElementDef(ComponentType.INPUT, "First Name", "first-name")
    private val lastNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Last Name", "last-name")
    private val postalCodeInput: ElementDef = ElementDef(ComponentType.INPUT, "Zip/Postal Code", "postal-code")
    private val continueButton: ElementDef = ElementDef(ComponentType.BUTTON, "Continue", "continue")

    fun clickOnContinueButton() = elements().performClick(continueButton)
    fun fillInfo(firstName: String, lastName: String, postalCode: String){
        elements().setValue(firstNameInput, firstName)
        elements().setValue(lastNameInput, lastName)
        elements().setValue(postalCodeInput, postalCode)
    }
}