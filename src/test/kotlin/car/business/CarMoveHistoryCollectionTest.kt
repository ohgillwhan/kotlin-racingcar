package car.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoryCollectionTest {
    @Test
    fun `최고점수를 가진 Car를 리턴할 줄 알아야 한다`() {
        val histories: MutableList<CarMoveHistory> = ArrayList()

        histories.add(CarMoveHistory("오", 1))
        histories.add(CarMoveHistory("길", 2))
        histories.add(CarMoveHistory("환", 3))
        histories.add(CarMoveHistory("이", 4))
        histories.add(CarMoveHistory("다", 4))

        val historyCollection = CarMoveHistoryCollection(histories)

        val frontHistories = historyCollection.getFrontHistories()

        assertThat(frontHistories.map { it.carName })
            .containsExactly("이", "다")
    }
}
