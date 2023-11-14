package christmas.ui

import christmas.utils.Messages.Companion as MESSAGE

class OutputView {
    fun printWelcome() {
        println(MESSAGE.WELCOME)
    }
    fun printPreview(visitDate: Int) {
        println("${MESSAGE.PREVIEW_OF_DISCOUNT_FRONT}+${visitDate}+${MESSAGE.PREVIEW_OF_DISCOUNT_BACK}")
    }
    fun printMenu() {
        println(MESSAGE.ORDERED_MENU)
        // ...
    }
    fun printTotalBeforeDiscount() {
        println(MESSAGE.TOTAL_BEFORE_DISCOUNT)
        //...
    }
    fun printGiveawayMenu() {
        println(MESSAGE.GIVEAWAY_MENU)
        //...
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