package christmas.domain

import christmas.ui.OutputView
import christmas.MenuHeader as MENU_HEADER

enum class Day {
    WEEKDAY,
    WEEKEND,
    STARRED
}

class Benefits {
    val output = OutputView()

    fun giveawayMenu(totalBeforeDiscount: Int) {
        val lowerLimitOfgiveaway = 120_000

        if(totalBeforeDiscount >= lowerLimitOfgiveaway)
            isPossibleGiveaway = true

        output.printGiveawayMenu(isPossibleGiveaway)
    }

    fun benefitsDetails(visitDate: Int, orderedMenu: Map<String, Int>) {
        output.printBenefitsDetails()

        output.printGiveawayDetails(isPossibleGiveaway)
        christmasDiscount(visitDate)

        when(whichDayIsIt(visitDate)) {
            Day.WEEKDAY -> weekdayDiscount(orderedMenu)
            Day.WEEKEND -> weekendDiscount(orderedMenu)
            Day.STARRED -> starredDiscount()
        }

        if(totalBenefits == 0)
            output.printNoneBenefit()
    }

    private fun christmasDiscount(visitDate: Int) {
        if(visitDate <= 25) {
            val christmasDiscount = 1_000 + 100 * (visitDate - 1)
            output.printChristmasDiscount(christmasDiscount)

            totalBenefits += christmasDiscount
        }
    }
    private fun whichDayIsIt(visitDate: Int): Day {
        return when(visitDate) {
            1, 2, 8, 9, 15, 16, 22, 23, 29, 30 -> Day.WEEKEND
            3, 10, 17, 24, 25, 31 -> Day.STARRED
            else -> Day.WEEKDAY
        }
    }
    private fun weekdayDiscount(orderedMenu: Map<String, Int>) {
        var countOfPossibleDiscount = 0
        for(order in orderedMenu.keys) {
            if(MENU_HEADER.isInMenuHeader(MENU_HEADER.DESSERT, order))
                countOfPossibleDiscount++
        }

        val totalWeekdayDiscount = countOfPossibleDiscount * 2_023

        output.printWeekdayDiscount(totalWeekdayDiscount)
        totalBenefits += totalWeekdayDiscount
    }
    private fun weekendDiscount(orderedMenu: Map<String, Int>) {
        var countOfPossibleDiscount = 0
        for(order in orderedMenu.keys) {
            if(MENU_HEADER.isInMenuHeader(MENU_HEADER.MAIN, order))
                countOfPossibleDiscount++
        }

        val totalWeekendDiscount = countOfPossibleDiscount * 2_023

        output.printWeekendDiscount(totalWeekendDiscount)
        totalBenefits += totalWeekendDiscount
    }
    private fun starredDiscount() {
        val starredDiscount = 1_000
        output.printStarredDiscount(starredDiscount)
        totalBenefits += starredDiscount
    }

    companion object {
        var isPossibleGiveaway = false
        var totalBenefits = 0
    }
}