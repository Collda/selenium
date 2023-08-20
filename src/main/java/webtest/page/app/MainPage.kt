package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))

    private val menu: ElementDef = ElementDef(ComponentType.BUTTON, "Menu", "react-burger-menu-btn")
    private val logout: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", "logout_sidebar_link")

    private val shoppingCartIcon: ElementDef = ElementDef(ComponentType.LINK, "Cart", By.className("shopping_cart_link"))


    val addToCartBackPackButton: ElementDef = ElementDef(ComponentType.BUTTON, "Backpack", "add-to-cart-sauce-labs-backpack")
    val addToCartFleeceJacketButton: ElementDef = ElementDef(ComponentType.BUTTON, "Fleece Jacket", "add-to-cart-sauce-labs-fleece-jacket")
    val addToCartBoltTShirtButton: ElementDef = ElementDef(ComponentType.BUTTON, "Bolt T-Shirt", "add-to-cart-sauce-labs-bolt-t-shirt")

    val itemIdentifiers: Map<String, ElementDef> = mapOf(
        "Backpack" to addToCartBackPackButton,
        "Fleece Jacket" to addToCartFleeceJacketButton,
        "Bolt T-Shirt" to addToCartBoltTShirtButton

    )
    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodažilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

    fun clickOnMenu() = elements().performClick(menu)

    fun clickOnLogoutButton() = elements().performClick(logout)


    fun clickOnAddToCart(def:ElementDef) = elements().performClick(def)

    fun clickOnShoppingCart():ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
        }

    }

