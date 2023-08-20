package webtest.page.app

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage
import webtest.page.menu.HamburgerMenu

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = currentUrl.equals("https://www.saucedemo.com/inventory.html")


    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val hamburgerButton: ElementDef = ElementDef(ComponentType.MAIN_MENU_BUTTON, "Hamburger Icon", "react-burger-menu-btn")
    private val shoppingCartIcon: ElementDef = ElementDef(ComponentType.LINK, "Cart Icon", By.className("shopping_cart_link"))

    private var chosenItemsSum = 0.0

    data class Items(val itemName: String, val itemPrice: Double, val itemCartLink: WebElement)

    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodažilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

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
            println("Adding selected item [${chosenItem.itemName} with the price of $${chosenItem.itemPrice}] to cart.")
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

    fun getChosenItemSum(): Double{
        return chosenItemsSum
    }

    private fun clickOnCart(): CartPage {
        elements().performClick(shoppingCartIcon)
        return CartPage()
    }

}