package webtest.base.step

import webtest.page.app.CheckOutPage

class CheckOutPageTestStep : AbstractTestStep() {

    fun VerifyPrices(){
        CheckOutPage().run{
            verifyTotalPriceEqualToTotalTitemPrice()
        }
    }
}