package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckOutInfoPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(yourInfo).isDisplayed

    private val yourInfo: ElementDef = ElementDef(ComponentType.FRAME, "Checkout: Your Information", By.className("title"))
    private val firstName: ElementDef = ElementDef(ComponentType.TEXT_INPUT,"First Name","first-name")
    private val lastName: ElementDef = ElementDef(ComponentType.TEXT_INPUT,"Last Name","last-name")
    private val postalCode: ElementDef = ElementDef(ComponentType.TEXT_INPUT,"Postal Code","postal-code")
    private val continueNext: ElementDef= ElementDef(ComponentType.BUTTON,"Continue", "continue")
    fun fillInfo(name: String, surname: String, zip: String) {
        elements().setValue(firstName, name)
        elements().setValue(lastName, surname)
        elements().setValue(postalCode, zip)

    }
    fun clickOnContinue():CheckOutOverview{
    elements().performClick(continueNext)
        return CheckOutOverview()
    }


}