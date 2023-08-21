package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(logo).isDisplayed

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val burgerMenuIcon: ElementDef =
        ElementDef(ComponentType.BUTTON, "Hamburger menu", By.className("bm-burger-button"))

    private val shoppingCartIcon: ElementDef =
        ElementDef(ComponentType.LINK, "Icon of Cart", By.className("shopping_cart_link"))

    private val addToCartBackPackButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-backpack")
    private val addToCartTShirtButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-bolt-t-shirt")
    private val addToCartFleecePackButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-fleece-jacket")

    fun clickOnHamburgerMenu(): HamBurgerMenu {
        elements().performClick(burgerMenuIcon)
        return HamBurgerMenu()
    }

    fun clickOnAddToCart(def: ElementDef) = elements().performClick(def)

    fun clickOnShoppingCart(): ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }

    fun fillCartWithItems() {
        clickOnAddToCart(addToCartBackPackButton)
        clickOnAddToCart(addToCartFleecePackButton)
        clickOnAddToCart(addToCartTShirtButton)

    }


}