package christmas.utils

class Messages {
    companion object {
        const val WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."
        const val WHEN_IS_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
        const val TAKE_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
        const val PREVIEW_OF_DISCOUNT_FRONT = "12월 "
        const val PREVIEW_OF_DISCOUNT_BACK = "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

        const val ORDERED_MENU = "<주문 메뉴>"
        const val TOTAL_BEFORE_DISCOUNT = "<할인 전 총주문 금액>"
        const val GIVEAWAY_MENU = "<증정 메뉴>"
        const val BENEFITS_DETAILS = "<혜택 내역>"
        const val TOTAL_BENEFITS = "<총혜택 금액>"
        const val TOTAL_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>"
        const val BADGE_OF_EVENT = "<12월 이벤트 배지>"

        const val CURRENCY_UNIT = "원"
        const val QUANTITY_UNIT = "개"
        const val NOTHING_POSSIBLE = "없음"
        const val CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: -"
        const val WEEKDAY_DISCOUNT = "평일 할인: -"
        const val WEEKEND_DISCOUNT = "주말 할인: -"
        const val STARRED_DISCOUNT = "특별 할인: -"
        const val GIVEAWAY_EVENT = "증정 이벤트: -"
        const val BADGE_OVER_5_000 = "별"
        const val BADGE_OVER_10_000 = "트리"
        const val BADGE_OVER_20_000 = "산타"

        const val WRONG_DISCOUNT_SUSPECTED = "[ERROR] 할인 금액이 정상적으로 책정되지 않았습니다. 확인이 필요합니다."
        const val TOO_MANY_MENU = "[ERROR] 총 20개까지만 주문 가능합니다. 다시 입력해 주세요."
        const val INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
        const val INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."
    }
}