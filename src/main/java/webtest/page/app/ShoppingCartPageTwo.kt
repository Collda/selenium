package webtest.page.app

import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class ShoppingCartPageTwo : AbstractTechnicalPage() {
    override fun isOpen(): Boolean = elements().findElement(summaryContainer).isDisplayed

    private val summaryContainer: ElementDef = ElementDef(ComponentType.ANY, "", "checkout_summary_container")
}