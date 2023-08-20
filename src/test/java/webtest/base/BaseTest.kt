package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CheckoutOverviewCheckStep
import webtest.base.step.MainPageTestStep
import webtest.base.step.ShoppingCartCheckStep
import webtest.page.app.CheckoutOverviewPage


class BaseTest : AbstractTestNew() {
    val testStep = MainPageTestStep()
    val testStep2 = ShoppingCartCheckStep()
    val testStep3 = CheckoutOverviewCheckStep()

    @Test
    fun exampleTest() {
        login()
        testStep.fillCart()
        testStep2.verifyItemsInCart()
        info()
        testStep3.checkPrice()
        logout()
    }
}