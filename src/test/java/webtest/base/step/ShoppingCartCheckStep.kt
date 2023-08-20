package webtest.base.step

import org.openqa.selenium.By
import org.testng.Assert
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.app.ShoppingCartPage
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartCheckStep: AbstractTestStep(){


   fun verifyItemsInCart() {
        val shoppingCartPage = ShoppingCartPage()
        assert(shoppingCartPage.verifyItemsInCart()) {"V košíku nejsou všechny očekávané položky!"}

        shoppingCartPage.clickOnCheckout()
    }

}

