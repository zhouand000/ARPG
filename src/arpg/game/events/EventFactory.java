/**
 * 
 */
package arpg.game.events;

import java.util.*;

import org.xml.sax.helpers.DefaultHandler;

import arpg.game.effects.Effect;
import arpg.game.sound.Playlist;

/**
 * @author Andrew
 * 
 */
public class EventFactory {
	
	/**
	 * HashMap mapping event IDs to events
	 */
	public HashMap<String, Event> eventMap;
	
	/**
	 * HashMap mapping event group IDs to EventGroups
	 */
	public HashMap<String, EventGroup> eventGroupMap;
	
	/**
	 * 
	 */
	public EventFactory () {
		// TODO Auto-generated constructor stub
		eventMap = new HashMap<String, Event>();
		eventGroupMap = new HashMap<String, EventGroup>();
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
	}
	
	void initEvents () {
		
	}
	
	/**
	 * @author Andrew
	 * 
	 */
	public class EventXMLHandler extends DefaultHandler {
		
		/**
		 * 
		 */
		public Stack<String> elementStack;
		
		/**
		 * 
		 */
		public Stack<Object> objectStack;
		
		/**
		 * 
		 */
		public EventXMLHandler () {
			// TODO Auto-generated constructor stub
			
			elementStack = new Stack<String>();
			objectStack = new Stack<Object>();
			
		}
		
	}
	
	/**
	 * @author Andrew Event prototype object
	 */
	public class EventPrototype {
		
		/**
		 * Event ID (Unique identifier, Required)
		 */
		public String ID;
		
		/**
		 * Event Name
		 */
		public String name;
		
		/**
		 * Event text (Required)
		 */
		public String text;
		
		/**
		 * A list of the choices available at the event
		 * 
		 */
		public ChoiceListPrototype choices;
		
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
		public Playlist playlist;
		
		/**
		 * @return an event with the same values as the prototype
		 */
		public Event toEvent () {
			
			return new Event(ID, name, text, choices, effect, isHidden, playlist);
			
		}
		
	}
	
	/**
	 * @author Andrew
	 * 
	 */
	public class ChoiceListPrototype {
		
		// TODO Finish deciding on this
		
		// static final Choice doNothing = new Choice("Do nothing. ");
		
		// static final Choice wait = new Choice("Wait. ");
		
		ArrayList<ChoicePrototype> choices;
		
		/**
		 * 
		 */
		public ChoiceListPrototype () {
			
			// TODO Auto-generated constructor stub
			
			choices = new ArrayList<ChoicePrototype>();
			// choices.add(new Choice("Continue. "));
			
		}
		
		/**
		 * 
		 * @param choices
		 */
		public ChoiceListPrototype (ArrayList<ChoicePrototype> choices) {
			
			this.choices = choices;
			
		}
		
		/**
		 * @param arguments
		 */
		public ChoiceListPrototype (ChoicePrototype... arguments) {
			
			choices = new ArrayList<ChoicePrototype>(Arrays.asList(arguments));
			
		}
		
		/**
		 * @param c
		 */
		public void add (ChoicePrototype c) {
			
			choices.add(c);
			
		}
		
		/**
		 * @return a list with the choice strings
		 */
		public ArrayList<String> getChoiceText () {
			
			ArrayList<String> text = new ArrayList<String>(choices.size());
			for (ChoicePrototype c : choices) {
				
				text.add(c.text);
				
			}
			
			return text;
			
		}
		
		public ChoiceList toChoiceList () {
			return new ChoiceList(name, choices);
			
			
			
		}
		
	}
	
	/**
	 * @author Andrew
	 * 
	 */
	public class ChoicePrototype {
		
		/**
		 * The text of the choice
		 */
		public final String text;
		
		/**
		 * A list of possible events
		 * 
		 */
		public final EventGroup nextEvent;
		
		/**
		 * 
		 */
		public ChoicePrototype () {
			// TODO Auto-generated constructor stub
			
			text = "Continue.";
			nextEvent = null;
			
		}
		
		/**
		 * @param text
		 * @param arguments
		 */
		public ChoicePrototype (String text, Event... arguments) {
			
			this.text = text;
			nextEvent = new EventGroup(arguments);
			
		}
		
		/**
		 * @param text
		 * @param nextEvent
		 */
		public ChoicePrototype (String text, EventGroup nextEvent) {
			
			this.text = text;
			this.nextEvent = nextEvent;
			
		}
		
	}
	
}
