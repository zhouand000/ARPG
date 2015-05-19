/**
 * 
 */
package arpg.game.effects.modifier;

import arpg.game.character.StatMap;
import arpg.game.character.StatType;

/**
 * @author Andrew
 * 
 */
public abstract class SimpleModifier extends Modifier {
	
	/**
	 * Name of the stat modified
	 */
	public final StatType type;
	
	/**
	 * Protected modifier.
	 * 
	 * @param type
	 * 
	 * 
	 */
	protected SimpleModifier (StatType type) {
		
		if (!(type != null)) {
			throw new IllegalArgumentException("Exception occured while creating a Modifier object", new NullPointerException("StatType cannot be null"));
		}
		this.type = type;
		
	}
	
	/**
	 * @param typeString
	 */
	protected SimpleModifier (String typeString) {
		
		typeString = typeString.trim();
		if (!(typeString != null)) {
			throw new IllegalArgumentException(new NullPointerException("The argument typeString cannot be null"));
		}
		
		if (typeString.isEmpty()) {
			throw new IllegalArgumentException("The argument typeString cannot be empty/contain only whitespace");
		}
		
		type = StatType.lookupStatType(typeString);
		
	}
	
	/**
	 * @param stats
	 *            a map of stats
	 * 
	 */
	@Override
	public abstract void applyModifier (StatMap stats);
	
}
