package webtest.page.app

import org.openqa.selenium.WebElement
import webtest.base.ComponentType
import webtest.base.ElementDef
import webtest.page.common.AbstractTechnicalPage
import webtest.page.menu.HamburgerMenu

class CheckoutSecondPage : AbstractTechnicalPage()  {
    override fun isOpen(): Boolean = currentUrl.equals("https://www.saucedemo.com/checkout-step-two.html")

    private val itemTotal: WebElement = elements().findElementByClassName(ComponentType.LABEL,"summary_subtotal_label")
    private val hamburgerButton: ElementDef = ElementDef(ComponentType.MAIN_MENU_BUTTON, "Hamburger Icon", "react-burger-menu-btn")
    private val finishButton: ElementDef = ElementDef(ComponentType.BUTTON, "Finish", "finish")

    private var total: Double = 0.0

    fun checkTotalPrice(selectedTotal: Double, cartTotal: Double) : CheckoutComplete{
        total = itemTotal.text.substringAfter("$").toDouble()
        println("Total price on checkout is $$total without tax")
        //println("Comparing all redorded totals...")
        println(compareAllTotals(selectedTotal, cartTotal, total))
        checkout()
        return CheckoutComplete()
    }

    private fun checkout(){
        elements().performClick(finishButton)
    }

    private fun compareAllTotals (selectedTotal: Double, cartTotal: Double, checkoutTotal: Double): String{
//        println("Totals to compare: ")
//        println("       Selected item total: $selectedTotal")
//        println("       Cart total:          $cartTotal")
//        println("       Checkout total:      $checkoutTotal")

        return when {
            checkoutTotal == selectedTotal && checkoutTotal == cartTotal -> "All three totals match ($$checkoutTotal)."
            checkoutTotal == selectedTotal -> "Cart total ($$cartTotal) does not match selected items and checkout totals ($$checkoutTotal)."
            checkoutTotal == cartTotal -> "Selected items ($$selectedTotal) does not match cart and checkout totals ($$checkoutTotal)."
            else -> "Neither selected item total nor cart total matches the checkout total ($$checkoutTotal)."
        }
    }

    fun openHamburgerMenu() : HamburgerMenu {
        elements().performClick(hamburgerButton)
        return HamburgerMenu()
    }

}