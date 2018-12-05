import kotlinx.coroutines.*

fun main() {
    second()
}

private fun first() = runBlocking {
    val job = launch {
        doManyLaunches()
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")

    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}

private suspend fun doManyLaunches() {
    repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
    }
}

private fun second() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}