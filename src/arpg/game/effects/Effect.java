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
	 * The effect's remaining duration. Should be positive if the effect has a
	 * set duration. When this reaches 0, the effect should be unapplied. If the
	 * effect is permanent, this should be -1. If the effect is a semi-permanent
	 * effect, this should be -2
	 */
	public int remainingDuration;
	
	public byte level;
	
	/**
	 * @param name
	 * @param description
	 * @param remainingDuration
	 * @param level
	 */
	public Effect (String name, String description, int remainingDuration, byte level) {
		
		this.name = name;
		this.description = description;
		this.remainingDuration = remainingDuration;
		this.level = level;
		
	}
	
}
