# Kotlin Syntax

## Classes

### Basic classes and constructors

```kotlin
// public modifier is default
class Person
class Person2(name: String = "None") // primary constructor with argument
class Person3(val name: String) // final filed
class Person4 private constructor(name: String) { // explicit definition of primary constructor
    init {
        println("constructor init logic") // primary constructor cannot contain any code
    }
}

// secondary constructor with no primary
class Person5(val pets: MutableList<Pet> = mutableListOf())
class Pet {
    constructor(owner: Person5) { // secondary constructor
        owner.pets.add(this)
    }
}

// both primary and secondary constructors
// each secondary constructor must delegate to the primary constructor
class Person6(val name: String) {
    val children: MutableList<Person6> = mutableListOf()
    constructor(name: String, parent: Person6): this(name) {
        parent.children.add(this)
    }
}
```

### Static

```kotlin
// There is no static keyword, Companion objects should be used instead
class MyClass {
    companion object Factory {
        const val CONSTANT = 1
        fun create(): MyClass = MyClass()
    }
}
val instance = MyClass.create()
println(MyClass.CONSTANT)
```

```kotlin
interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object: Factory<MyClass> {
        override fun create(): MyClass {
            TODO("Not yet implemented")
        }
    }
}

val f: Factory<MyClass> = MyClass
f.create()
```

Singleton example
```kotlin
class Singleton private constructor() {
    companion object {
        val instance = Singleton()
    }
}

class LazySingleton private constructor() {
    companion object {
        val instance: UtilProject by lazy { UtilProject() }       
    }
}

Singleton.instance
LazySingleton.instance
```

### Enums

```kotlin
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
```

### Data Classes

```kotlin
// Data classes comes with equals, hashCode, toString, copy and componentN (necessary for destructuring)
data class User(val name: String, val age: Int)

//If some property needs to be excluded from autogenerated methods, it should be moved out of constructor
data class Person(val name: String) {
    var age: Int = 0
}

// destructuring
val jane = User("Jane", 35)
val (name, age) = jane
```

### Inheritance
```kotlin
open class Base(p: Int)
class Derived(p: Int) : Base(p)

class MyView : View {
    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}
```

## Collections

### Arrays

```kotlin
// int primitive
val a1 = intArrayOf(1, 2, 3)
val a2 = IntArray(3) // [0, 0, 0]
val a3 = IntArray(3) { it } // [0, 1, 2], because it is an index

a1.size
a1.count { it > 2 }
a1.find { it > 2 }
a1.findLast { it > 2 }
2 in a1
a1.joinToString(",", "[", "]")

a1.sort() // sort itself
a1.reverse()
a1.sortDescending()
val a1reversed = a1.reversed()
val a1Sorted = a1.sorted()

// Concat Array
val aConcat: IntArray = a1 + a2
aConcat.sliceArray(0..2) // [1,2,3] INCLUSIVE because arg is range

// Copy Array
val aCopy = aConcat.copyOf()
val aCopy2 = aConcat.copyOfRange(0, 2) // [1,2,3] NOT INCLUSIVE as arg isn't range

aCopy2.joinToString(",", "[", "]") // [1,2,3,0,0,0]

// object array
val arr4 = arrayOf(1, 2, 3) // array of Int objects
val arr5 = arrayOfNulls<Int?>(3) // array of Int objects initialized as Nulls
val arr6 = Array(3) { 0 } // array of Int objects initialized as 0
```

Matrix
```kotlin
val a: Array<IntArray> = Array(3) { IntArray(3) }
```

### List

```kotlin
import java.util.*

val l = LinkedList<Int>()

// Add to the tail (back)
l.add(0)
l.addLast(3)
l.add(1, 2) // add 2 and index 1 shifting the rest to the right
println(l) // 0, 2, 3

// Add to the head (frond)
l.addFirst(-1)
l.push(-2)
println(l) // -2, -1, 0, 1, 2

// Check head
l.peek() // -2
l.first // -2

// Check tail
l.peekLast() // 3
l.last // 3

// Remove head
l.pop() // -2; throws NoSuchElementException if empty
l.poll() // -1; returns null if empty
l.pollFirst() // 0
l.remove() // 2; throws NoSuchElementException if empty

// Remove tail
l.removeLast() // 3; throws NoSuchElementException if empty
l.pollLast() // null

//Copy list
val copy = l.toMutableList()

//Matrix
val m = mutableListOf<MutableList<Int>>()
```

### Map

```kotlin
val m1 = mapOf("a" to 1, "b" to 2)
val m2 = mutableMapOf(1 to 1)

m1.entries
m1.keys
m1.values

val m1Filtered1 = m1.filterKeys { it > 1 }
val m1Filtered2 = m1.filterValues { it > 1 }
val m1Filtered3 = m1.filterValues { it.key > 1 }
```

### Set

```kotlin
val s1 = setOf(1, 2, 3, 44, 1)
val s2 = mutableSetOf(1, 2, 3)
s2.add(4)
s2.remove(4)
```

### Queue (LinkedList)

```kotlin
import java.util.*

val l = LinkedList<Int>()
l.add(1)
l.addFirst(2)
```

## Loops

### Array/List/Map traversal

```kotlin
val a = arrayOf("one", "two", "three")
val l = listOf(1, 2, 3)
val m = mapOf(1 to 1, 2 to 2)

// foreach
a.forEach { println(it) }
a.forEachIndexed { index, s -> println("$index $s") }

// loop through elements
for(item in a) { println("a") }
for((k, v) in m) { println("$k $v") }

// loop through elements with index
for((index, item) in l.withIndex()) { println("$index, $item") }
for((index, item) in a.withIndex()) { println("$index, $item") }

// iterate backwards using ranges
(a.lastIndex downTo 0).map { l[it] }.joinToString(",") // 3,2,1
```

### Ranges

```kotlin
(0..2).joinToString(",") // 0,1,2
(0 until 2).joinToString(",") // 0,1
(0..2 step 2).joinToString(",") // 0,2
(2 downTo 0).joinToString(",") // 2,0,1

(0..10).random() // random int
```

## Strings

```kotlin
val s = "String"
s.slice(0..2) // INCLUSIVE
s.slice(2 downTo 0) // INCLUSIVE
s.indexOf('t')
s.lastIndexOf('t')

val c : CharArray = CharArray(9) { 'a' + it }
c.concatToString()
```

## Math

```kotlin
import kotlin.math.ceil

val a = 5
val b = 2
a / b // 2
a % b // 1

// Divide to get double
val c = a.toDouble() / b // 2.5
ceil(c) // 3.0

// Conversion
a.toString()
"5".toInt()
```
