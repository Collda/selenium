package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class HamBurgerMenu : AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(hamBurgerMenu).isDisplayed

    private val hamBurgerMenu: ElementDef =
        ElementDef(ComponentType.HAMBURGER_MENU, "Hamburger menu", By.className("bm-menu"))

    private val logoutLink: ElementDef = ElementDef(ComponentType.LINK, "Logout", "logout_sidebar_link")

    fun clickOnLogout(): LoginPage {
        elements().performClick(logoutLink)
        return LoginPage()
    }
}