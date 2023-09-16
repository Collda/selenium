package webtest.base.step

import webtest.page.app.CheckOutPage
import webtest.page.app.FinishPage

class CheckOutPageTestStep : AbstractTestStep() {

    fun VerifyPrices(){
        CheckOutPage().run{
            verifyTotalPriceEqualToTotalTitemPrice()
        }
    }

    fun FinishAndVerify(): FinishPage{
        CheckOutPage().clickOnFinishButton()
        return FinishPage()
    }
}