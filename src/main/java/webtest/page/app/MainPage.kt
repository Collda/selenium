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



    private val BackPack: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-backpack")
    private val BikeLight: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-bike-light")
    private val Tshirt: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-bolt-t-shirt")
    private val Jacket: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-fleece-jacket")
    private val Onesie: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-sauce-labs-onesie")
    private val RedTshirt: ElementDef = ElementDef(ComponentType.BUTTON, "Add to cart", "add-to-cart-test.allthethings()-t-shirt-(red)")
    data class Item(val element:ElementDef, val name: String, val price: Double)

    private val productPrices = listOf(
        Item(BackPack,"Sauce Labs Backpack",29.99),
        Item(BikeLight,"Sauce Labs Bike Light", 9.99),
        Item(Tshirt,"Sauce Labs Bolt T-Shirt", 15.99),
        Item(Jacket,"Sauce Labs Fleece Jacket", 49.99),
        Item(Onesie,"Sauce Labs Onesie",7.99),
        Item(RedTshirt,"Test.allTheThings() T-Shirt (Red)", 15.99)
    )

    fun clickOnHamburgerMenu(): HamBurgerMenu {
        elements().performClick(burgerMenuIcon)
        return HamBurgerMenu()
    }

    fun clickOnAddToCart(def: ElementDef) = elements().performClick(def)

    fun clickOnShoppingCart(): ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }

    /*fun fillCartWithItems() {
        clickOnAddToCart(addToCartBackPackButton)
        clickOnAddToCart(addToCartFleecePackButton)
        clickOnAddToCart(addToCartTShirtButton)

    }*/
    fun fillCartWithRandomItems(){

        val selectedProducts = productPrices.shuffled().take(3)
        var total = 0.0

        println("Náhodně vybrané produkty:")
        for (item in selectedProducts) {
            total+=item.price
            println("Produkt: ${item.name}, Cena: $${item.price}")
            clickOnAddToCart(item.element)
        }
        println("Celková cena vybraných produktů je $$total")
        TotalStorage.totalValue=total
    }




}