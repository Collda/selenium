package webtest.base.step
import webtest.page.app.MainPage
import webtest.page.app.ShoppingCartPage

class ShoppingCartTestStep: AbstractTestStep() {
    val itemList = MainPage().cartItemsList
    val shoppingCartPage = ShoppingCartPage()
fun checkBoughtElements() {

    for (element in itemList) {
        shoppingCartPage.verifyRightProductInserted(element)

    }
}

    fun calculateTotalPrice(){

        val itemList = MainPage().cartItemsList
        for (element in itemList){
            shoppingCartPage.addItemPriceToCurrentPrice(itemList.indexOf(element))
        }
    }

fun clickOnCheckoutButton(){

    shoppingCartPage.clickOnCheckoutButton()

}

}