/**
 * 
 */
package arpg.game.character;

import java.util.*;

/**
 * @author Andrew
 * 
 */
public abstract class Modifier {
	
	/**
	 * Name of the stat modified
	 */
	public final String statName;
	
	
	/**
	 * Protected modifier. Initialises statName to s
	 * @param s
	 */
	protected Modifier (String s) {
		
		this.statName = s;
		
	}
	
	/**
	 * @param s
	 */
	public abstract void applyModifier (Stat s);
	
}
