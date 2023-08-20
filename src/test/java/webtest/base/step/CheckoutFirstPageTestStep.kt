package webtest.base.step

import webtest.page.app.CheckoutFirstPage

class CheckoutFirstPageTestStep: AbstractTestStep()  {
    fun fillDetailsAndContinue() {
        val checkoutFirstPage = CheckoutFirstPage()
        checkoutFirstPage.fillInfoAndContinue()
    }
}