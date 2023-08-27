package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class CheckOutStepTwoPage:AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(cartList).isDisplayed

    private val cartList: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.className("cart_list"))

    private val totalCartSum = elements().findElementByXPath(ComponentType.LABEL, "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]").text.substring(13)

    fun getTotalCartSum():String {
        return totalCartSum
    }
}