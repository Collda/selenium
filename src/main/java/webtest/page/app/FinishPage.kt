package webtest.page.app

import org.openqa.selenium.By
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage

class FinishPage: AbstractTechnicalPage() {

    override fun isOpen(): Boolean = elements().findElement(logoPonyExpress).isDisplayed

    private val logoPonyExpress: ElementDef = ElementDef(ComponentType.PAGE_LOGO,"Pony Express", By.className("pony_express"))
}