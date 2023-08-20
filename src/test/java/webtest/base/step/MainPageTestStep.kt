package webtest.base.step

import webtest.base.Assert.assertPageIsOpen
import webtest.page.app.CheckOutInfoPage
import webtest.page.app.CheckOutOverview
import webtest.page.app.MainPage
import webtest.page.app.ShoppingCartPage

class MainPageTestStep: AbstractTestStep() {

    fun fillCart(){

        val mainPage = MainPage()
        mainPage.fillCartWithRandomItems()
        val shoppingCartPage = mainPage.clickOnShoppingCart()
        assertPageIsOpen(shoppingCartPage)

       /* MainPage().run {
            clickOnAddToCart(this.addToCartBackPackButton)
        }*/
    }
    fun checkOut(){
        val shoppingCartPage = ShoppingCartPage()
    val checkOutPage = shoppingCartPage.clickOnCheckOut()
        assertPageIsOpen(checkOutPage)
        val checkOutPageInfo = CheckOutInfoPage()
        checkOutPageInfo.fillInfo("Tomáš", "Jedno","12345")
        checkOutPageInfo.clickOnContinue()
        val checkOutOverview =CheckOutOverview()
        checkOutOverview.compare()
    }


}