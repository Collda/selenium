package webtest.base.step

import webtest.page.app.MainPage
import webtest.base.Assert.assertPageIsOpen

class MainPageTestStep:AbstractTestStep() {

    fun fillCart(){

        val mainPage = MainPage()
        mainPage.fillCartWithItems()
        val shoppingCartPage = mainPage.clickOnShoppingCart()
        assertPageIsOpen(shoppingCartPage)
    }
}