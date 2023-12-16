import kotlinx.coroutines.*

suspend fun main(args: Array<String>){
    runBlocking()
    {
        launch{
            clockFixed(5, "tick", false)
        }
        launch {
            clockFixed(7, "tack", false)
        }
        launch {
            clockFixed(10, "oi", true)
        }
    }
}

suspend fun clock(time : Int, sound : String, isLineRequired : Boolean)
{
    for (i in 0 ..< time - 1)
    {
        delay(1000)
        print("$sound (${i + 1})    ")
        if (isLineRequired)
            println()
    }
    delay(1000)
    println("$sound ($time) = BOOM")
}

suspend fun clockFixed(time : Int, sound : String, isLineRequired : Boolean)
{
    for (i in 0 ..< time - 1)
    {
        delay(1000)
        print("$sound (${i + 1})    ")
        if (isLineRequired)
            println()
        if (i == time - 2){
            println("$sound ($time) = BOOM")
        }
    }
}