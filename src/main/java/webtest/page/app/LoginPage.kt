package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class LoginPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean =
        elements().findElement(loginLogo).isDisplayed

    private val loginLogo: ElementDef =
        ElementDef(ComponentType.PAGE_LOGO, "Swag Labs", By.className("login_logo"))

    private val userNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Username", "user-name")
    private val passwordInput: ElementDef = ElementDef(ComponentType.INPUT, "Password", "password")

    private val loginButton: ElementDef = ElementDef(ComponentType.BUTTON, "Login", "login-button")

    fun clickOnLoginButton(): MainPage {
        elements().performClick(loginButton)
        return MainPage()
    }
    fun fillLogin(userName: String, password: String){
        elements().setValue(userNameInput, userName)
        elements().setValue(passwordInput, password)
    }
}