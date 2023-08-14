package webtest.base.step

import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep() {

    fun fillCart(){

        val mainPage = MainPage()
        mainPage.clickOnAddToCart(mainPage.addToCartBackPackButton)
        mainPage.clickOnAddToCart(mainPage.addToCartFleecePackButton)
        mainPage.clickOnAddToCart(mainPage.addToCartTShirtButton)

        mainPage.clickOnShoppingCart().isOpen

       /* MainPage().run {
            clickOnAddToCart(this.addToCartBackPackButton)
        }*/
    }
}