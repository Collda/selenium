package webtest.base

import org.testng.annotations.Test
//import webtest.base.step.CartPageTestStep
import webtest.base.step.CheckoutTestStep
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val testStep = MainPageTestStep()
        val sum = testStep.cartItemSum()
        testStep.fillCart()
        /*val testStep2 = CartPageTestStep()w
        testStep2.checkCart()*/
        val testStep3 = CheckoutTestStep()
        testStep3.fillClientInformation()
        testStep3.checkCartSum(sum)
        logout()
    }


}