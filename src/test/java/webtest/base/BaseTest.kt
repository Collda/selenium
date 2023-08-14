package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep

class BaseTest : AbstractTestNew() {
    val testStep = MainPageTestStep()

    @Test
    fun exampleTest() {
        login()
        testStep.fillCart()
        logout()
    }
}