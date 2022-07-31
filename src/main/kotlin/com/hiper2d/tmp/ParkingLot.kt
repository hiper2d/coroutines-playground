package com.hiper2d.tmp

import java.math.BigDecimal

enum class SpaceType(rate: BigDecimal) {
    COMPACT(BigDecimal(3)),
    REGULAR(BigDecimal(4)),
    LARGE(BigDecimal(7))
}

class Spot(var occupied: Boolean)

class Space(
    private val compactCapacity: Int,
    private val regularCapacity: Int,
    private val largeCapacity: Int
) {
    var compactAvailable = compactCapacity
    var regularAvailable = regularCapacity
    var largeAvailable = largeCapacity
}

interface ParkingLot {
    fun parkCar(carSize: SpaceType): Receipt
    fun leave(receipt: Receipt)
    fun isCompactSpotAvailable(): Boolean
    fun isRegularSpotAvailable(): Boolean
    fun isLargeSpotAvailable(): Boolean
}

class ParkingLotImpl(private val spaces: List<Space>): ParkingLot {
    override fun parkCar(carSize: SpaceType): Receipt {
        TODO("Not yet implemented")
    }

    override fun leave(receipt: Receipt) {
        TODO("Not yet implemented")
    }

    override fun isCompactSpotAvailable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isRegularSpotAvailable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isLargeSpotAvailable(): Boolean {
        TODO("Not yet implemented")
    }
}

class Receipt {

}