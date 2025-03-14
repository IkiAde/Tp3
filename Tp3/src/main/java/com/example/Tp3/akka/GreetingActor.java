package com.example.Tp3.akka;

import akka.actor.UntypedActor;

public class GreetingActor extends UntypedActor{

	 public void onReceive( Object message ) {
	        if( message instanceof GreetingMessage m ) {
	            System.out.println("Message de "+m.who);
	        }
	    }

}
