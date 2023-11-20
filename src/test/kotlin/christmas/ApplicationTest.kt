package christmas

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.ui.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class ApplicationTest : NsTest() {
    private val outputView = OutputView()

    @ValueSource(strings = ["a", " ", "123", "~!", "0"])
    @ParameterizedTest
    fun `날짜 예외 테스트`(input: String) {
        assertSimpleTest {
            runException(input)
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    @CsvSource(
        value = ["3:제로콜라-a", "3:레드와아인-1", "3:제로콜라-0", "3:샴페인--4", "5:제로콜라1개", "2:4-타파스", "2:타파스- ", "30:타파스-30", "15:타파스-14,아이스크림-10"],
        delimiter = ':'
    )
    @ParameterizedTest
    fun `주문 예외 테스트`(date: String, order: String) {
        assertSimpleTest {
            runException(date, order)
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `모든 타이틀 출력`() {
        assertSimpleTest {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            )
        }
    }

    @Test
    fun `혜택 내역 없음 출력`() {
        assertSimpleTest {
            run("26", "타파스-1,제로콜라-1")
            assertThat(output()).contains("<혜택 내역>$LINE_SEPARATOR".toString() + "없음")
        }
    }

    //@CsvSource(value = ["5000:별", "12000, 트리", "42300, 산타"], delimiter = ':')
    @Test
    fun `배지 출력`() {
        assertSimpleTest {
            outputView.printBadgeOfEvent(5000)
            assertThat(output()).contains("별")
        }
        assertSimpleTest {
            outputView.printBadgeOfEvent(12000)
            assertThat(output()).contains("트리")
        }
        assertSimpleTest {
            outputView.printBadgeOfEvent(42300)
            assertThat(output()).contains("산타")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private val LINE_SEPARATOR = System.lineSeparator()
    }
}
