package christmas.domain

import christmas.ui.OutputView
import christmas.ui.InputView

class EventPlanner {
    private val output = OutputView()
    private val input = InputView()
    private val benefits = Benefits()

    fun startEventPlanner() {
        val visitDate = input.readVisitDate()
        val orderedMenu = input.readMenu()

        output.printWelcome()
        output.printPreview(visitDate)

        informOrder(orderedMenu)
        informBenefits(visitDate, orderedMenu)
        informTotal()
    }

    private fun informOrder(orderedMenu: Map<String, Int>) {
        output.printMenu(orderedMenu)
        totalBeforeDiscount = output.printTotalBeforeDiscount(orderedMenu)
    }

    private fun informBenefits(visitDate: Int, orderedMenu: Map<String, Int>) {
        benefits.giveawayMenu(totalBeforeDiscount)
        benefits.benefitsDetails(visitDate, orderedMenu)
    }

    private fun informTotal() {
        output.printTotalBenefits(totalBenefits)
        output.printTotalAfterDiscount(totalBeforeDiscount - totalBenefits)
        output.printBadgeOfEvent(totalBenefits)
    }

    companion object {
        var totalBeforeDiscount: Int = 0
        var totalBenefits = 0
    }
}