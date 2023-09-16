package webtest.base

import org.testng.annotations.Test
import webtest.base.step.MainPageTestStep

class FilterTest : AbstractTestNew() {
    private val mpts = MainPageTestStep()

    @Test
    fun filterTest() {
        login()
        mpts.testFilter("hilo")
        mpts.testFilter("lohi")
        mpts.testFilter("za")
        mpts.testFilter("az")
    }
}