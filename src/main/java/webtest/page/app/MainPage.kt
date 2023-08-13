package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        //TODO("Not yet implemented")
        var isPageOpen = false
        isPageOpen=(currentUrl.equals("https://www.saucedemo.com/inventory.html"))
        return isPageOpen
    }

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val hamburgerButton: ElementDef = ElementDef(ComponentType.MAIN_MENU_BUTTON, "Hamburger button", By.id("react-burger-menu-btn"))
    private val hamburgerMenu: ElementDef= ElementDef(ComponentType.HAMBURGER_MENU, "Hamburger menu", By.className("bm-menu-wrap"))
    private val logout: ElementDef = ElementDef(ComponentType.MAIN_MENU_ITEM,"Logout button","logout_sidebar_link")


    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodažilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

    private fun openHamburgerMenu() : Boolean{
        elements().performClick(hamburgerButton)
        return elements().isDisplayed(hamburgerMenu)
    }

    fun logout(){
        if (openHamburgerMenu()) {
          elements().performClick(logout)
        }
    }

}