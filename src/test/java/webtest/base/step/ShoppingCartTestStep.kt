package webtest.base.step

import webtest.page.app.ShoppingCartPageOne

class ShoppingCartTestStep: AbstractTestStep() {


    fun fujStep(){
        val shoppingCartPageOne = ShoppingCartPageOne()
        val checkOutPage = shoppingCartPageOne.clickOnCheckout()
        checkOutPage.fillForm()
        val shoppingCartPageTwo  = checkOutPage.clickOnContinue()
        shoppingCartPageTwo.validateTotalPrice(shoppingCartPageOne.getCartItemsPriceSummary(),shoppingCartPageTwo.getTotalPrice())



    }

}