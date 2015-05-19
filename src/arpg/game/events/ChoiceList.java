/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andrew
 * 
 */
public class ChoiceList {
	
	// TODO Finish deciding on this
	/**
	 * 
	 */
	public static final Choice continueOn = new Choice("Continue. ");
	
	// static final Choice doNothing = new Choice("Do nothing. ");
	
	// static final Choice wait = new Choice("Wait. ");
	
	ArrayList<Choice> choices;
	
	/**
	 * 
	 */
	public ChoiceList () {
		
		// TODO Auto-generated constructor stub
		
		choices = new ArrayList<Choice>();
		// choices.add(new Choice("Continue. "));
		
	}
	
	/**
	 * 
	 * @param choices
	 */
	public ChoiceList (ArrayList<Choice> choices) {
		
		this.choices = choices;
		
	}
	
	/**
	 * @param arguments
	 */
	public ChoiceList (Choice... arguments) {
		
		choices = new ArrayList<Choice>(Arrays.asList(arguments));
		
	}
	
	/**
	 * @param c
	 */
	public void add (Choice c) {
		
		choices.add(c);
		
	}
	
	/**
	 * @return a list with the choice strings
	 */
	public ArrayList<String> getChoiceText () {
		
		ArrayList<String> text = new ArrayList<String>(choices.size());
		for (Choice c : choices) {
			
			text.add(c.text);
			
		}
		
		return text;
		
	}
}
