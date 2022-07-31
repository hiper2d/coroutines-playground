package com.hiper2d.tmp

class CoffeeMachine {
    private var beans: Int = 0
    private var watter: Int = 0
    private var milk: Int = 0
    private var sugar: Int = 0

    init {
        addSupplies()
    }

    @Synchronized
    fun makeCoffee(type: CoffeeType, roast: CoffeeRoast): Coffee {
        if (checkSupplies(type)) {
            substractSupplies(type)
            return when (type) {
                CoffeeType.LATE -> Late(roast)
                CoffeeType.CAPPUCCINO -> Cappuccino(roast)
                CoffeeType.AMERICANO -> Americano(roast)
            }
        } else {
            throw NotEnoughSuppliesException()
        }
    }

    private fun substractSupplies(type: CoffeeType) {
        beans -= type.beans
    }

    private fun checkSupplies(type: CoffeeType) = type.water <= watter && type.beans <= beans && type.milk > milk

    private fun addSupplies() {
        beans = 100
        watter = 100
        milk = 100
    }
}

class NotEnoughSuppliesException : RuntimeException() {

}

class UnknownCoffeeTypeException : RuntimeException() {

}

abstract class Coffee(val roast: CoffeeRoast) {
}

class Late(roast: CoffeeRoast): Coffee(roast)
class Cappuccino(roast: CoffeeRoast): Coffee(roast)
class Americano(roast: CoffeeRoast): Coffee(roast)

enum class CoffeeType(val beans: Int, val milk: Int, val water: Int) {
    LATE(beans = 1, milk = 5, water = 2),
    CAPPUCCINO(beans = 1, milk = 5, water = 2),
    AMERICANO(beans = 2, milk = 0, water = 5)
}

enum class CoffeeRoast {
    DARK, LITE
}
