import java.awt.Robot
import java.awt.event.InputEvent
import java.util.Scanner

System.setProperty("java.awt.headless", "false");

var shouldClick = true
var shouldContinue = true;

val clicker = object : Runnable {
    override fun run() {
        while(shouldContinue){

            if(shouldClick){
                val bot = Robot()
                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK)
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK)
            }
            Thread.sleep(5000)
        }
    }
}

Thread(clicker).start()

while(true) {
    print("->")
    val command = Scanner(System.`in`).next()

    when(command) {
        "pause" -> shouldClick = false
        "resume" -> shouldClick = true
        "exit" -> shouldContinue = false
        "status" -> println(if(shouldClick) "Running" else "Paused")
    }
    if(!shouldContinue)
        break;
}