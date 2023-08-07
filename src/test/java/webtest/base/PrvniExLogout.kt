package webtest.base

import org.testng.annotations.Test

class PrvniExLogout : AbstractTestNew() {
    @Test
    fun LogoutEx(){
        login().validateLoggedIn()
        logOut()
    }

}