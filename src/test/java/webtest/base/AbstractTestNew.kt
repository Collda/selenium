package webtest.base

import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestResult
import org.testng.annotations.*
import webtest.page.app.CheckoutSecondPage
import webtest.page.app.LoginPage
import webtest.page.app.MainPage
import webtest.page.menu.HamburgerMenu
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

abstract class AbstractTestNew {

    @BeforeMethod
    fun initializeDriver() = DriverSettings.initializeDriver()


    @AfterMethod
    fun closeDriver(result: ITestResult) {
        if (result.status == ITestResult.FAILURE) {
            val scrFile = (DriverSettings.getDriver() as TakesScreenshot).getScreenshotAs(OutputType.FILE)
            try {
                FileUtils.copyFile(
                    scrFile, File(
                        "..\\ScreenShots\\" + result.name + "-"
                                + SimpleDateFormat("ddMMHHmm").format(Date()) + ".jpg"
                    )
                )
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        //DriverSettings.getDriver().close()
        DriverSettings.getDriver().quit()
    }


    /**
     * Zmínit se jak to lze napsat jinak za pouziti core selenia Webdriver, rozdil mezi fce run/let/also ...
     */
    fun login(): MainPage {
        //TODO: rewrite loginpage without .run
        /* LoginPage().run {
            fillLogin(PropertiesData.getUsername(), PropertiesData.getPassword())
            clickOnLoginButton()
        }*/

        val loginPage = LoginPage()
        loginPage.fillLogin(PropertiesData.getUsername(), PropertiesData.getPassword())
        loginPage.clickOnLoginButton()

        return MainPage()
    }

    fun logout(): LoginPage {
        val checkoutPage = CheckoutSecondPage()
        checkoutPage.run { openHamburgerMenu().logout() }
        return LoginPage()
    }
}