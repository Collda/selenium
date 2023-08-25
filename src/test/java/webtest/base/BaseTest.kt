package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CartPageTestStep
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val testStep = MainPageTestStep()
        testStep.fillCart()
        val testStep2 = CartPageTestStep()
        testStep2.checkCart()
        logout()
    }


}