package webtest.base.step

import webtest.base.Assert.assertPageIsOpen
import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep() {

    fun fillCart(){

        val mainPage = MainPage()
        mainPage.fillCartWithItems()
        val shoppingCartPage = mainPage.clickOnShoppingCart()
        assertPageIsOpen(shoppingCartPage)

       /* MainPage().run {
            clickOnAddToCart(this.addToCartBackPackButton)
        }*/
    }
}