package webtest.base

import org.testng.annotations.Test

class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        //login().validateLoggedIn()
        login().isOpen()
        logout().isOpen()
    }
}