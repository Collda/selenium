package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class FillYourInformationPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(checkoutInfo).isDisplayed

    private val checkoutInfo: ElementDef = ElementDef(ComponentType.BUTTON, "", "checkout_info_container")

    private val userFistName: ElementDef = ElementDef(ComponentType.INPUT, "FirstName", "first-name")
    private val userLastName: ElementDef = ElementDef(ComponentType.INPUT, "LastName", "last-name")
    private val userPostalCode: ElementDef = ElementDef(ComponentType.INPUT, "PostalCode", "postal-code")

    private val continueButton: ElementDef = ElementDef(ComponentType.BUTTON, "Continue", "continue")

    fun clickOnContinueButton(): ShoppingCartFinalPage {
        elements().performClick(continueButton)
        return ShoppingCartFinalPage()
    }
    fun fillUserInfo(firstName: String, lastName: String, postalCode: String){
        elements().setValue(userFistName, firstName)
        elements().setValue(userLastName, lastName)
        elements().setValue(userPostalCode, postalCode)
    }



}