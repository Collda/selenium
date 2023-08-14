package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        val testStep = MainPageTestStep()
        //login().validateLoggedIn()
        login().isOpen()
        testStep.fillCart()
        logout().isOpen()
    }
}