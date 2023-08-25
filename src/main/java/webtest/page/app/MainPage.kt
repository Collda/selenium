package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(logo).isDisplayed

    private val logo: ElementDef =
        ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))

    private val menuButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Open Menu", By.id("react-burger-menu-btn"))
    private val logoutButton: ElementDef =
        ElementDef(ComponentType.MAIN_MENU_ITEM, "Logout", By.id("logout_sidebar_link"))

    private val shoppingCartIcon: ElementDef =
        ElementDef(ComponentType.LINK, "Icon of Cart", By.className("shopping_cart_link"))

    private val addToCartBackpackButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-backpack"))
    private val backpackItem: ElementDef =
        ElementDef(ComponentType.LABEL, "Sauce Labs Backpack", By.id("item_4_title_link"))

    private val addToCartOnesieButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-onesie"))
    private val onesieItem: ElementDef =
        ElementDef(ComponentType.LABEL, "Sauce Labs Onesie", By.id("item_2_title_link"))

    private val addToCartLightsButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-bike-light"))
    private val bikeLightItem: ElementDef =
        ElementDef(ComponentType.LABEL, "Sauce Labs Bike Light", By.id("item_0_title_link"))

    fun clickOnMenuButton() = elements().performClick(menuButton)
    fun clickOnLogoutButton() = elements().performClick(logoutButton)
    private fun clickOnAddToCart(def: ElementDef) = elements().performClick(def)

    fun clickOnShoppingCart():ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }
    fun fillCartWithItems() {
        clickOnAddToCart(addToCartBackpackButton)
        clickOnAddToCart(addToCartOnesieButton)
        clickOnAddToCart(addToCartLightsButton)
    }
    fun getBackpackItem():ElementDef{
        return backpackItem
    }
    fun getOnesieItem():ElementDef{
        return onesieItem
    }
    fun getBikeLightItem():ElementDef {
        return bikeLightItem
    }
}