package com.hiper2d.tmp

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.withLock

class LoadBalancer(private val hosts: MutableList<String> = mutableListOf()) {

    private val counter: AtomicInteger = AtomicInteger(0)
    private val lock: ReadWriteLock = ReentrantReadWriteLock()

    fun getHost(): String {
        val readLock = lock.readLock()
        return readLock.withLock {
            val current = counter.getAndAccumulate(hosts.size - 1) { x, size -> if (x == size) 0 else x + 1 }
            hosts[current]
        }
    }

    fun addHost(newHost: String) {
        val writeLock = lock.writeLock()
        writeLock.withLock {
            hosts.add(newHost)
        }
    }
}

fun main() {
    val lb = LoadBalancer(mutableListOf("a", "b", "c"))
    val t1 = Thread {
        repeat(10) {
            println("first thread: ${lb.getHost()}")
            TimeUnit.SECONDS.sleep(1)
        }
    }
    val t2 = Thread {
        (0..2).forEach {
            println("adding new host")
            lb.addHost("d$it")
            TimeUnit.SECONDS.sleep(1)
        }
    }

    listOf(t1, t2).forEach {
        it.start()
    }
    listOf(t1, t2).forEach {
        it.join()
    }

}