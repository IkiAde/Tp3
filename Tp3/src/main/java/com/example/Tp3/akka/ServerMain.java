package com.example.Tp3.akka;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import scala.concurrent.duration.FiniteDuration;

public class ServerMain {
	public static void main(String [] args) throws TimeoutException{
		
		ActorSystem system = ActorSystem.create("MySystem");
		var server = system.actorOf( Props.create(ServerActor.class), "server" );
		Inbox inbox = Inbox.create(system);
		inbox.send( server, new RequestMessage("ping") );
		// ... des traitements quelconques ...
		Object reply = inbox.receive(FiniteDuration.create(5,TimeUnit.SECONDS));
		if( reply instanceof ResponseMessage rm ) {
		System.out.println("Réponse : "+rm.message()); }
	}
}
