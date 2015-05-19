/**
 * 
 */
package arpg.game.events;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Andrew
 * 
 */
public class EventParser {
	
	File file;
	
	Scanner sc;
	
	Event e;
	
	State s;
	
	int braceCount;
	
	String currentLine;
	
	/**
	 * 
	 */
	public static final String pathToEventsFolder = "arpg/assets/events/";
	
	/**
	 * 
	 */
	public EventParser () {
		// TODO Auto-generated constructor stub
		
		s = State.START;
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param name
	 *            the name of the file
	 * @return
	 */
	public Event parseFile (String name) {
		
		// TODO Finish
		
		file = new File(pathToEventsFolder + name);
		
		try {
			sc = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.print(file.getAbsolutePath());
			System.err.println(" does not exist.");
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}
	
	public void parseNextLine() {
		
		currentLine = sc.nextLine();
		
	}
	
	public void parseRoot () {
		
		
		
	}
	
	
	/**
	 * @author Andrew
	 * 
	 */
	@SuppressWarnings("javadoc")
	public enum State {
		
		START,
		
		ROOT,
		TEXT,
		
		EVENT,
		END_EVENT,
		EVENTLIST,
		END_EVENTLIST,
		
		CHOICE,
		END_CHOICE,
		CHOICELIST,
		END_CHOICELIST,
		
		SOUND,
		END_SOUND,
		SOUNDLIST,
		END_SOUNDLIST,
		
		EFFECT,
		END_EFFECT,
		EFFECTLIST,
		END_EFFECTLIST,
		
		END;
	}
	
}
