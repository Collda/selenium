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

    private val hambugerMenu: ElementDef = ElementDef(ComponentType.BUTTON, "BurgerMenu", "react-burger-menu-btn")
    private val logOutButton: ElementDef = ElementDef(ComponentType.BUTTON, "LogOut", "logout_sidebar_link")

    fun clickOnHamburgerMenuButton() = elements().performClick(hambugerMenu)

    fun clickOnLogOutButton() = elements().performClick(logOutButton)

    fun validateLoggedIn() {
        if (!elements().isDisplayed(logo)) {
            fail(
                of(this).message("Uživateli se nepodažilo přihlásit nebo se nezobrazilo logo na stránce").element(logo)
                    .build()
            )
        }
    }

}