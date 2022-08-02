package com.hiper2d.tmp

class Fibonacci {
    companion object {
        fun findFibValueByIndex(index: Int): Int {
            if (index == 0 || index == 1) {
                return 1
            }
            var prev = 1
            var curr = 1
            (2..index).forEach { _ ->
                val tmp = curr
                curr += prev
                prev = tmp
            }
            return curr
        }
    }
}

fun main() {
    println(Fibonacci.findFibValueByIndex(0)) // 1 1 2 3 5 8
    println(Fibonacci.findFibValueByIndex(5)) // 1 1 2 3 5 8
}