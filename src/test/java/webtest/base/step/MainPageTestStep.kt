package webtest.base.step
import webtest.page.app.MainPage
class MainPageTestStep {


    fun fillCart(){

        MainPage().run {
            addProductIdToList(getProductId(this.addToCartBackpackButton))
            clickOnAddToCart(this.addToCartBackpackButton)
            addProductIdToList(getProductId(this.addToCartOnesieButton))
            clickOnAddToCart(this.addToCartOnesieButton)
            addProductIdToList(getProductId(this.addToCartBoltTshirtButton))
            clickOnAddToCart(this.addToCartBoltTshirtButton)
            clickOnCart()
        }
    }
    fun OpenCart()
    {
        MainPage().run {
            clickOnCart()
        }
    }

}