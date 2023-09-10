package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import webtest.page.menu.HamburgerMenu

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = currentUrl.equals("https://www.saucedemo.com/inventory.html")


    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val hamburgerButton: ElementDef = ElementDef(ComponentType.MAIN_MENU_BUTTON, "Hamburger Icon", "react-burger-menu-btn")
    private val shoppingCartIcon: ElementDef = ElementDef(ComponentType.LINK, "Cart Icon", By.className("shopping_cart_link"))
    private val sortDropdown: ElementDef = ElementDef(ComponentType.COMBO_BOX, "Sort Options", By.className("product_sort_container"))

    private var chosenItemsSum = 0.0

    data class Items(val itemName: String, val itemPrice: Double, val itemCartLink: WebElement)

    fun openHamburgerMenu() : HamburgerMenu{
        elements().performClick(hamburgerButton)
        return HamburgerMenu()
    }

    fun addRandomItemsToCart(itemCount: Int){
        val allItems = extractItemList()
        val chosenItems = allItems.indices.shuffled().take(itemCount)
        for (chosenIndex in chosenItems){
            val chosenItem = allItems[chosenIndex]
            val addToCartButton = chosenItem.itemCartLink
            //println("Adding selected item [${chosenItem.itemName} with the price of $${chosenItem.itemPrice}] to cart.")
            chosenItemsSum += chosenItem.itemPrice
            elements().performClick(addToCartButton)
        }
        println("Total price of selected items is: $$chosenItemsSum")
        clickOnCart()
    }

    private fun extractItemList(): List<Items>{
        val items = mutableListOf<Items>()
        val itemDescriptions: List<WebElement> = elements().findElementsByClassName(ComponentType.FRAME,"inventory_item_description")
        for (itemDescription in itemDescriptions) {
            val itemName = itemDescription.findElement(By.className("inventory_item_name")).text
            val itemPrice = itemDescription.findElement(By.className("inventory_item_price")).text.removePrefix("$").toDoubleOrNull()
            val itemCartLink = itemDescription.findElement(By.ByClassName("btn_inventory"))

            if (itemName.isNotEmpty() && itemPrice != null){
                items.add(Items(itemName,itemPrice,itemCartLink))
            }
        }
        return items
    }

    private fun extractItemsList(): MutableMap<String,Double>{
        val items = mutableMapOf<String,Double>()
        val itemDescriptions: List<WebElement> = elements().findElementsByClassName(ComponentType.FRAME,"inventory_item_description")
        for (itemDescription in itemDescriptions) {
            val itemName = itemDescription.findElement(By.className("inventory_item_name")).text
            val itemPrice = itemDescription.findElement(By.className("inventory_item_price")).text.removePrefix("$")
                .toDoubleOrNull()

            if (itemName.isNotEmpty() && itemPrice != null) {
                items[itemName] = itemPrice
            }
        }
        return items
    }

    fun getChosenItemSum(): Double{
        return chosenItemsSum
    }

    private fun clickOnCart(): CartPage {
        elements().performClick(shoppingCartIcon)
        return CartPage()
    }

    fun checkSorting(sortType: String = ""): Boolean{
        val unsortedItemList = extractItemsList()
        val select = Select(elements().findElement(sortDropdown))
        select.selectByValue(sortType)
        val pageSortedItemList = extractItemsList()
        var mapsEqual = false
        when (sortType) {
            "az" ->
                mapsEqual = pageSortedItemList == unsortedItemList.entries.sortedBy { it.key }.associateBy({it.key},{it.value})
            "za" ->
                mapsEqual = pageSortedItemList == unsortedItemList.entries.sortedByDescending { it.key }.associateBy({it.key},{it.value})
            "lohi" ->
                mapsEqual = pageSortedItemList == unsortedItemList.entries.sortedBy { it.value }.associateBy({it.key},{it.value})
            "hilo" ->
                mapsEqual = pageSortedItemList == unsortedItemList.entries.sortedByDescending { it.value }.associateBy({it.key},{it.value})
            else -> println("No sort method provided.")
        }

        return mapsEqual
    }

}