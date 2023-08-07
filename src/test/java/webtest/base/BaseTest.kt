package webtest.base

import org.testng.annotations.Test

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        login()
        logout()
    }
}