package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class LoginPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(loginButton).isDisplayed

    private val userNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Username", "user-name")
    private val passwordInput: ElementDef = ElementDef(ComponentType.INPUT, "Password", "password")

    private val loginButton: ElementDef = ElementDef(ComponentType.BUTTON, "Login", "login-button")




    fun clickOnLoginButton() = elements().performClick(loginButton)

    fun fillLogin(userName: String, password: String){
        elements().setValue(userNameInput,userName)
        elements().setValue(passwordInput, password)
    }
}