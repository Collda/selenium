package webtest.base.step

import webtest.page.app.CartPage

class CartPageTestStep: AbstractTestStep() {
    private val cartPage = CartPage()
    fun checkCartAndContinue() {
        cartPage.cartCheckout()
    }

    fun getSum(): Double {
        return cartPage.getCartItemSum()
    }

}