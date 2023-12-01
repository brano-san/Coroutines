import kotlinx.coroutines.*

suspend fun main(args: Array<String>){
    runBlocking()
    {
        launch{
            clock(5, "tick")
        }
        launch {
            clock(7, "tack")
        }
        launch {
            clock(10, "oi")
        }
    }
}

suspend fun clock(time : Int, sound : String)
{
    for (i in 0 ..< time - 1)
    {
        delay(1000)
        print("$sound (${i + 1})    ")
    }
    delay(1000)
    println("$sound ($time) = BOOM")
}