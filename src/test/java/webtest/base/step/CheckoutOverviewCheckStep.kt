package webtest.base.step

import org.testng.Assert
import webtest.page.app.CheckoutOverviewPage
import webtest.page.app.ShoppingCartPage
import kotlin.test.assertTrue

class CheckoutOverviewCheckStep: AbstractTestStep(){
    fun checkPrice(){
        val shoppingCartPage = ShoppingCartPage()
        val totalCartPrice = shoppingCartPage.getTotalCartPrice()
        println("Cena všech produktů v košíků: $totalCartPrice")

        val checkoutPage = CheckoutOverviewPage()
        val totalCheckoutPrice = checkoutPage.getTotalCheckoutPrice()
        println("Celková cena: $totalCheckoutPrice")

        assert(totalCartPrice == totalCheckoutPrice) {"Celková cena v košíku neodpovídá celkové ceně na pokladně!"}
    }
}
