package webtest.page.app

import org.openqa.selenium.By
import org.testng.Assert
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info
import webtest.page.common.AbstractTechnicalPage

class BurgerPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val loginlogo: ElementDef = ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("login_logo"))
    private val logoutButton: ElementDef = ElementDef(ComponentType.BUTTON, "Logout", "logout_sidebar_link")
    fun validateLogout() {
        if (!elements().isDisplayed(loginlogo)) {
            Assert.fail(
                Info.of(this).message("Není rozbaleno Hamburger menu!")
                    .element(loginlogo)
                    .build()
            )
        }
    }
    fun clickOnLogout() = elements().performClick(logoutButton)


}
