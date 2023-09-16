package webtest.base.step

import webtest.page.app.MainPage

class MainPageTestStep {


    fun fillCart() {

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

    fun openCart() {
        MainPage().run {
            clickOnCart()
        }
    }

    fun testFilter(filter: String) {
        val listOne = MainPage().getSortedMapBy(filter)
        MainPage().selectFilter(filter)
        val listTwo = MainPage().getItemList().toMap()
        if (listOne == listTwo) {
            println("Filtr $filter funguje správně")
        } else {
            println("Filtr $filter nefiltruje správně")
        }
    }

}