/**
 *
 */
package arpg.game.effects;

import arpg.game.modifier.Modifier;

/**
 * @author Andrew
 *
 */
public abstract class Effect {
	
	/**
	 * The name of the effect.
	 */
	public final String name;
	
	/**
	 * A description of the effect
	 */
	public final String description;
	
	/**
	 * The modifier associated with the effect
	 */
	public final Modifier modifier;
	
	/**
	 * @param name
	 * @param description
	 * @param modifier
	 *
	 */
	public Effect (String name, String description, Modifier modifier) {
		
		this.name = name;
		this.description = description;
		this.modifier = modifier;
		
	}
	
}
