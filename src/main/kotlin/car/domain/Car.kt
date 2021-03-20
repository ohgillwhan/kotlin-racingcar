package car.domain

import car.domain.history.CarMoveHistory
import car.domain.history.CarMoveHistoryCollection
import car.domain.move.MovableStrategy

class Car(
    val carName: CarName,
    position: Int = INIT_POSITION,
    private val movableStrategy: MovableStrategy
) {
    private val _histories: MutableList<CarMoveHistory> = mutableListOf()
    val historyCollection: CarMoveHistoryCollection
        get() = CarMoveHistoryCollection(_histories)

    var position: Int = position
        private set

    constructor(
        carName: String,
        position: Int = INIT_POSITION,
        movableStrategy: MovableStrategy
    ) : this(CarName(carName), position, movableStrategy)

    fun move() {
        if (movableStrategy.movable) {
            position++
        }
        _histories.add(CarMoveHistory(carName, position))
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
