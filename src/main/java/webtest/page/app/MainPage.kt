package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(logo).isDisplayed

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val burgerMenuIcon: ElementDef =
        ElementDef(ComponentType.BUTTON, "Hamburger menu", By.className("bm-burger-button"))

    fun clickOnHamburgerMenu(): HamBurgerMenu {
        elements().performClick(burgerMenuIcon)
        return HamBurgerMenu()
    }

}