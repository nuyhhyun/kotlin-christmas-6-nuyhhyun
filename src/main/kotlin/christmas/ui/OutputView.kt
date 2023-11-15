package christmas.ui

import christmas.utils.Messages.Companion as MESSAGE
import christmas.Menu as MENU
import java.text.DecimalFormat

class OutputView {
    fun printWelcome() {
        println(MESSAGE.WELCOME)
    }
    fun printPreview(visitDate: Int) {
        println(MESSAGE.PREVIEW_OF_DISCOUNT_FRONT + visitDate + MESSAGE.PREVIEW_OF_DISCOUNT_BACK)
    }

    fun printMenu(orderedMenu: Map<String, Int>) {
        println(MESSAGE.ORDERED_MENU)
        for((menuName, quantity) in orderedMenu) {
            println(menuName +" ${quantity}${MESSAGE.QUANTITY_UNIT}")
        }
    }
    fun printTotalBeforeDiscount(orderedMenu: Map<String, Int>): Int {
        println(MESSAGE.TOTAL_BEFORE_DISCOUNT)

        var total = 0
        for((menuName, quantity) in orderedMenu) {
            total += MENU.valueOf(menuName).calculateEachTotal(quantity)
        }

        println("${total}" + MESSAGE.CURRENCY_UNIT)
        return total
    }

    fun printGiveawayMenu(isPossibleGiveaway: Boolean) {
        println(MESSAGE.GIVEAWAY_MENU)
        var giveawayMessage = MESSAGE.NOTHING_POSSIBLE

        if(isPossibleGiveaway)
            giveawayMessage = MENU.getGiveawayMenu()

        println(giveawayMessage)
    }
    fun printBenefitsDetails() {
        println(MESSAGE.BENEFITS_DETAILS)
    }
    fun printGiveawayDetails(isPossibleGiveaway: Boolean) {
        if(isPossibleGiveaway)
            println(MENU.informGiveawayBenefit())
    }
    fun printChristmasDiscount(christmasDiscount: Int) {
        println(MESSAGE.CHRISTMAS_DISCOUNT + decimal.format(christmasDiscount) + MESSAGE.CURRENCY_UNIT)
    }
    fun printWeekdayDiscount(totalWeekdayDiscount: Int) {
        println(MESSAGE.WEEKDAY_DISCOUNT + totalWeekdayDiscount + MESSAGE.CURRENCY_UNIT)
    }
    fun printWeekendDiscount(totalWeekendDiscount: Int) {
        println(MESSAGE.WEEKEND_DISCOUNT + totalWeekendDiscount + MESSAGE.CURRENCY_UNIT)
    }
    fun printStarredDiscount(starredDiscount: Int) {
        println(MESSAGE.STARRED_DISCOUNT + starredDiscount + MESSAGE.CURRENCY_UNIT)
    }
    fun printNoneBenefit() {
        println(MESSAGE.NOTHING_POSSIBLE)
    }

    fun printTotalBenefits() {
        println(MESSAGE.TOTAL_BENEFITS)
        //...
    }
    fun printTotalAfterDiscount() {
        println(MESSAGE.TOTAL_AFTER_DISCOUNT)
        //...
    }
    fun printBadgeOfEvent() {
        println(MESSAGE.BADGE_OF_EVENT)
        //...
    }


    companion object {
        val decimal = DecimalFormat("#,###")
    }
}