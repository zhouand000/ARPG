/**
 *
 */
package arpg.game.effects;

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
	 * @param name
	 * @param description
	 *
	 */
	public Effect (String name, String description) {
		
		this.name = name;
		this.description = description;
		
	}
	
}
