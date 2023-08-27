package webtest.base.step

import webtest.base.Assert
import webtest.page.app.CheckOutStepTwoPage
import webtest.page.app.ShoppingCartPage
import kotlin.test.assertEquals

class CheckoutTestStep:AbstractTestStep() {

    fun fillClientInformation() {
        val shoppingCartPage = ShoppingCartPage()

        val checkoutPage = shoppingCartPage.clickOnCheckoutButton()
        Assert.assertPageIsOpen(checkoutPage)

        checkoutPage.clientInformation("Test", "Test", "Test")
        checkoutPage.clickToContinueButton()
    }

    fun checkCartSum(expectedSum : Float) {
        val checkOut = CheckOutStepTwoPage()
        val actualSum = checkOut.getTotalCartSum().toFloat()
        assertEquals(expectedSum, actualSum)
    }


}