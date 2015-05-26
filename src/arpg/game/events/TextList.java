/**
 * 
 */
package arpg.game.events;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andrew
 * 
 */
public class TextList implements TextContainer {
	
	ArrayList<String> list = new ArrayList<String>();
	
	Random rng = new Random(0);
	
	/**
	 * 
	 */
	public TextList () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param s
	 */
	public void addText (String s) {
		
		list.add(s);
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.events.TextContainer#getText()
	 */
	@Override
	public String getText () {
		return list.get(rng.nextInt(list.size()));
	}
	
	@Override
	public String toString () {
		
		return list.toString();
		
	}
	
}
