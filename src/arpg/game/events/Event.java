/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;

import arpg.game.effects.Effect;
import arpg.game.effects.EmptyEffect;

/**
 * @author Andrew
 * 
 */
/**
 * @author Andrew
 * 
 */
public class Event {
	
	/**
	 * 
	 */
	public static final ChoiceList CONTINUE_ON = new ChoiceList(ChoiceList.continueOn);
	
	//	static final ChoiceList DO_NOTHING = new ChoiceList(ChoiceList.doNothing);
	//	static final ChoiceList WAIT = new ChoiceList(ChoiceList.wait);
	
	/**
	 * Event ID (Unique identifier, Required)
	 */
	public final String ID;
	
	/**
	 * Event Name
	 */
	public final String name;
	
	/**
	 * Event text (Required)
	 */
	public final TextContainer text;
	
	/**
	 * A list of the choices available at the event
	 * 
	 */
	public ChoiceList choices;
	
	/**
	 * The effect of the event
	 */
	public Effect effect;
	
	/**
	 * Is true if the effect should be hidden
	 */
	public boolean isHidden;
	
	/**
	 * 
	 */
	public String playlistName;
	
	/**
	 * @param effect
	 */
	public Event (Effect effect) {
		
		this("", "");
		
		this.effect = effect;
		isHidden = true;
		
	}
	
	/**
	 * @param text
	 * @param effect
	 */
	public <T extends Effect> Event (String text, T effect) {
		
		this("", text);
		this.effect = effect;
		
	}
	
	/**
	 * Constructor
	 * 
	 * 
	 * @param name
	 * @param text
	 */
	public Event (String name, String text) {
		
		this(name, text, EmptyEffect.getInstance());
		
	}
	
	/**
	 * @param name
	 * @param text
	 * @param effect
	 */
	public Event (String name, String text, Effect effect) {
		
		ID = "";
		this.name = name;
		this.text = new Text(text);
		
		choices = CONTINUE_ON;
		this.effect = effect;
		
	}
	
	/**
	 * Constructor
	 * 
	 * 
	 * @param name
	 * @param text
	 * @param arguments
	 *            Varargs for events
	 */
	public Event (String name, String text, Choice... arguments) {
		
		ID = "";
		this.name = name;
		this.text = new Text(text);
		
		choices = new ChoiceList();
		for (Choice c : arguments) {
			
			choices.add(c);
			
		}
		
	}
	
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
		this.text = new Text(text);
		
		choices = new ChoiceList();
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 */
	public Event (String ID, String name, TextContainer text) {
		this.ID = ID;
		this.name = name;
		this.text = text;
		choices = new ChoiceList();
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 * @param playlistName
	 * @param arguments
	 */
	public Event (String ID, String name, TextContainer text,
			String playlistName, Choice... arguments) {
		
		this.ID = ID;
		this.name = name;
		this.text = text;
		this.playlistName = playlistName;
		
		choices = new ChoiceList();
		for (Choice c : arguments) {
			
			choices.add(c);
			
		}
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 * @param playlistName
	 * @param choices
	 */
	public Event (String ID, String name, TextContainer text,
			String playlistName, ChoiceList choices) {
		
		this.ID = ID;
		this.name = name;
		this.text = text;
		this.playlistName = playlistName;
		
		this.choices = choices;
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param ID
	 * @param name
	 * @param text
	 * @param arguments
	 *            Varargs for events
	 */
	public Event (String ID, String name, String text, Choice... arguments) {
		
		this.ID = ID;
		this.name = name;
		this.text = new Text(text);
		
		choices = new ChoiceList();
		for (Choice c : arguments) {
			
			choices.add(c);
			
		}
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 * @param choices
	 * @param effect
	 * @param isHidden
	 * @param playlistName
	 * 
	 */
	public Event (String ID, String name, String text, ChoiceList choices,
			Effect effect, boolean isHidden, String playlistName) {
		
		// TODO Auto-generated constructor stub
		
		this.ID = ID;
		this.name = name;
		this.text = new Text(text);
		this.choices = choices;
		this.effect = effect;
		this.isHidden = isHidden;
		this.playlistName = playlistName;
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 * @param choices
	 * @param effect
	 * @param isHidden
	 * @param playlistName
	 * 
	 */
	public Event (String ID, String name, TextContainer text,
			ChoiceList choices, Effect effect, boolean isHidden,
			String playlistName) {
		this.ID = ID;
		this.name = name;
		this.text = text;
		this.choices = choices;
		this.effect = effect;
		this.isHidden = isHidden;
		this.playlistName = playlistName;
	}

	/**
	 * @return an ArrayList with the text of the Choices
	 */
	public ArrayList<String> getChoiceText () {
		
		return choices.getChoiceText();
		
	}
	
	/**
	 * @param i
	 * @return
	 */
	public Choice getChoice (int i) {
		
		return choices.getChoice(i);
		
	}
	
	/**
	 * @return the ID
	 */
	public String getID () {
		return ID;
	}
	
}
