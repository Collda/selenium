package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
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

    private val sortProductsAlphabeticallyAZ: ElementDef =
        ElementDef(ComponentType.ANY, "Sort Products Aplphabetically A to Z", By.xpath("//option[@value = 'az']"))
    private val sortProductsAlphabeticallyZA: ElementDef =
        ElementDef(ComponentType.ANY, "Sort Products Aplphabetically Z to A", By.xpath("//option[@value = 'za']"))
    private val sortProductsByPriceDesc: ElementDef =
        ElementDef(ComponentType.ANY, "Sort Products by Price Desc", By.xpath("//option[@value = 'hilo']"))
    private val sortProductsByPriceAsc: ElementDef =
        ElementDef(ComponentType.ANY, "Sort Products by Price Asc", By.xpath("//option[@value = 'lohi']"))

    val inventoryItemFrame: ElementDef = ElementDef(ComponentType.FRAME, "", By.className("inventory_item"))
    val inventoryItemName: ElementDef = ElementDef(ComponentType.LABEL, "", By.className("inventory_item_label"))
    val inventoryItemPrice: ElementDef = ElementDef(ComponentType.LABEL, "", By.className("inventory_item_price"))

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

    fun clickOnSortProductsByPriceAsc() {
        clickOnAddToCart(sortProductsByPriceAsc)
    }

    fun clickOnSortProductsByPriceDesc() {
        clickOnAddToCart(sortProductsByPriceDesc)
    }

    fun clickOnSortProductsAlphabeticallyAZ() {
        clickOnAddToCart(sortProductsAlphabeticallyAZ)
    }

    fun clickOnSortProductsAlphabeticallyZA() {
        clickOnAddToCart(sortProductsAlphabeticallyZA)
    }


    fun getItemsSorted(
        itemFrames: List<WebElement>,
        itemNameClassName: String,
        itemPriceClassName: String
    ): List<Pair<String, Double>> {
        val cartItems = mutableListOf<Pair<String, Double>>()

        for (itemFrame in itemFrames) {
            val name = itemFrame.findElement(By.className(itemNameClassName)).text
            val priceText = itemFrame.findElement(By.className(itemPriceClassName)).text
            val price = priceText.removePrefix("$").toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                cartItems.add(Pair(name, price))
            }
        }

        cartItems.sortBy { it.second }

        return cartItems
    }

    fun comparisonProductsByPriceAsc() {
        val mainPage = MainPage()
        val itemFrames = elements().findElements(mainPage.inventoryItemFrame) // Retrieve item frames
        val sortedItemsList = mainPage.getItemsSorted(itemFrames, "inventory_item_label", "inventory_item_price")

        mainPage.clickOnSortProductsByPriceAsc()

        val webStoreSortedItemsList =
            mainPage.getItemsSorted(itemFrames, "inventory_item_label", "inventory_item_price")

        if (sortedItemsList == webStoreSortedItemsList) {
            println("Ascend sorting on the web store is working correctly.")
        } else {
            println("Ascend sorting on the web store is not working correctly.")
        }
    }
    fun getItemsSortedDescending(
        itemFrames: List<WebElement>,
        itemNameClassName: String,
        itemPriceClassName: String
    ): List<Pair<String, Double>> {
        val sortedItems = getItemsSorted(itemFrames, itemNameClassName, itemPriceClassName)
        return sortedItems.sortedByDescending { it.second }
    }
    fun comparisonProductsByPriceDesc() {
        val mainPage = MainPage()
        val itemFrames = elements().findElements(mainPage.inventoryItemFrame) // Retrieve item frames
        val sortedItemsList = mainPage.getItemsSortedDescending(itemFrames, "inventory_item_label", "inventory_item_price")

        mainPage.clickOnSortProductsByPriceDesc()

        val webStoreSortedItemsList =
            mainPage.getItemsSortedDescending(itemFrames, "inventory_item_label", "inventory_item_price")

        if (sortedItemsList == webStoreSortedItemsList) {
            println("Descend sorting on the web store is working correctly.")
        } else {
            println("Descend sorting on the web store is not working correctly.")
        }
    }
    fun getItemsSortedAlphabeticallyAZ(
        itemFrames: List<WebElement>,
        itemNameClassName: String,
        itemPriceClassName: String
    ): List<Pair<String, Double>> {
        val sortedItems = getItemsSorted(itemFrames, itemNameClassName, itemPriceClassName)
        return sortedItems.sortedBy { it.first }
    }
    fun comparisonProductsAlphabeticallyAZ() {
        val mainPage = MainPage()
        val itemFrames = elements().findElements(mainPage.inventoryItemFrame) // Retrieve item frames
        val sortedItemsList = mainPage.getItemsSortedAlphabeticallyAZ(itemFrames, "inventory_item_label", "inventory_item_price")

        mainPage.clickOnSortProductsAlphabeticallyAZ()

        val webStoreSortedItemsList =
            mainPage.getItemsSortedAlphabeticallyAZ(itemFrames, "inventory_item_label", "inventory_item_price")

        if (sortedItemsList == webStoreSortedItemsList) {
            println("Alphabetically A to Z sorting on the web store is working correctly.")
        } else {
            println("Alphabetically A to Z sorting on the web store is not working correctly.")
        }
    }

    fun getItemsSortedAlphabeticallyZA(
        itemFrames: List<WebElement>,
        itemNameClassName: String,
        itemPriceClassName: String
    ): List<Pair<String, Double>> {
        val sortedItems = getItemsSorted(itemFrames, itemNameClassName, itemPriceClassName)
        return sortedItems.sortedByDescending { it.first }
    }
    fun comparisonProductsAlphabeticallyZA() {
        val mainPage = MainPage()
        val itemFrames = elements().findElements(mainPage.inventoryItemFrame) // Retrieve item frames
        val sortedItemsList = mainPage.getItemsSortedAlphabeticallyZA(itemFrames, "inventory_item_label", "inventory_item_price")

        mainPage.clickOnSortProductsAlphabeticallyZA()

        val webStoreSortedItemsList =
            mainPage.getItemsSortedAlphabeticallyZA(itemFrames, "inventory_item_label", "inventory_item_price")

        if (sortedItemsList == webStoreSortedItemsList) {
            println("Alphabetically Z to A sorting on the web store is working correctly.")
        } else {
            println("Alphabetically Z to A sorting on the web store is not working correctly.")
        }
    }
}