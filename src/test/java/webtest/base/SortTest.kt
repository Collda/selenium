package webtest.base

import org.testng.annotations.Test
import webtest.page.app.MainPage

class SortTest : AbstractTestNew() {
    val mainPage = MainPage()
    @Test
    fun sortCheck(){
        login2()
        mainPage.run {
            println("Does nameAZ sorting work? " + checkSorting("az"))
            println("Does nameZA sorting work? " + checkSorting("za"))
            println("Does priceLowHigh sorting work? " + checkSorting("lohi"))
            println("Does priceHighLow sorting work? " + checkSorting("hilo"))
        }
        logout()
    }

}