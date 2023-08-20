package webtest.base.step

import webtest.base.ElementDef
import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep(){

    fun fillCart(){
            val mainPage = MainPage()
            mainPage.clickOnAddToCart(mainPage.addToCartBackPackButton)
            mainPage.clickOnAddToCart(mainPage.addToCartFleeceJacketButton)
            mainPage.clickOnAddToCart(mainPage.addToCartBoltTShirtButton)

            mainPage.clickOnShoppingCart()
    }
}