package christmas.ui

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Messages.Companion as MESSAGE

class InputView {
    fun readVisitDate(): Int {
        println(MESSAGE.WHEN_IS_VISIT_DATE)
        val input = Console.readLine()
        // ...
    }
    fun readMenu(): Map<String, Int> {
        println(MESSAGE.TAKE_ORDER)
        val input = Console.readLine()
        // ...
    }
}