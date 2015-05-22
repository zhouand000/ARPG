/**
 * 
 */
package arpg.game.events;

import arpg.game.effects.StatusEffect;

/**
 * Basic events prototype
 * 
 * @author Andrew
 * 
 */
public class EventRandomizer {
	
	public EventCollection events = new EventCollection();
	
	/**
	 * The location of the events folder
	 */
	public static final String eventsFolderLocation = "arpg/assets/events/";
	
	/**
	 * 
	 */
	public EventRandomizer () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public void initEventlist () {
		
		this.events.add(
				new Event ("Temple", "You arrive at a temple. There are two doors.",
						new Choice("Enter the left door.", new Event("Temple_NearMiss","Near Miss in the Temple" ,"You are hit by a poisoned arrow.")))
				new Choice("Enter the right door."), new Event("Temple_Locked","Locked Door","This door appears to be locked")
				)));
				
	}
	
}
