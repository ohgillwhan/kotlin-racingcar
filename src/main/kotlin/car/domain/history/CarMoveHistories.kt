package car.domain.history

import car.domain.Position

data class CarMoveHistories(
    private val moveHistories: List<CarMoveHistory> = listOf()
) : List<CarMoveHistory> by moveHistories {
    val maxPosition: Position = Position(moveHistories.map { it.position.value }.max() ?: 0)
}
