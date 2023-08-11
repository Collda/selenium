package webtest.page.app

import org.testng.Assert
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info
import webtest.page.common.AbstractTechnicalPage

class LoginPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean {
        TODO("Not yet implemented")
    }

    private val userNameInput: ElementDef = ElementDef(ComponentType.INPUT, "Username", "user-name")
    private val passwordInput: ElementDef = ElementDef(ComponentType.INPUT, "Password", "password")

    private val loginButton: ElementDef = ElementDef(ComponentType.BUTTON, "Login", "login-button")



    fun clickOnLoginButton() = elements().performClick(loginButton)

    fun fillLogin(userName: String, password: String){
        elements().setValue(userNameInput,userName)
        elements().setValue(passwordInput, password)
    }

    fun validateLogout(){
        if(!elements().isDisplayed(loginButton)){
            Assert.fail(
                Info.of(this).message("Nepodažilo se odhlásit")
                    .element(loginButton)
                    .build()
            )
        }
    }

}