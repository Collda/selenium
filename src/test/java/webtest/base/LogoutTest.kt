package webtest.base

import org.testng.annotations.Test

class LogoutTest : AbstractTestNew() {

    @Test
    fun exampleTest(){
        login()
        logout()
    }
}