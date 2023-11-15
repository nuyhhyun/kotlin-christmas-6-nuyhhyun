package christmas

import christmas.domain.EventPlanner
import christmas.utils.Messages.Companion as MESSAGE

enum class MenuHeader(
    private val menu: List<Menu>
) {
    APPETIZER(listOf(Menu.MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN(listOf(Menu.T_BONE_STEAK, Menu.BARBECUE_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT(listOf(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    BEVERAGE(listOf(Menu.COKE_ZERO, Menu.RED_WINE, Menu.CHAMPAGNE));

    companion object {
        fun isInMenuHeader(menuHeader: MenuHeader, order: String): Boolean {
            var isInMenuHeader = false
            for(menu in menuHeader.menu) {
                if(Menu.isSameMenu(order, menu))
                    isInMenuHeader = true
            }
            return isInMenuHeader
        }
    }
}

enum class Menu(
    private val menuName: String,
    private val price: Int
) {
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),
    T_BONE_STEAK("티본스테이크", 5_500),
    BARBECUE_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),
    CHOCOLATE_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),
    COKE_ZERO("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    companion object {
        val giveawayQauntity = 1

        fun getGiveawayMenu(): String {
            return CHAMPAGNE.menuName + " ${giveawayQauntity}${MESSAGE.QUANTITY_UNIT}"
        }
        fun informGiveawayBenefit(): String {
            EventPlanner.totalBenefits += CHAMPAGNE.price
            return MESSAGE.GIVEAWAY_EVENT + CHAMPAGNE.price
        }

        fun isSameMenu(order: String, menu: Menu): Boolean {
            return menu.menuName == order
        }

        fun calculateEachTotal(order: Map.Entry<String, Int>): Int {
            val menu = Menu.values().find { it.menuName == order.key }
            return menu!!.price * order.value
        }
    }
}
fun main() {
    val event = EventPlanner()

    event.startEventPlanner()
}
