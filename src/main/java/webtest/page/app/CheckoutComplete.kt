package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import webtest.page.menu.HamburgerMenu

class CheckoutComplete : AbstractTechnicalPage()  {
    override fun isOpen(): Boolean = currentUrl.equals("https://www.saucedemo.com/checkout-complete.html") && elements().isDisplayed(checkoutLogo)

    private val checkoutLogo: ElementDef = ElementDef(ComponentType.IMAGE,"Green Checkmark", By.className("pony_express"))
    private val hamburgerButton: ElementDef = ElementDef(ComponentType.MAIN_MENU_BUTTON, "Hamburger Icon", "react-burger-menu-btn")

    fun openHamburgerMenu() : HamburgerMenu {
        elements().performClick(hamburgerButton)
        return HamburgerMenu()
    }
}