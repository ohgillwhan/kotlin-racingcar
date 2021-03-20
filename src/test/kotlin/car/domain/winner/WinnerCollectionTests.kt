package car.domain.winner

import car.domain.move.AlwaysMovableStrategy
import car.domain.Car
import car.domain.CarCollection
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerCollectionTests {
    @Test
    fun `승리자 목록은 자동차 중 최고 위치에 있는 애들로 뽑아야 한다`() {
        val cars = CarCollection(
            listOf(
                createMockMovableCar("1번차", 3),
                createMockMovableCar("2번차", 5),
                createMockMovableCar("3번차", 2),
                createMockMovableCar("4번차", 5),
                createMockMovableCar("5번차", 1)
            )
        )
        val winners = WinnerCollection(cars)

        assertThat(winners.winners)
            .containsExactlyInAnyOrder(
                Winner("2번차"),
                Winner("4번차")
            )
    }

    private fun createMockMovableCar(carName: String, currentPosition: Int): Car {
        val car = Car(carName, currentPosition, AlwaysMovableStrategy())

        return car
    }
}
