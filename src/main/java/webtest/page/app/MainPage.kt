package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))

    private val menu: ElementDef = ElementDef(ComponentType.BUTTON, "Menu", "react-burger-menu-btn")
    private val logout: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", "logout_sidebar_link")

    private val shoppingCartIcon: ElementDef =
        ElementDef(ComponentType.LINK, "Cart", By.className("shopping_cart_link"))


    val addToCartBackPackButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Backpack", "add-to-cart-sauce-labs-backpack")
    val addToCartFleeceJacketButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Fleece Jacket", "add-to-cart-sauce-labs-fleece-jacket")
    val addToCartBoltTShirtButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Bolt T-Shirt", "add-to-cart-sauce-labs-bolt-t-shirt")

    private val sortProductsByNameAZ: ElementDef =
        ElementDef(ComponentType.ANY, "Name (A to Z)", By.xpath("//option[@value = 'az']"))
    private val sortProductsByNameZA: ElementDef =
        ElementDef(ComponentType.ANY, "Name (Z to A)", By.xpath("//option[@value = 'za']"))
    private val sortProductsByPriceLH: ElementDef =
        ElementDef(ComponentType.ANY, "Price (low to high)", By.xpath("//option[@value = 'lohi']"))
    private val sortProductsByPriceHL: ElementDef =
        ElementDef(ComponentType.ANY, "Price (high to low)", By.xpath("//option[@value = 'hilo']"))

    private val inventoryItemFrame: ElementDef = ElementDef(ComponentType.FRAME, "", By.className("inventory_item"))
    private val inventoryItemName: ElementDef = ElementDef(ComponentType.LABEL, "", By.className("inventory_item_name"))
    private val inventoryItemPrice: ElementDef =
        ElementDef(ComponentType.LABEL, "", By.className("inventory_item_price"))

    fun clickOnSortPricesHL() = elements().performClick(sortProductsByPriceHL)

    fun clickOnSortPricesLH() = elements().performClick(sortProductsByPriceLH)

    fun clickOnSortNameAZ() = elements().performClick(sortProductsByNameAZ)

    fun clickOnSortNameZA() = elements().performClick(sortProductsByNameZA)

    fun getProductsFromPage(): MutableMap<String, Double> {
        val inventoryItems = mutableMapOf<String, Double>()
        val inventoryItemList: MutableList<WebElement>? = elements().findElements(inventoryItemFrame)

        for (product in inventoryItemList.orEmpty()) {
            val nameElement = product.findElement(inventoryItemName.selector)
            val name = nameElement.text
            val priceText = product.findElement(inventoryItemPrice.selector).text
            val price = priceText.removePrefix("$").toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                inventoryItems[name] = price
            }
        }
        return inventoryItems
    }
    fun arePricesSortedByAscending(inventoryItems: Map<String, Double>): Boolean {
        var previousPrice: Double? = null

        for (price in inventoryItems.values) {
            if (previousPrice != null && price < previousPrice) {
                return false
            }
            previousPrice = price
        }

        return true
    }
    fun validatePricesSortedByAscending(arePricesAscending: Boolean) {
        val products = getProductsFromPage()
        val arePricesAscending = arePricesSortedByAscending(products)

        if (arePricesAscending) {
            println("Ceny produktů jsou řazeny vzestupně.")
        } else {
            println("Ceny produktů nejsou řazeny vzestupně.")
        }
    }
    fun arePricesSortedByDescending(inventoryItems: Map<String, Double>): Boolean {
        var previousPrice: Double? = null

        for (price in inventoryItems.values) {
            if (previousPrice != null && price > previousPrice) {
                return false
            }
            previousPrice = price
        }

        return true
    }
    fun validatePricesSortedByDescending(arePricesDescending: Boolean) {
        val products = getProductsFromPage()
        val arePricesDescending = arePricesSortedByDescending(products)

        if (arePricesDescending) {
            println("Ceny produktů jsou řazeny sestupně.")
        } else {
            println("Ceny produktů nejsou řazeny sestupně.")
        }
    }

    fun areNamesSortedByAscending(productNames: List<String>): Boolean {
        for (i in 0 until productNames.size - 1) {
            if (productNames[i] > productNames[i + 1]) {
                return false
            }
        }
        return true
    }

    fun validateNameSortedByAscending(areNameAscending: Boolean) {
        val mainPage = MainPage()
        val products = mainPage.getProductsFromPage()
        val productNames = products.keys.toList()
        val areNamesAscending = areNamesSortedByAscending(productNames)

        if (areNamesAscending) {
            println("Názvy produktů jsou řazeny od A do Z.")
        } else {
            println("Názvy produktů nejsou řazeny od A do Z.")
        }
    }
    fun areNamesSortedByDescending(productNames: List<String>): Boolean {
        for (i in 0 until productNames.size - 1) {
            if (productNames[i] < productNames[i + 1]) {
                return false
            }
        }
        return true
    }
    fun validateNameSortedByDescending(areNamesDescending: Boolean) {
        val mainPage = MainPage()
        val products = mainPage.getProductsFromPage()
        val productNames = products.keys.toList()
        val areNamesDescending = areNamesSortedByDescending(productNames)

        if (areNamesDescending) {
            println("Názvy produktů jsou řazeny od Z do A.")
        } else {
            println("Názvy produktů nejsou řazeny od Z do A.")
        }
    }

    fun clickOnMenu() = elements().performClick(menu)

    fun clickOnLogoutButton() = elements().performClick(logout)


    fun clickOnAddToCart(def: ElementDef) = elements().performClick(def)

    fun clickOnShoppingCart(): ShoppingCartPage {
        elements().performClick(shoppingCartIcon)
        return ShoppingCartPage()
    }

}


