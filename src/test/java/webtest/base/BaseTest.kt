package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CartCheckStep
import webtest.base.step.MainPageTestStep
import webtest.base.step.SortTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val mainPageTesStep = MainPageTestStep()
        val cartCheckStep = CartCheckStep()
        val sortTestStep = SortTestStep()
        mainPageTesStep.fillCart()
        cartCheckStep.verifyItemsInCart()
        clickBackHomeButton()
        sortTestStep.sortProducts()
        logout()
    }
}