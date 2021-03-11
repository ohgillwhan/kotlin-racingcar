package car.io

import car.business.CarMoveHistoryCollection
import car.business.Cars

class ResultView(private val cars: Cars) {
    fun print() {
        val allHistories = cars.allHistories
        for (carMoveHistory in allHistories) {
            printCarPositionHistory(carMoveHistory)
            println()
        }
        printFrontCars(allHistories.last())
    }

    private fun printCarPositionHistory(carMoveHistoryCollection: CarMoveHistoryCollection) {
        for (history in carMoveHistoryCollection) {
            println(history)
        }
    }

    private fun printFrontCars(carMoveHistoryCollection: CarMoveHistoryCollection) {
        val frontHistories = carMoveHistoryCollection.getFrontHistories()

        val winnerNames = frontHistories.joinToString { it.car.name }

        print("$winnerNames 가 최종 우승했습니다.")
    }
}
