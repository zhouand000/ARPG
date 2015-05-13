/**
 * 
 */
package arpg.game.effects;

/**
 * @author Andrew
 * 
 */
public class StatusEffect {
	
	/**
	 * The effect's remaining duration. Should be positive if the effect has a
	 * set duration. When this reaches 0, the effect should be unapplied. If the
	 * effect is permanent, this should be -1. If the effect is a semi-permanent
	 * effect, this should be -2
	 */
	public int remainingDuration;
	
	/**
	 * 
	 */
	public StatusEffect () {
		// TODO Auto-generated constructor stub
	}
	
}
