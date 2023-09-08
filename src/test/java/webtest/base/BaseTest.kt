package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep
import webtest.base.step.ShoppingCartCheckStep
import kotlin.concurrent.thread


class BaseTest : AbstractTestNew() {

    @Test
    fun exampleTest() {
        val testStep = MainPageTestStep()
        val testovaciStep = ShoppingCartCheckStep()
        login()
        testStep.fillCart()
        testovaciStep.testovaciStep()
        logout()
    }

    @Test
    fun filtrTestPricesHL(){
        val testStepFiltrPricesHL = MainPageTestStep()
        login()
        testStepFiltrPricesHL.validateFiltrPricesHL()
        logout()
    }

    @Test
    fun filtrTestPricesLH(){
        val testStepFiltrPricesLH = MainPageTestStep()
        login()
        testStepFiltrPricesLH.validateFiltrPricesLH()
        logout()
    }
    @Test
    fun filtrTestNamesAZ(){
        val testStepFiltrAZ = MainPageTestStep()
        login()
        testStepFiltrAZ.validateFiltrAZ()
        logout()
    }
    @Test
    fun filtrTestnamesZA(){
        val testStepFiltrZA = MainPageTestStep()
        login()
        testStepFiltrZA.validateFiltrZA()
        logout()
    }
}