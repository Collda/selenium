package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckoutFormPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(firstNameText).isDisplayed

    val firstNameText: ElementDef = ElementDef(ComponentType.INPUT, "First Name", By.id("first-name"))
    val lastNameText: ElementDef = ElementDef(ComponentType.INPUT, "Last Name", By.id("last-name"))
    val postalCodeText: ElementDef = ElementDef(ComponentType.INPUT, "Postal Code", By.id("postal-code"))
    val continueButton: ElementDef = ElementDef(ComponentType.BUTTON,"Continue", By.id("continue"))

    fun fillRow(row: ElementDef, text: String) {
        elements().setValue(row, text)
    }

    fun clickOnContinueButton() = elements().performClick(continueButton)

}