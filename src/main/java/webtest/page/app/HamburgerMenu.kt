package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class HamburgerMenu: AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(bmMenuWrap).isDisplayed

    private val bmMenuWrap: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.className("bm-menu"))

    private val menuButton: ElementDef =
        ElementDef(ComponentType.BUTTON, "Open Menu", By.id("react-burger-menu-btn"))
    private val logoutButton: ElementDef =
        ElementDef(ComponentType.MAIN_MENU_ITEM, "Logout", By.id("logout_sidebar_link"))

    fun clickOnMenuButton() = elements().performClick(menuButton)
    fun clickOnLogoutButton() = elements().performClick(logoutButton)
}