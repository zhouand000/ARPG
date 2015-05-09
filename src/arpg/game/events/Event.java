/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;

/**
 * @author Andrew
 * 
 */
public class Event {
	
	//  static final ChoiceList CONTINUE_ON = new ChoiceList(ChoiceList.continueOn);
	//	static final ChoiceList DO_NOTHING = new ChoiceList(ChoiceList.doNothing);
	//	static final ChoiceList WAIT = new ChoiceList(ChoiceList.wait); 
	
	/**
	 * Event ID (Unique identifier, Required)
	 */
	public final String ID;
	
	/**
	 * Event Name (Optional)
	 */
	public final String name;
	
	/**
	 * Event text (Required)
	 */
	public final String text;
	
	ChoiceList choices;
	
	/**
	 * Constructor
	 * 
	 * @param ID
	 * @param name
	 * @param text
	 */
	public Event (String ID, String name, String text) {
		
		this.ID = ID;
		this.name = name;
		this.text = text;
		
		choices = new ChoiceList();
		
	}
	
	/**
	 * @return an ArrayList with the text of the Choices
	 */
	public ArrayList<String> getChoiceText () {
		
		return choices.getChoiceText();
		
	}
	
}
