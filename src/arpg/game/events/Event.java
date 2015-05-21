/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;

import arpg.game.effects.Effect;
import arpg.game.effects.EmptyEffect;
import arpg.game.sound.Playlist;

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
	public final String text;
	
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
	public final Playlist playlist;
	
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
		this.text = text;
		
		choices = CONTINUE_ON;
		this.effect = effect;
		playlist = new Playlist(name);
		
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
		this.text = text;
		
		choices = new ChoiceList();
		for (Choice c : arguments) {
			
			choices.add(c);
			
		}
		
		playlist = new Playlist(name);
		
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
		this.text = text;
		
		choices = new ChoiceList();
		playlist = new Playlist(name);
		
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
		this.text = text;
		
		choices = new ChoiceList();
		for (Choice c : arguments) {
			
			choices.add(c);
			
		}
		
		playlist = new Playlist(name);
		
	}
	
	/**
	 * @param ID
	 * @param name
	 * @param text
	 * @param choices
	 * @param effect
	 * @param isHidden
	 * @param playlist
	 * 
	 */
	public Event (String ID, String name, String text, ChoiceList choices,
			Effect effect, boolean isHidden, Playlist playlist) {
		
		// TODO Auto-generated constructor stub
		
		this.ID = ID;
		this.name = name;
		this.text = text;
		this.choices = choices;
		this.effect = effect;
		this.isHidden = isHidden;
		this.playlist = playlist;
		
	}
	
	/**
	 * @return an ArrayList with the text of the Choices
	 */
	public ArrayList<String> getChoiceText () {
		
		return choices.getChoiceText();
		
	}
	
	/**
	 * @param arguments
	 */
	public void addToPlaylist (String... arguments) {
		
		for (String s : arguments) {
			
			playlist.add(s);
			
		}
		
	}
	
	/**
	 * @return the iD
	 */
	public String getID () {
		return ID;
	}
	
}
