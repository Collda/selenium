package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert.fail
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info.Companion.of
import webtest.page.common.AbstractTechnicalPage

class MainPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val logo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("app_logo"))
    private val burgerMenuButton: ElementDef = ElementDef(ComponentType.HAMBURGER_MENU, "Open Menu", "react-burger-menu-btn")

    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodařilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }
    fun clickOnMenu() = elements().performClick(burgerMenuButton)


}