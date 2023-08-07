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

    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodažilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

    private val menu: ElementDef = ElementDef(ComponentType.BUTTON, "Hamburger Menu", By.id("react-burger-menu-btn"))
    private val logout: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", By.id("logout_sidebar_link"))

    fun clickOnMenu() = elements().performClick(menu)
    fun clickOnLogutButton() = elements().performClick(logout)

}