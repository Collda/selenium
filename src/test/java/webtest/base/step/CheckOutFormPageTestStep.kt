package webtest.base.step

import webtest.page.app.CheckOutPage
import webtest.page.app.CheckoutFormPage

class CheckOutFormPageTestStep : AbstractTestStep() {

    fun fillInAndContinue(): CheckOutPage {
    CheckoutFormPage().run{
        fillRow(this.firstNameText,"First Name")
        fillRow(this.lastNameText,"Last Name")
        fillRow(this.postalCodeText,"19000")
        clickOnContinueButton()
        return CheckOutPage()
    }

    }

}