package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.base.Info
import webtest.page.common.AbstractTechnicalPage


class CheckoutOverviewPage : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(checkoutSummaryContainer).isDisplayed

    private val checkoutSummaryContainer: ElementDef =
        ElementDef(ComponentType.FRAME, "", By.ByClassName("checkout_summary_container"))

    private val totalPrice: ElementDef =
        ElementDef(ComponentType.LABEL, "Total Price", By.ByClassName("summary_subtotal_label"))

    private val finishButton: ElementDef = ElementDef(ComponentType.BUTTON, "Finish", "finish")

    fun getTotalPrice(): Double = elements().findElement(totalPrice).text.substringAfter("$").toDouble()
    fun validateTotalPrice(expectedPrice: Double, actualPrice: Double) {
        if (!expectedPrice.equals(actualPrice)) {
            Info.of(this)
                .message("Ocekavana hodnota $expectedPrice se neshoduje se skutecnou hodnotou - $actualPrice")
                .build()
        }

    }
    fun clickOnFinishButton() = elements().performClick(finishButton)
}
