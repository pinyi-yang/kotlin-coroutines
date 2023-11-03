import kotlinx.coroutines.*
import java.lang.Thread.sleep

fun main(args: Array<String>) {
//    sleepHello()
//    println("World!")

// first coroutine
//    runBlocking {
//        launch {
//            delay(1000)
//            println("World!")
//        }
//
//    }
//
//    println("Hello")
//
// extract function
//    runBlocking {
//        launch { sayHao() }
//
//        println("Ni")
//    }

//    /**
//     * Scope builder and concurrency
//     */
//    val sequential = runBlocking {
//        val result = mutableListOf<String>()
//
//        // different scope
//        addElementPerScope(result, "Two", 200)
//        addElementPerScope(result, "Three", 300)
//        addElementPerScope(result, "One", 100)
//
//        result
//    }
//    println(sequential)
//
//    val concurrency = runBlocking {
//        val result = mutableListOf<String>()
//
//        // same scope
//        coroutineScope {
//            addElementNoScope(result, "Two", 200)
//            addElementNoScope(result, "Three", 300)
//            addElementNoScope(result, "One", 100)
//        }
//
//        result
//    }
//    println(concurrency)
//
    runBlocking {
        (0 until 5000).map { // launch a lot of coroutines
            coroutineScope {
                launch {
                    delay(5000L)
                    println(it)
                }
            }
        }
    }
}

fun sleepHello() {
    sleep(1000)
    println("Hello")
}


suspend fun sayHao() {
    delay(1000)
    println("Hao")
}

suspend fun addElementPerScope(list: MutableList<String>, text: String, delay: Long) = coroutineScope {
    addElementNoScope(list, text, delay)
}

private fun CoroutineScope.addElementNoScope(
    list: MutableList<String>,
    text: String,
    delay: Long,
) = launch {
    delay(delay)
    list.add(text)
}