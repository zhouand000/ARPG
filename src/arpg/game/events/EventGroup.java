/**
 * 
 */
package arpg.game.events;

import java.util.*;

/**
 * @author Andrew
 * 
 */
public class EventGroup {
	
	ArrayList<Event> eventList;
	
	Random rng = new Random(0L);
	
	/**
	 * 
	 */
	public EventGroup () {
		
		eventList = new ArrayList<Event>();
	}
	
	/**
	 * @param arguments
	 * 
	 */
	public EventGroup (Event... arguments) {
		
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
