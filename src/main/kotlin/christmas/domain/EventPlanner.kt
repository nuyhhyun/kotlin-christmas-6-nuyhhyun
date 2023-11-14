package christmas.domain

import christmas.ui.OutputView
import christmas.ui.InputView

class EventPlanner {
    private val output = OutputView()
    private val input = InputView()

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
        output.printTotalBeforeDiscount(orderedMenu)
    }
    private fun informBenefits(visitDate: Int, orderedMenu: Map<String, Int>) {

    }
}