package christmas.ui

import christmas.utils.Messages.Companion as MESSAGE
import christmas.MenuList as MENU

class OutputView {
    fun printWelcome() {
        println(MESSAGE.WELCOME)
    }
    fun printPreview(visitDate: Int) {
        println("${MESSAGE.PREVIEW_OF_DISCOUNT_FRONT}+${visitDate}+${MESSAGE.PREVIEW_OF_DISCOUNT_BACK}")
    }
    fun printMenu(orderedMenu: Map<String, Int>) {
        println(MESSAGE.ORDERED_MENU)
        for((menu, quantity) in orderedMenu) {
            println("${menu} ${quantity}+${MESSAGE.QUANTITY_UNIT}")
        }
    }
    fun printTotalBeforeDiscount(orderedMenu: Map<String, Int>): Int {
        println(MESSAGE.TOTAL_BEFORE_DISCOUNT)

        var total = 0
        for((menuName, quantity) in orderedMenu) {
            total += MENU.valueOf(menuName).calculateEachTotal(quantity)
        }

        println("${total}+${MESSAGE.CURRENCY_UNIT}")
        return total
    }
    fun printGiveawayMenu(totalBeforeDiscount: Int) {
        println(MESSAGE.GIVEAWAY_MENU)

        var giveawayMessage = MESSAGE.NOTHING_POSSIBLE
        if(totalBeforeDiscount >= 120_000)
            giveawayMessage = MESSAGE.GIVEAWAY_POSSIBLE
        println(giveawayMessage)
    }
    fun printDiscountDetails() {
        println(MESSAGE.BENEFITS_DETAILS)
        //...
    }
    fun printTotalOfDiscount() {
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
    // ...
}