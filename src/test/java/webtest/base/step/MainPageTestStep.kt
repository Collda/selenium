package webtest.base.step

import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep(){
    fun fillCart(){
        val mainPage = MainPage()
        mainPage.addRandomItemsToCart(3)
    }
}
