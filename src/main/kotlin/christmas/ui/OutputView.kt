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
        for ((menuName, quantity) in orderedMenu) {
            println(menuName + " ${quantity}${MESSAGE.QUANTITY_UNIT}")
        }
    }

    fun printTotalBeforeDiscount(orderedMenu: Map<String, Int>): Int {
        println(MESSAGE.TOTAL_BEFORE_DISCOUNT)

        var total = 0
        for (order in orderedMenu) {
            total += MENU.calculateEachTotal(order)
        }

        println(decimal.format(total) + MESSAGE.CURRENCY_UNIT)
        return total
    }

    fun printGiveawayMenu(isPossibleGiveaway: Boolean) {
        println(MESSAGE.GIVEAWAY_MENU)
        var giveawayMessage = MESSAGE.NOTHING_POSSIBLE

        if (isPossibleGiveaway)
            giveawayMessage = MENU.getGiveawayMenu()

        println(giveawayMessage)
    }

    fun printBenefitsDetails() {
        println(MESSAGE.BENEFITS_DETAILS)
    }

    fun printGiveawayDetails(isPossibleGiveaway: Boolean) {
        if (isPossibleGiveaway)
            println(MENU.informGiveawayBenefit())
    }

    fun printChristmasDiscount(christmasDiscount: Int) {
        println(MESSAGE.CHRISTMAS_DISCOUNT + decimal.format(-christmasDiscount) + MESSAGE.CURRENCY_UNIT)
    }

    fun printWeekdayDiscount(totalWeekdayDiscount: Int) {
        println(MESSAGE.WEEKDAY_DISCOUNT + decimal.format(-totalWeekdayDiscount) + MESSAGE.CURRENCY_UNIT)
    }

    fun printWeekendDiscount(totalWeekendDiscount: Int) {
        println(MESSAGE.WEEKEND_DISCOUNT + decimal.format(-totalWeekendDiscount) + MESSAGE.CURRENCY_UNIT)
    }

    fun printStarredDiscount(starredDiscount: Int) {
        println(MESSAGE.STARRED_DISCOUNT + decimal.format(-starredDiscount) + MESSAGE.CURRENCY_UNIT)
    }

    fun printNoneBenefit() {
        println(MESSAGE.NOTHING_POSSIBLE)
    }

    fun printTotalBenefits(totalBenefits: Int) {
        println(MESSAGE.TOTAL_BENEFITS)
        println(decimal.format(-totalBenefits) + MESSAGE.CURRENCY_UNIT)
    }

    fun printTotalAfterDiscount(totalAfterDiscount: Int) {
        println(MESSAGE.TOTAL_AFTER_DISCOUNT)
        println(decimal.format(totalAfterDiscount) + MESSAGE.CURRENCY_UNIT)
    }

    fun printBadgeOfEvent(totalBenefits: Int) {
        val MAX_BENEFITS = 70_000
        println(MESSAGE.BADGE_OF_EVENT)
        val badge =
            when (totalBenefits) {
                in 0..4_999 -> MESSAGE.NOTHING_POSSIBLE
                in 5_000..9_999 -> MESSAGE.BADGE_OVER_5_000
                in 10_000..19_999 -> MESSAGE.BADGE_OVER_10_000
                in 20_000..MAX_BENEFITS -> MESSAGE.BADGE_OVER_20_000
                else -> MESSAGE.WRONG_DISCOUNT_SUSPECTED
            }
        println(badge)
    }

    fun printInvalidDateError() {
        println(MESSAGE.INVALID_DATE)
    }

    fun printInvalidOrderError() {
        println(MESSAGE.INVALID_ORDER)
    }

    companion object {
        val decimal = DecimalFormat("#,###")
    }
}