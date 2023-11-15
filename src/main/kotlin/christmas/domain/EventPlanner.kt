package christmas.domain

import christmas.ui.OutputView
import christmas.ui.InputView

class EventPlanner {
    private val output = OutputView()
    private val input = InputView()
    private val benefits = Benefits()

    fun startEventPlanner() {
        output.printWelcome()
        val visitDate = input.readVisitDate()
        val orderedMenu = input.readMenu()
        output.printPreview(visitDate)

        informOrder(orderedMenu)
        informBenefits(visitDate, orderedMenu)
    }
    private fun informOrder(orderedMenu: Map<String, Int>) {
        output.printMenu(orderedMenu)
        totalBeforeDiscount = output.printTotalBeforeDiscount(orderedMenu)
    }
    private fun informBenefits(visitDate: Int, orderedMenu: Map<String, Int>) {
        benefits.giveawayMenu(totalBeforeDiscount)
        benefits.benefitsDetails(visitDate, orderedMenu)
    }

    companion object {
        var totalBeforeDiscount: Int = 0
    }
}