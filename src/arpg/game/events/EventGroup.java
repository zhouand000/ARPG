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
	
	/**
	 * The group's ID
	 */
	public final String ID;
	
	/**
	 * The group's name.
	 */
	public final String name;
	
	ArrayList<Event> eventList;
	
	Random rng = new Random(0L);
	
	/**
	 * 
	 */
	public EventGroup () {
		
		ID = "";
		name = "";
		eventList = new ArrayList<Event>();
	}
	
	/**
	 * @param arguments
	 * 
	 */
	public EventGroup (Event... arguments) {
		ID = "";
		name = "";
		eventList = new ArrayList<Event>(Arrays.asList(arguments));
		
	}
	

	
	/**
	 * @param ID
	 * @param name
	 * @param arguments
	 */
	public EventGroup (String ID, String name, Event... arguments) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.name = name;
		eventList = new ArrayList<Event>(Arrays.asList(arguments));
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param eventList
	 */
	public EventGroup (String ID, String name, ArrayList<Event> eventList) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.name = name;
		this.eventList = eventList;
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
