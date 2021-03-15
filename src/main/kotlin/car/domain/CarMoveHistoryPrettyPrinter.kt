package car.domain

class CarMoveHistoryPrettyPrinter(
    private val carMoveHistory: CarMoveHistory,
    private val positionExpression: String = CarMoveHistory.DEFAULT_POSITION_EXPRESSION
) {
    override fun toString(): String {
        return "${carMoveHistory.carName.name} : ${positionExpression.repeat(carMoveHistory.position)}"
    }
}
