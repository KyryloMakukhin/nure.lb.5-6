import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Class that represents CustomActor entity
  */
class CustomActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val customActor = system.actorOf(Props[CustomActor], name = "customactor")
  customActor ! "hello"
  customActor ! "bonjour"

  Thread.sleep(1000L)
  system.shutdown()
}