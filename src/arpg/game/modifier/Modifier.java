/**
 * 
 */
package arpg.game.modifier;

import arpg.game.character.*;

/**
 * @author Andrew
 * 
 */
public abstract class Modifier {
	
	/**
	 * Name of the stat modified
	 */
	public final StatType type;
	
	/**
	 * Protected modifier. Initialises statName to s
	 * 
	 * @param type
	 * 
	 * 
	 */
	protected Modifier (StatType type) {
		
		if (!(type != null)) {
			throw new IllegalArgumentException("Exception occured while creating a Modifier object", new NullPointerException("StatType cannot be null"));
		}
		this.type = type;
		
	}
	
	/**
	 * @param typeString
	 */
	protected Modifier (String typeString) {
		
		typeString = typeString.trim();
		if (!(typeString != null)) {
			throw new IllegalArgumentException(new NullPointerException("The argument typeString cannot be null"));
		}
		
		if (typeString.isEmpty()) {
			throw new IllegalArgumentException("The argument typeString cannot be empty/contain only whitespace");
		}
		
		this.type = StatType.lookupStatType(typeString);
		
	}
	
	/**
	 * @param stats a map of stats
	 * 
	 */
	public abstract void applyModifier (StatMap stats);
	
}
