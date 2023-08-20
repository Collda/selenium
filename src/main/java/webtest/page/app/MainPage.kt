package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(logo).isDisplayed





    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))

    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodařilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

    private val menuButton: ElementDef = ElementDef(ComponentType.BUTTON, "Hamburger Menu", By.id("react-burger-menu-btn"))
    private val logout: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", By.id("logout_sidebar_link"))
    val addToCartBackpackButton: ElementDef = ElementDef(ComponentType.BUTTON,  "Add to cart", By.id("add-to-cart-sauce-labs-backpack"))
    val addToCartOnesieButton: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", By.id ("add-to-cart-sauce-labs-bolt-t-shirt"))
    val addToCartBoltTshirtButton: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", By.id ("add-to-cart-sauce-labs-onesie"))
    val removeBackpackButton: ElementDef = ElementDef(ComponentType.BUTTON,  "Add to cart", By.id("add-to-cart-sauce-labs-backpack"))
    val removeOnesieButton: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", By.id ("add-to-cart-sauce-labs-bolt-t-shirt"))
    val removeBoltTshirtButton: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", By.id ("add-to-cart-sauce-labs-onesie"))
    private val shoppingCartIcon: ElementDef = ElementDef(ComponentType.LINK, "Add to cart", By.className("shopping_cart_link"))
    public var cartItemsList: MutableList<String> = mutableListOf()



    fun clickOnMenu() = elements().performClick(menuButton)
    fun clickOnLogutButton() = elements().performClick(logout)

    fun clickOnAddToCart(def: ElementDef)  {
        elements().performClick(def)
    }

    fun getProductId(product: ElementDef) : String {

        var element = elements().findElement(product)
        val fullIdOfElement = element.getAttribute("id")
        val idOfElement = fullIdOfElement.removePrefix("add-to-cart-")
        val idToString = idOfElement.replace("-"," ").split(" ").map { it.capitalize() }.joinToString(" ")
        return idToString

    }

    fun addProductIdToList(productId: String): MutableList<String>{
        cartItemsList.add(productId)
        return cartItemsList
    }

        
    fun clickOnCart(): ShoppingCartPage {
            elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }

}