/**
 * 
 */
package arpg.game.effects.modifier;

import arpg.game.character.StatMap;

/**
 * @author Andrew
 * 
 * 
 * Modifies one stat
 */
public abstract class Modifier {
	
	/**
	 * @param stats
	 *            a map of stats
	 * 
	 */
	public abstract void applyModifier (StatMap stats);
	
}
