package webtest.base.step

import webtest.page.app.ShoppingCartPage
import webtest.page.app.ShoppingCartFinalPage

class CartCheckStep: AbstractTestStep(){


    fun verifyItemsInCart() {
        val shoppingCartPage = ShoppingCartPage()
        val fillYourInformationPage = shoppingCartPage.clickOnCheckout()
        fillYourInformationPage.fillUserInfo("Petr", "Svatý", "11098")
        val shoppingCartFinalPage  = fillYourInformationPage.clickOnContinueButton()
        shoppingCartFinalPage.validateTotalPrice(shoppingCartPage.getCartItemsPriceSummary(),shoppingCartFinalPage.getTotalPrice())
    }
}