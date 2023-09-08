package webtest.base.step

import webtest.page.app.MainPage

class MainPageTestStep : AbstractTestStep() {


    fun fillCart() {
        val mainPage = MainPage()
        mainPage.clickOnAddToCart(mainPage.addToCartBackPackButton)
        mainPage.clickOnAddToCart(mainPage.addToCartFleeceJacketButton)
        mainPage.clickOnAddToCart(mainPage.addToCartBoltTShirtButton)

        mainPage.clickOnShoppingCart()
    }

    fun validateFiltrPricesHL() {
        val mainPageFiltrPriceHL = MainPage()
        mainPageFiltrPriceHL.clickOnSortPricesHL()
        val products = mainPageFiltrPriceHL.getProductsFromPage()
        val arePricesDescending = mainPageFiltrPriceHL.arePricesSortedByDescending(products)
        mainPageFiltrPriceHL.validatePricesSortedByDescending(arePricesDescending)
    }

    fun validateFiltrPricesLH() {
        val mainPageFiltrPriceLH = MainPage()
        mainPageFiltrPriceLH.clickOnSortPricesLH()
        val products = mainPageFiltrPriceLH.getProductsFromPage()
        val arePricesAscending = mainPageFiltrPriceLH.arePricesSortedByAscending(products)
        mainPageFiltrPriceLH.validatePricesSortedByAscending(arePricesAscending)
    }

    fun validateFiltrAZ() {
        val mainPageFiltrNameAZ = MainPage()
        mainPageFiltrNameAZ.clickOnSortNameAZ()
        val areNamesAscending = mainPageFiltrNameAZ.areNamesSortedByAscending(mainPageFiltrNameAZ.getProductsFromPage().keys.toList())
        mainPageFiltrNameAZ.validateNameSortedByAscending(areNamesAscending)
    }

    fun validateFiltrZA() {
        val mainPageFiltrNameZA = MainPage()
        mainPageFiltrNameZA.clickOnSortNameZA()
        val areNamesDescending = mainPageFiltrNameZA.areNamesSortedByDescending(mainPageFiltrNameZA.getProductsFromPage().keys.toList())
        mainPageFiltrNameZA.validateNameSortedByDescending(areNamesDescending)
    }
}



