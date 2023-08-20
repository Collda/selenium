package webtest.base.step

import webtest.page.app.CartPage
import webtest.page.app.MainPage

class CartPageTestStep: AbstractTestStep() {
    fun checkCartAndContinue() {
        val cartPage = CartPage()
        cartPage.cartCheckout()
    }
}