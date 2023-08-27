package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckOutStepOnePage:AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkOutContainer).isDisplayed

    private val checkOutContainer: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.id("checkout_info_container"))

    private val firstNameInput: ElementDef =
        ElementDef(ComponentType.INPUT, "", By.id("first-name"))
    private val lastNameInput: ElementDef =
        ElementDef(ComponentType.INPUT, "", By.id("last-name"))
    private val postalCodeInput: ElementDef =
        ElementDef(ComponentType.INPUT, "", By.id("postal-code"))

    private val continueButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "", By.id("continue"))

    fun clickToContinueButton():CheckOutStepTwoPage{
        elements().performClick(continueButton)
        return CheckOutStepTwoPage()
    }

    fun clientInformation(firstName: String, lastName: String, postalCode:String){
        elements().setValue(firstNameInput,firstName)
        elements().setValue(lastNameInput, lastName)
        elements().setValue(postalCodeInput, postalCode)
    }



}