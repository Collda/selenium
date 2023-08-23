package webtest.base.step

import webtest.page.app.CheckoutSecondPage

class CheckoutSecondPageTestStep: AbstractTestStep() {
    fun finalizeCheckout(selectedSum: Double, cartSum: Double){
        val checkoutSecondPage = CheckoutSecondPage()
        checkoutSecondPage.checkTotalPrice(selectedSum,cartSum)
    }
}