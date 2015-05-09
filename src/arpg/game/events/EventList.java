/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Andrew
 * 
 */
public class EventList {
	
	ArrayList<Event> eventList;
	
	Random rng = new Random(0L);
	
	/**
	 * @param arguments
	 * 
	 */
	public EventList (Event... arguments) {
		
		eventList = new ArrayList<Event>(Arrays.asList(arguments));
		
	}
	
	/**
	 * @return a random Event
	 */
	public Event getRandomEvent () {
		
		return eventList.get(rng.nextInt(eventList.size()));
		
	}
	
}
