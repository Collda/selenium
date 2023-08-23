package webtest.base.step

import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep(){
    private val mainPage = MainPage()

    fun fillCart(){
        mainPage.addRandomItemsToCart(3)
    }

    fun getSum(): Double{
        return mainPage.getChosenItemSum()
    }

}
