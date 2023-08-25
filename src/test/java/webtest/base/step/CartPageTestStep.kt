package webtest.base.step

import webtest.base.Assert
import webtest.page.app.ShoppingCartPage

class CartPageTestStep:AbstractTestStep() {

    fun checkCart(){
        val shoppingCartPage = ShoppingCartPage()

        for(item in shoppingCartPage.cartItem()){
            Assert.assertElementIsDisplayed(shoppingCartPage, item)
        }
    }
}