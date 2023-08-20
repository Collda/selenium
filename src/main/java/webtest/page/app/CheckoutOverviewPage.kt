package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage




class CheckoutOverviewPage: AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkoutSummary).isDisplayed

    private val checkoutSummary: ElementDef = ElementDef(ComponentType.FRAME, "", By.ByClassName("checkout_summary_container"))
    private val totalPrice: ElementDef = ElementDef(ComponentType.LABEL, "Total Price", By.ByClassName("summary_subtotal_label"))

    fun getTotalCheckoutPrice() : Double {
        return elements().findElement(totalPrice).text.removePrefix("Item total: $").toDouble()
    }
}
