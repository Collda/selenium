package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun logoutAfterLoginTest() {
        val testStep = MainPageTestStep()
        //login()
        testStep.fillCart()
        logout()
    }
}