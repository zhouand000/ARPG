/**
 * 
 */
package arpg.game.events;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import arpg.game.effects.Effect;
import arpg.game.events.EventFactory.EventXMLHandler.EventGroupPrototype;
import arpg.game.events.EventFactory.EventXMLHandler.EventPrototype;
import arpg.game.sound.Playlist;

/**
 * @author Andrew
 * 
 */
public class EventFactory {
	
	/**
	 * HashMap mapping event IDs to events
	 */
	public HashMap<String, EventPrototype> eventMap;
	
	/**
	 * HashMap mapping event group IDs to EventGroups
	 */
	public HashMap<String, EventGroupPrototype> eventGroupMap;
	
	ClassLoader loader = this.getClass().getClassLoader();
	
	/**
	 * The path to the default events file
	 */
	public static String pathToDefaultEventsFile = "arpg/assets/events/Events.xml";
	
	/**
	 * 
	 */
	public EventFactory () {
		
		// TODO Auto-generated constructor stub
		eventMap = new HashMap<String, EventPrototype>();
		eventGroupMap = new HashMap<String, EventGroupPrototype>();
		init();
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
	}
	
	void init () {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp;
		
		try {
			URL url = loader.getResource(pathToDefaultEventsFile);
			InputStream is = new FileInputStream(new File(url.toURI()));
			sp = spf.newSAXParser();
			EventXMLHandler exh = new EventXMLHandler();
			sp.parse(is, exh);
			System.out.println("Done parsing");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		public EventGroupPrototype eventGroupPrototype;
		
		/**
		 * 
		 */
		public EventXMLHandler () {
			// TODO Auto-generated constructor stub
			
			elementStack = new Stack<String>();
			objectStack = new Stack<Object>();
			
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement (String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			
			// TODO Auto-generated method stub
			
			elementStack.push(qName);
			
			System.out.println(elementStack.size() > 2
					? "Parent: " + elementStack.get(elementStack.size() - 2)
							+ " Child: " + elementStack.peek() : "Element: "
							+ elementStack.peek());
			
			if (qName == "eventfile") {
				
				// NO-OP
				return;
				
			}
			
			if (qName == "event") {
				
				if (attributes.getIndex("ID") != -1
						&& attributes.getIndex("name") != -1) {
					
					if (elementStack.size() > 2
							&& elementStack.get(elementStack.size() - 2) == "eventList") {
						
						EventPrototype ep = new EventPrototype();
						objectStack.push(ep);
						
					}
					
				}
				
			}
			
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement (String uri, String localName, String qName)
				throws SAXException {
			// TODO Auto-generated method stub
			super.endElement(uri, localName, qName);
		}
		
		/**
		 * @author Andrew
		 * 
		 */
		public class EventGroupPrototype {
			
			/**
			 * ID of the Event
			 */
			public String ID;
			
			/**
			 * Name of the Event
			 */
			public String name;
			
			ArrayList<EventPrototype> eventList;
			
			Random rng = new Random(0L);
			
			/**
			 * 
			 */
			public EventGroupPrototype () {
				
				eventList = new ArrayList<EventPrototype>();
			}
			
			/**
			 * @param arguments
			 * 
			 */
			public EventGroupPrototype (EventPrototype... arguments) {
				
				eventList = new ArrayList<EventPrototype>(Arrays.asList(arguments));
				
			}
			
			/**
			 * @param arguments
			 * 
			 */
			public void add (EventPrototype... arguments) {
				
				for (EventPrototype e : arguments) {
					
					eventList.add(e);
					
				}
				
			}
			
			/**
			 * @return
			 */
			public EventGroup toEventGroup () {
				
				ArrayList<Event> output = new ArrayList<Event>();
				for (EventPrototype ep : eventList) {
					
					output.add(ep.toEvent());
				}
				return new EventGroup(ID, name, output);
				
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
				
				return new Event(ID, name, text, choices.toChoiceList(), effect, isHidden, playlist);
				
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
			
			/**
			 * @return
			 */
			public ChoiceList toChoiceList () {
				
				ArrayList<Choice> choiceArrayList = new ArrayList<Choice>();
				for (ChoicePrototype cp : choices) {
					
					choiceArrayList.add(cp.toChoice());
					
				}
				return new ChoiceList(choiceArrayList);
				
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
			public final EventGroupPrototype nextEvent;
			
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
			public ChoicePrototype (String text, EventPrototype... arguments) {
				
				this.text = text;
				nextEvent = new EventGroupPrototype(arguments);
			}
			
			/**
			 * @param text
			 * @param nextEvent
			 */
			public ChoicePrototype (String text, EventGroupPrototype nextEvent) {
				
				this.text = text;
				this.nextEvent = nextEvent;
				
			}
			
			/**
			 * @return
			 */
			public Choice toChoice () {
				
				return new Choice(text, nextEvent.toEventGroup());
				
			}
			
		}
		
	}
	
	/**
	 * @author Andrew
	 * 
	 */
	@SuppressWarnings("javadoc")
	public enum ElementType {
		
		EventFile,
		EventList,
		Event,
		Location,
		Biome,
		Place,
		Choice,
		TextList,
		Text,
		
	}
	
}
