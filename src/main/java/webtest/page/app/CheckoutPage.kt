package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkoutInfoContainer).isDisplayed

    private val checkoutInfoContainer: ElementDef = ElementDef(ComponentType.ANY, "", "checkout_info_container")

    private val firstNameInput: ElementDef = ElementDef(ComponentType.INPUT, "First Name", "first-name")
    private val lastNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Last Name", "last-name")
    private val postalCodeInput: ElementDef = ElementDef(ComponentType.INPUT, "Zip/Postal Code", "postal-code")

    private val continueButton: ElementDef = ElementDef(ComponentType.BUTTON, "Continue", "continue")

    fun clickOnContinue(): ShoppingCartPageTwo {
        elements().performClick(continueButton)
        return ShoppingCartPageTwo()
    }

    fun fillForm() {
        elements().run {
            setValue(firstNameInput, "Pepa")
            setValue(lastNameInput, "Zdepa")
            setValue(postalCodeInput, "19000")
        }

    }
}