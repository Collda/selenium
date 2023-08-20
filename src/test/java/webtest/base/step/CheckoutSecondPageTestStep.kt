package webtest.base.step

import webtest.page.app.CheckoutSecondPage

class CheckoutSecondPageTestStep: AbstractTestStep() {
    fun finalizeCheckout(){
        val checkoutSecondPage = CheckoutSecondPage()
        checkoutSecondPage.checkTotalPrice()
    }
}