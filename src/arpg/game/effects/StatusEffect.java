/**
 * 
 */
package arpg.game.effects;

import arpg.game.annotations.Required;
import arpg.game.effects.modifier.BlankModifier;
import arpg.game.effects.modifier.Modifier;

/**
 * @author Andrew
 * 
 */
public class StatusEffect extends Effect {
	
	/**
	 * The effect's remaining duration. Should be positive if the effect has a
	 * set duration. When this reaches 0, the effect should be unapplied. If the
	 * effect is permanent, this should be -1. If the effect is a semi-permanent
	 * effect, this should be -2.
	 */
	@Required
	public int remainingDuration;
	
	/**
	 * 
	 */
	public int maxDuration;
	
	/**
	 * @param name
	 * @param maxDuration
	 */
	public StatusEffect (String name, int maxDuration) {
		
		this(name, maxDuration, BlankModifier.getInstance());
		
	}
	
	/**
	 * @param name
	 * @param maxDuration
	 * @param modifier
	 * 
	 */
	public StatusEffect (String name, int maxDuration, Modifier modifier) {
		
		super(name, "", modifier);
		this.maxDuration = maxDuration;
		remainingDuration = maxDuration;
		
		
		
		
		
	}
	
}
