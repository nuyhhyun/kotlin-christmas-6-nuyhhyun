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
    }
}