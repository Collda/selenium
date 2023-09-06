package webtest.base.step

import webtest.base.Assert.assertPageIsOpen
import webtest.page.app.MainPage
class SortTestStep : AbstractTestStep() {

    fun sortProducts(){
        val mainPage = MainPage()
        mainPage.comparisonProductsByPriceAsc()
        mainPage.comparisonProductsByPriceDesc()
        mainPage.comparisonProductsAlphabeticallyAZ()
        mainPage.comparisonProductsAlphabeticallyZA()
    }
}