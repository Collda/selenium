package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CartPageTestStep
import webtest.base.step.CheckoutFirstPageTestStep
import webtest.base.step.CheckoutSecondPageTestStep
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        val mainTestStep = MainPageTestStep()
        val cartTestStep = CartPageTestStep()
        val checkoutFirstStep = CheckoutFirstPageTestStep()
        val checkoutSecondStep = CheckoutSecondPageTestStep()
        //login().validateLoggedIn()
        login()
            mainTestStep.fillCart()
            cartTestStep.checkCartAndContinue()
            checkoutFirstStep.fillDetailsAndContinue()
            checkoutSecondStep.finalizeCheckout(mainTestStep.getSum(),cartTestStep.getSum())
        logout()
    }
}