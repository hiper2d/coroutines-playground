package com.hiper2d.basics

import kotlinx.coroutines.*

fun main() {
    third()
}

private fun first() = runBlocking {
    val job = GlobalScope.launch { // launch new top-level coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // wait until child coroutine completes
}

private fun second() = runBlocking { // this: CoroutineScope
    launch { // launch new coroutine in the scope of runBlocking
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    // We can launch coroutines in this scope without having to join them explicitly, because an outer coroutine
    // (runBlocking) does not complete until all the coroutines launched in its scope complete.
}

private fun third() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }

    // Creates a new coroutine scope and does not complete until all launched children complete.
    // The main difference between runBlocking and coroutineScope
    // is that the latter does not block the current thread while waiting for all children to complete.
    coroutineScope {
        launch {
            doLaunch()
        }

        delay(100L)
        println("Task from coroutine scope") // This line will be printed before nested launch
    }

    println("Coroutine scope is over") // This line is not printed until nested launch completes
}

private suspend fun doLaunch() {
    delay(500L)
    println("Task from nested launch")
}