/**
 * 
 */
package arpg.game.events;

import java.util.*;

/**
 * @author Andrew
 * 
 */
public class EventCollection {
	
	ArrayList<Event> eventList;
	
	Random rng = new Random(0L);
	
	/**
	 * 
	 */
	public EventCollection () {
		
		eventList = new ArrayList<Event>();
	}
	
	/**
	 * @param arguments
	 * 
	 */
	public EventCollection (Event... arguments) {
		
		eventList = new ArrayList<Event>(Arrays.asList(arguments));
		
	}
	
	/**
	 * @return a random Event
	 */
	public Event getRandomEvent () {
		
		return eventList.get(rng.nextInt(eventList.size()));
		
	}
	
	/**
	 * @param arguments
	 * 
	 */
	public void add (Event... arguments) {
		
		for (Event e : arguments) {
			
			eventList.add(e);
			
		}
		
	}
	
}
