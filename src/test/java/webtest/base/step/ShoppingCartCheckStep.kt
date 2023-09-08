package webtest.base.step

import org.openqa.selenium.By
import org.testng.Assert
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.app.CheckoutCompletePage
import webtest.page.app.ShoppingCartPage
import webtest.page.app.CheckoutOverviewPage
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartCheckStep: AbstractTestStep(){

   fun testovaciStep() {
       val shoppingCartPage = ShoppingCartPage()
       val checkoutOverviewPage = CheckoutOverviewPage()
       val checkOutPage = shoppingCartPage.clickOnCheckout()
       checkOutPage.checkoutOverviewInfo()
       checkoutOverviewPage.validateTotalPrice(shoppingCartPage.getCartItemsPriceSummary(),checkoutOverviewPage.getTotalPrice())
       checkoutOverviewPage.clickOnFinishButton()
   }
}

