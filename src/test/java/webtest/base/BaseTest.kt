package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CartCheckStep
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val testStep = MainPageTestStep()
        val testStep2 = CartCheckStep()
        //login()
        testStep.fillCart()
        testStep2.verifyItemsInCart()

        userInformation()

        logout()
    }
}