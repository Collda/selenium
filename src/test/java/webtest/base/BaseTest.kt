package webtest.base

import org.testng.annotations.Test
import webtest.base.step.CheckOutFormPageTestStep
import webtest.base.step.CheckOutPageTestStep
import webtest.base.step.MainPageTestStep
import webtest.base.step.ShoppingCartTestStep


class BaseTest : AbstractTestNew() {
    val testStep = MainPageTestStep()
    val testStep2 = ShoppingCartTestStep()
    val testStep3 = CheckOutFormPageTestStep()
    val testStep4 = CheckOutPageTestStep()
    @Test
    fun exampleTest() {
        login()
        testStep.fillCart()
        testStep2.checkBoughtElements()
        testStep2.calculateTotalPrice()
        testStep2.clickOnCheckoutButton()
        testStep3.fillInAndContinue()
        testStep4.VerifyPrices()

    }
}