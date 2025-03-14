package com.example.Tp3.akka;

import akka.actor.UntypedActor;

public class ServerActor extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Throwable {
		if (message instanceof RequestMessage rm) {
			System.out.println("Message reçu: "+ rm.message());
			var response= new ResponseMessage("pong");
			
			getSender().tell(response, getSelf());
		}
		
	}

}
