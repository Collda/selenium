package webtest.page.menu

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.app.LoginPage
import webtest.page.app.MainPage

class HamburgerMenu : AbstractMenu() {
    override fun isOpen(): Boolean {
        return elements().isDisplayed(hamburgerMenu)
    }

    private val hamburgerMenu: ElementDef = ElementDef(ComponentType.HAMBURGER_MENU, "Hamburger menu", By.className("bm-menu-wrap"))
    private val logout: ElementDef = ElementDef(ComponentType.MAIN_MENU_ITEM,"Logout","logout_sidebar_link")

    fun logout() : LoginPage {
        val mainPage = MainPage()
        mainPage.openHamburgerMenu()
        elements().performClick(logout)
        return LoginPage()
    }

}