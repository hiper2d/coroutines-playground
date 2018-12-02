import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
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