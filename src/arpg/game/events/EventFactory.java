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
import arpg.game.events.EventFactory.EventXMLHandler.TextListPrototype;

/**
 * @author Andrew
 * 
 */
public class EventFactory {
	
	/**
	 * HashMap mapping event IDs to events
	 */
	public TreeMap<String, EventPrototype> eventPrototypeMap;
	
	/**
	 * HashMap mapping event group IDs to EventGroups
	 */
	public TreeMap<String, EventGroupPrototype> eventGroupPrototypeMap;
	
	/**
	 * 
	 */
	public TreeMap<String, TextListPrototype> textListPrototypeMap;
	
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
		eventPrototypeMap = new TreeMap<String, EventPrototype>(String.CASE_INSENSITIVE_ORDER);
		eventGroupPrototypeMap = new TreeMap<String, EventGroupPrototype>(String.CASE_INSENSITIVE_ORDER);
		textListPrototypeMap = new TreeMap<String, EventFactory.EventXMLHandler.TextListPrototype>(String.CASE_INSENSITIVE_ORDER);
		init();
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
		EventFactory ef = new EventFactory();
		
		System.out.println(ef.eventGroupPrototypeMap.toString());
		System.out.println(ef.eventPrototypeMap.toString());
		System.out.println();
		System.out.println(ef.textListPrototypeMap.toString());
		System.out.println(ef.eventPrototypeMap.get("Start"));
		
	}
	
	/**
	 * @return
	 */
	public Map<String, EventGroup> getEventGroupMap () {
		
		TreeMap<String, EventGroup> output = new TreeMap<String, EventGroup>(String.CASE_INSENSITIVE_ORDER);
		
		for (String s : eventGroupPrototypeMap.keySet()) {
			
			output.put(s, eventGroupPrototypeMap.get(s).toEventGroup());
			
		}
		
		return Collections.unmodifiableSortedMap(output);
		
	}
	
	/**
	 * @return
	 */
	public Map<String, Event> getEventMap () {
		
		TreeMap<String, Event> output = new TreeMap<String, Event>(String.CASE_INSENSITIVE_ORDER);
		
		for (String s : eventPrototypeMap.keySet()) {
			
			output.put(s, eventPrototypeMap.get(s).toEvent());
			
		}
		
		return Collections.unmodifiableSortedMap(output);
		
	}
	
	/**
	 * @return
	 */
	public Map<String, TextList> getTextListMap () {
		
		TreeMap<String, TextList> output = new TreeMap<String, TextList>(String.CASE_INSENSITIVE_ORDER);
		
		for (String s : textListPrototypeMap.keySet()) {
			
			output.put(s, textListPrototypeMap.get(s).toTextList());
			
		}
		
		return Collections.unmodifiableSortedMap(output);
		
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
			e.printStackTrace();
			System.exit(1);
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (SAXException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
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
		public Stack<Attributes> attributeStack;
		
		/**
		 * 
		 */
		public String elementText;
		
		/**
		 * 
		 */
		public EventXMLHandler () {
			// TODO Auto-generated constructor stub
			
			elementStack = new Stack<String>();
			objectStack = new Stack<Object>();
			attributeStack = new Stack<Attributes>();
			
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement (String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			
			// TODO Auto-generated method stub
			
			System.out.println("startElement()");
			elementStack.push(qName);
			
			System.out.println(elementStack.toString());
			System.out.println(objectStack.toString());
			System.out.println(elementStack.size() > 2
					? "Parent: " + elementStack.get(elementStack.size() - 2)
							+ " Child: " + elementStack.peek() : "Element: "
							+ elementStack.peek());
			
			attributeStack.push(attributes);
			
			if (qName.equals("eventfile")) {
				
				// NO-OP
				return;
				
			}
			else if (qName.equals("eventgroup")) {
				
				EventGroupPrototype egp = new EventGroupPrototype();
				
				egp.setID(attributes.getValue("ID"));
				
				egp.setName(attributes.getIndex("name") != -1
						? attributes.getValue("name") : egp.ID);
				
				objectStack.push(egp);
				
			}
			else if (qName.equals("event")) {
				
				EventPrototype ep = new EventPrototype();
				
				ep.setID(attributes.getValue("ID"));
				ep.setName(attributes.getValue("name"));
				
				objectStack.push(ep);
				
			}
			else if (qName.equals("choice")) {
				if (elementStack.size() > 2
						&& elementStack.get(elementStack.size() - 2).equals("event")) {
					
					objectStack.push(new ChoicePrototype());
					
				}
			}
			else if (qName.equals("textlist")) {
				
				if (attributes.getIndex("ID") != -1) {
					TextListPrototype tlp = new TextListPrototype();
					tlp.setID(attributes.getValue("ID"));
					objectStack.push(tlp);
				}
			}
			else if (qName.equals("text")) {
				
				TextPrototype tp;
				
				if (attributes.getIndex("load") != -1) {
					tp = new TextPrototype();
					tp.isReference = true;
					
				}
				else {
					tp = new TextPrototype();
					tp.isReference = false;
					
				}
				objectStack.add(tp);
				
			}
			
			System.out.println(objectStack.toString());
			
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters (char[] ch, int start, int length)
				throws SAXException {
			
			if (!objectStack.isEmpty() && objectStack.peek() instanceof TextPrototype) {
				
				elementText = new String(ch, start, length);
				System.out.println(elementText);
				elementText = elementText.trim().replaceAll("[ \n\\n]+", " ").replaceAll("[\t\\t]*", "");
				objectStack.push(elementText);
				System.out.println(elementText.isEmpty() ? "Empty"
						: elementText);
				
			}
		}
		
		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement (String uri, String localName, String qName)
				throws SAXException {
			
			System.out.println("endElement(qName=" + qName + ")");
			System.out.println(elementText != null ? elementText.isEmpty()
					? "Empty" : elementText : "null");
			System.out.println(elementStack.toString());
			System.out.println(objectStack.toString());
			
			if (qName.equals("eventgroup")) {
				
				EventGroupPrototype egp = (EventGroupPrototype) objectStack.pop();
				
				eventGroupPrototypeMap.put(egp.ID, egp);
				
			}
			else if (qName.equals("event")) {
				
				EventPrototype ep = (EventPrototype) objectStack.pop();
				
				if (objectStack.size() > 1
						&& objectStack.peek() instanceof EventGroupPrototype) {
					
					((EventGroupPrototype) objectStack.peek()).add(ep);
					
				}
				if (ep != null && ep.ID != null) {
					eventPrototypeMap.put(ep.ID, ep);
				}
				
			}
			else if (qName.equals("textlist")) {
				
				Object o = objectStack.pop();
				
				if (o instanceof TextListPrototype) {
					TextListPrototype tlp = (TextListPrototype) o;
					if (tlp.getID() != null) {
						textListPrototypeMap.put(tlp.getID(), tlp);
					}
				}
				
			}
			else if (qName.equals("text")) {
				
				// XXX Finish this method
				if (!objectStack.isEmpty() && objectStack.peek() instanceof String) {
					elementText = (String) objectStack.pop();
					System.out.println(elementText);
				}
				
				TextGroupPrototype textPrototype = (TextPrototype) objectStack.pop();
				textPrototype.addText(elementText);
				System.out.println("ObjectStack" + objectStack);
				Object o = objectStack.peek();
				System.out.println(o);
				if (!(textPrototype instanceof TextListReferencePrototype)) {
					
					TextPrototype text = (TextPrototype) textPrototype;
					System.out.println("Parent");
					System.out.println(o.getClass().getName());
					
					if (o instanceof TextListPrototype) {
						System.out.println("DEBUG: o is a TextListPrototype");
						System.out.println(elementText.isEmpty() ? "Empty"
								: elementText);
						((TextGroupPrototype) o).addText(elementText);
						
						// objectStack.pop();
					}
					else if (o instanceof TextContainerPrototype) {
						
						System.out.println(elementText.isEmpty() ? "Empty"
								: elementText);
						System.out.println("DEBUG: elementText is: "
								+ elementText);
						((TextContainerPrototype) o).setText(text);
						
						System.out.println((o));
						
					}
				}
				else {
					
					if (o instanceof TextContainerPrototype) {
						
						((TextContainerPrototype) o).setText(textListPrototypeMap.get(((TextListReferencePrototype) textPrototype).reference));
						
					}
					
				}
				
			}
			else if (qName.equals("choice")
					&& objectStack.get(objectStack.size() - 2) instanceof EventPrototype) {
				
				ChoicePrototype cp = (ChoicePrototype) objectStack.pop();
				System.out.println("DEBUG: Choice popped");
				((EventPrototype) objectStack.peek()).add(cp);
				
			}
			else if (qName.equals("choice")) {
				System.out.println("DEBUG: Something went wrong");
				System.out.println(objectStack.size());
				
				System.out.println(objectStack.size() > 2
						&& objectStack.get(objectStack.size() - 2) instanceof EventPrototype);
			}
			
			elementStack.pop();
			attributeStack.pop();
			
		}
		
		@SuppressWarnings("javadoc")
		public class EventGroupPrototype {
			
			/**
			 * ID of the Event
			 */
			private String ID;
			
			/**
			 * Name of the Event
			 */
			private String name;
			
			ArrayList<EventPrototype> eventList;
			
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
				return new EventGroup(ID, getName(), output);
				
			}
			
			/**
			 * @return the ID
			 */
			public String getID () {
				return ID;
			}
			
			/**
			 * @param ID
			 *            the ID to set
			 */
			public void setID (String ID) {
				this.ID = ID;
			}
			
			/**
			 * @return the name
			 */
			public String getName () {
				return name;
			}
			
			/**
			 * @param name
			 *            the name to set
			 */
			public void setName (String name) {
				this.name = name;
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString () {
				return String.format("EventGroup{ID=\"%s\", name=\"%s\", eventList=%s}", ID, name, eventList);
			}
			
		}
		
		/**
		 * @author Andrew Event prototype object
		 */
		@SuppressWarnings("all")
		public class EventPrototype implements TextContainerPrototype {
			
			/**
			 * Event ID (Unique identifier, Required)
			 */
			public String ID;
			
			/**
			 * Event Name
			 */
			public String name;
			
			/**
			 * Event text
			 */
			public TextGroupPrototype text;
			
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
			public String playlistName;
			
			/**
			 * 
			 */
			public EventPrototype () {
				
				choices = new ChoiceListPrototype();
				
			}
			
			/**
			 * @return an event with the same values as the prototype
			 */
			public Event toEvent () {
				
				return new Event(ID, name, text != null ? text.convert() : null, choices != null
						? choices.toChoiceList() : null, effect, isHidden, playlistName);
				
			}
			
			/**
			 * @param prototype
			 */
			public void add (ChoicePrototype prototype) {
				
				choices.add(prototype);
				
			}
			
			/**
			 * @param prototype
			 */
			public void addChoicePrototype (ChoicePrototype prototype) {
				
				choices.add(prototype);
				
			}
			
			/**
			 * @param ID
			 *            the ID to set
			 */
			public void setID (String ID) {
				this.ID = ID;
			}
			
			/**
			 * @return the name
			 */
			public String getName () {
				return name;
			}
			
			/**
			 * @param name
			 *            the name to set
			 */
			public void setName (String name) {
				this.name = name;
			}
			
			@Override
			public void setText (TextGroupPrototype text) {
				
				this.text = text;
				
			}
			
			@Override
			public String toString () {
				
				return String.format("EventPrototype{ID: \"%s\", name: \"%s\", text: {%s}, ChoiceListPrototype: [%s]}", ID, name, text, choices);
				
			}
			
		}
		
		@SuppressWarnings("javadoc")
		public class ChoiceListPrototype {
			
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
			 * @return
			 */
			public ChoiceList toChoiceList () {
				
				ArrayList<Choice> choiceArrayList = new ArrayList<Choice>();
				for (ChoicePrototype cp : choices) {
					
					choiceArrayList.add(cp.toChoice());
					
				}
				return new ChoiceList(choiceArrayList);
				
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString () {
				
				return String.format("ChoiceListPrototype{%s}", choices);
			}
			
		}
		
		@SuppressWarnings("javadoc")
		public class ChoicePrototype implements TextContainerPrototype {
			
			/**
			 * The text of the choice
			 */
			public TextGroupPrototype text;
			
			/**
			 * A list of possible events
			 * 
			 */
			public EventGroupPrototype nextEvent;
			
			/**
			 * @param text
			 * @param arguments
			 */
			public ChoicePrototype (String text, EventPrototype... arguments) {
				
				this.text = new TextPrototype(text);
				nextEvent = new EventGroupPrototype(arguments);
			}
			
			/**
			 * @param text
			 * @param nextEvent
			 */
			public ChoicePrototype (String text, EventGroupPrototype nextEvent) {
				
				this.text = new TextPrototype(text);
				this.nextEvent = nextEvent;
				
			}
			
			/**
			 * 
			 */
			public ChoicePrototype () {
				// TODO Auto-generated constructor stub
			}
			
			/**
			 * @return
			 */
			public Choice toChoice () {
				
				return new Choice(text != null ? text.convert() : null, nextEvent != null
						? nextEvent.toEventGroup() : null);
				
			}
			
			/**
			 * @return the nextEvent
			 */
			public EventGroupPrototype getNextEvent () {
				return nextEvent;
			}
			
			/**
			 * @param nextEvent
			 *            the nextEvent to set
			 */
			public void setNextEvent (EventGroupPrototype nextEvent) {
				this.nextEvent = nextEvent;
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextContainerPrototype#setText(arpg.game.events.EventFactory.TextGroupPrototype)
			 */
			@Override
			public void setText (TextGroupPrototype text) {
				
				this.text = text;
				
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString () {
				return String.format("Choice{text=\"%s\", nextEvent=%s}", text, nextEvent);
			}
			
		}
		
		@SuppressWarnings("javadoc")
		public class TextListPrototype implements TextGroupPrototype {
			
			public String ID;
			
			public ArrayList<String> list = new ArrayList<String>();
			
			/**
			 * 
			 */
			public TextListPrototype () {
				// TODO Auto-generated constructor stub
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextContainerPrototype#setText(java.lang.String)
			 */
			@Override
			public void addText (String text) {
				
				list.add(text);
				
			}
			
			/**
			 * @return a TextList
			 */
			public TextList toTextList () {
				TextList textList = new TextList();
				for (String s : list) {
					textList.addText(s);
				}
				return textList;
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextContainerPrototype#convert()
			 */
			@Override
			public TextContainer convert () {
				return toTextList();
			}
			
			/**
			 * @return the iD
			 */
			public String getID () {
				return ID;
			}
			
			/**
			 * @param ID
			 *            the ID to set
			 */
			public void setID (String ID) {
				this.ID = ID;
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString () {
				return String.format("TextList{ID=\"%s\", Text=%s}", ID, list);
			}
			
		}
		
		@SuppressWarnings("all")
		public class TextPrototype implements TextGroupPrototype {
			
			public boolean isReference = false;
			
			public String text;
			
			/**
			 * @param text
			 * 
			 */
			public TextPrototype (String text) {
				this.text = text;
				
			}
			
			/**
			 * 
			 */
			public TextPrototype () {
				// TODO Auto-generated constructor stub
			}
			
			/**
			 * @return the text
			 */
			public String getText () {
				
				return text;
				
			}
			
			@Override
			public String toString () {
				
				return text;
				
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextContainerPrototype#addText(java.lang.String)
			 */
			@Override
			public void addText (String text) {
				
				this.text = text;
				
			}
			
			public Text toText () {
				
				return new Text(text);
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextContainerPrototype#convert()
			 */
			@Override
			public TextContainer convert () {
				return toText();
			}
			
		}
		
		@SuppressWarnings("javadoc")
		public class TextListReferencePrototype implements TextGroupPrototype {
			
			String reference;
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextGroupPrototype#addText(java.lang.String)
			 */
			@Override
			public void addText (String text) {
				// NO-OP
				
			}
			
			/* (non-Javadoc)
			 * @see arpg.game.events.EventFactory.TextGroupPrototype#convert()
			 */
			@Override
			public TextContainer convert () {
				return new TextListReference();
			}
			
			public void setReference (String reference) {
				this.reference = reference;
			}
			
		}
		
	}
	
	private interface TextContainerPrototype {
		
		public abstract void setText (TextGroupPrototype text);
		
	}
	
	/**
	 * Utility interface for text
	 * 
	 * @author Andrew
	 */
	private interface TextGroupPrototype {
		
		public abstract void addText (String text);
		
		public abstract TextContainer convert ();
		
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
		@Deprecated
		Location,
		@Deprecated
		Biome,
		@Deprecated
		Place,
		Choice,
		TextList,
		Text,
		
	}
	
}
