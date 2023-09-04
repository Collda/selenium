package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep
import webtest.base.step.ShoppingCartTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val testStep = MainPageTestStep()
        val fujStep = ShoppingCartTestStep()
        testStep.fillCart()
        fujStep.fujStep()
        logout()
    }
}