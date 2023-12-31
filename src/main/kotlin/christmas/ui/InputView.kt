package christmas.ui

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Messages.Companion as MESSAGE
import christmas.MenuHeader as MENU_HEADER

class InputView {
    val output = OutputView()

    fun readVisitDate(): Int {
        println(MESSAGE.WHEN_IS_VISIT_DATE)
        val input = Console.readLine()

        isInRangeValidation(input)

        return input.toInt()
    }

    private fun isInRangeValidation(input: String?) {
        if (input == null
            || input.toIntOrNull() ?: 0 !in 1..31
        ) {
            output.printInvalidDateError()
            readVisitDate()
        }
    }

    fun readMenu(): Map<String, Int> {
        println(MESSAGE.TAKE_ORDER)
        val inputString = Console.readLine()
        isNullValidation(inputString)
        val input = inputString!!.replace(" ", "").split(",")

        val orderMap = mutableMapOf<String, Int>()
        for (order in input) {
            val (menu, quantity) = order.split("-")
            orderMap[menu] = quantity.toIntOrNull() ?: 0
        }

        isOnlyBeverageValidation(orderMap)
        isUnder20QuantityValidation(orderMap)
        isRightFormValidation(orderMap)
        isDuplicatedValidation(orderMap)

        return orderMap
    }

    private fun isNullValidation(input: String?) {
        if (input == null
            || (input.endsWith(',') && input.count { it == ',' } == 1)
            || !input.contains(',')
        ) {
            output.printInvalidOrderError()
            readMenu()
        }
    }

    private fun isUnder20QuantityValidation(orderMap: MutableMap<String, Int>) {
        var totalQuantity = 0
        for (quantity in orderMap.values) {
            totalQuantity += quantity
        }

        if (totalQuantity > 20) {
            output.printInvalidOrderError()
            readMenu()
        }
    }

    private fun isOnlyBeverageValidation(orderMap: MutableMap<String, Int>) {
        var beverageCount = 0
        for (menuName in orderMap.keys) {
            if (!isInMenuValidation(menuName))
                beverageCount = orderMap.size
            if (MENU_HEADER.isInMenuHeader(MENU_HEADER.BEVERAGE, menuName))
                beverageCount++
        }

        if (beverageCount >= orderMap.size) {
            output.printInvalidOrderError()
            readMenu()
        }
    }

    private fun isRightFormValidation(orderMap: MutableMap<String, Int>) {
        var isRightInput = true
        for (order in orderMap) {
            if (!isInMenuValidation(order.key)
                || order.value !in 1..20
            ) isRightInput = false
        }

        if (!isRightInput) {
            output.printInvalidOrderError()
            readMenu()
        }
    }

    private fun isInMenuValidation(order: String): Boolean {
        if (
            MENU_HEADER.isInMenuHeader(MENU_HEADER.APPETIZER, order)
            || MENU_HEADER.isInMenuHeader(MENU_HEADER.MAIN, order)
            || MENU_HEADER.isInMenuHeader(MENU_HEADER.DESSERT, order)
            || MENU_HEADER.isInMenuHeader(MENU_HEADER.BEVERAGE, order)
        ) return true
        return false
    }

    private fun isDuplicatedValidation(orderMap: MutableMap<String, Int>) {
        val orderMenu = orderMap.keys.toList()
        if (orderMenu.size != orderMenu.toSet().size) {
            output.printInvalidOrderError()
            readMenu()
        }
    }

}