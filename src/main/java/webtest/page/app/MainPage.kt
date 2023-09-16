package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
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

    private val menuButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Hamburger Menu", By.id("react-burger-menu-btn"))
    private val logout: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", By.id("logout_sidebar_link"))
    val addToCartBackpackButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-backpack"))
    val addToCartOnesieButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
    val addToCartBoltTshirtButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Add to cart", By.id("add-to-cart-sauce-labs-onesie"))
    private val shoppingCartIcon: ElementDef =
        ElementDef(ComponentType.LINK, "Add to cart", By.className("shopping_cart_link"))

    private val cartItemFrame: ElementDef = ElementDef(ComponentType.FRAME, "", By.className("cart_item"))
    private val inventoryItemName: ElementDef = ElementDef(ComponentType.LABEL, "", By.className("inventory_item_name"))
    private val inventoryItemPrice: ElementDef =
        ElementDef(ComponentType.LABEL, "", By.className("inventory_item_price"))

    private val selectFilter: ElementDef =
        ElementDef(ComponentType.ANY, "Filter", By.className("product_sort_container"))


    fun getItemList(): MutableList<Pair<String, Double>> {
        val itemList = mutableListOf<Pair<String, Double>>()
        val cartItemList: MutableList<WebElement>? = elements().findElements(cartItemFrame)

        for (product in cartItemList!!) {
            val name = product.findElement(By.className("inventory_item_name")).text
            val price =
                product.findElement(By.className("inventory_item_price")).text.removePrefix("$").toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                itemList.add(Pair(name, price))
            }
        }

        return itemList
    }

    fun getSortedMapBy(sorting: String): Map<String, Double> {

        return when (sorting) {
            "hilo" -> getItemList().toList().sortedByDescending { (_, price) -> price }.toMap()
            "lohi" -> getItemList().toList().sortedBy { (_, price) -> price }.toMap()
            "za" -> getItemList().toMap().toSortedMap(compareByDescending { it })

            else -> {
                getItemList().toMap().toSortedMap(compareBy { it })
            }
        }


    }

    fun selectFilter(filterOption: String) {
        val select = Select(elements().findElement(selectFilter))
        select.selectByValue(filterOption)
    }


    public var cartItemsList: MutableList<String> = mutableListOf()


    fun clickOnMenu() = elements().performClick(menuButton)
    fun clickOnLogutButton() = elements().performClick(logout)

    fun clickOnAddToCart(def: ElementDef) {
        elements().performClick(def)
    }

    fun getProductId(product: ElementDef): String {

        var element = elements().findElement(product)
        val fullIdOfElement = element.getAttribute("id")
        val idOfElement = fullIdOfElement.removePrefix("add-to-cart-")
        val idToString = idOfElement.replace("-", " ").split(" ").map { it.capitalize() }.joinToString(" ")
        return idToString

    }

    fun addProductIdToList(productId: String): MutableList<String> {
        cartItemsList.add(productId)
        return cartItemsList
    }


    fun clickOnCart(): ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }

}