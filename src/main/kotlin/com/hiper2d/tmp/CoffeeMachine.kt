abstract class Coffee
class Latte: Coffee()
class Americano: Coffee()
enum class CoffeeType {
    LATTE, AMERICANO
}

class CoffeeMachine {
    private var beansLevel = 0
    private var milkLevel = 0

    fun makeCoffee(coffeeType: CoffeeType): Coffee {
        return when (coffeeType) {
            CoffeeType.LATTE -> Latte()
            CoffeeType.AMERICANO -> Americano()
        }
    }
}