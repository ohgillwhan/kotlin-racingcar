package car.business

class CarMoveHistoryCollection(moveHistories: List<CarMoveHistory>) {
    val moveHistories: List<CarMoveHistory> = moveHistories

    fun getWinners(): List<CarMoveHistory> {
        val maxPosition = moveHistories.map { it.position }
            .max()
        return moveHistories.filter { it.position == maxPosition }
    }
}
