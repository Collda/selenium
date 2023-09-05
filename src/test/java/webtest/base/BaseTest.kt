package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CartCheckStep
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val mainPageTesStep = MainPageTestStep()
        val cartCheckStep = CartCheckStep()
        mainPageTesStep.fillCart()
        cartCheckStep.verifyItemsInCart()


        logout()
    }
}