package webtest.base.step

import webtest.base.Assert.assertPageIsOpen
import webtest.page.app.MainPage

class MainPageTestStep: AbstractTestStep() {

    fun fillCart(){

        val mainPage = MainPage()
        mainPage.fillCartWithItems()
        val shoppingCartPage = mainPage.clickOnShoppingCart()
        assertPageIsOpen(shoppingCartPage)

        val MainPagePriceList = mutableMapOf<String, Double>()

        fun AddItemToMap() {

            //add item to the list
            MainPagePriceList["Backpack"] = 29.99
            MainPagePriceList["FleeceP"] = 49.99
            MainPagePriceList["Tshirt"] = 15.99

            }

            fun returnMainPageSum() {
                val PriceSumMainPage = MainPagePriceList.values.sumByDouble { it }
                println("Suma na mainpage: $PriceSumMainPage")
                //return PriceSumMainPage

            /* MainPage().run {
                 clickOnAddToCart(this.addToCartBackPackButton)
             }*/
    }
}