/**
 * 
 */
package arpg.game.effects;

import arpg.game.modifier.Modifier;

/**
 * @author Andrew
 * 
 */
public class PermanentEffect extends Effect {
	
	/**
	 * @param name
	 * @param description
	 * @param modifier
	 */
	public PermanentEffect (String name, String description, Modifier modifier) {
		
		super(name, description, modifier);
		
	}
}
