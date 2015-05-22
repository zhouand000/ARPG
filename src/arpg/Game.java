/**
 * 
 */
package arpg;

import arpg.game.events.Event;

/**
 * @author Andrew
 * 
 */
public class Game {
	
	Event currentEvent;
	
	/**
	 * 
	 */
	public Game () {
		// TODO Auto-generated constructor stub
		
	}
	
	/**
	 * 
	 */
	public void startGame () {
		
		currentEvent = new Event("StartEvent", "Start Event", "Welcome to the realm of ARPG!");
		
	}
	
	/**
	 * 
	 */
	public void onTick () {
		
	}
	
}
