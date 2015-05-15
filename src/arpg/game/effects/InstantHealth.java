/**
 *
 */
package arpg.game.effects;

/**
 * @author Andrew
 *
 */
public class InstantHealth extends OneTimeEffect {
	
	/**
	 * The amount of health restored by the effect
	 * 
	 * The amount of health restored is given by the formula
	 * 
	 * Health Restored = 16 * 2 ^ (level - 1)
	 */
	public byte healthRestored;
	
	/**
	 * @param level
	 */
	public InstantHealth (byte level) {
		
		super("Instant Health", "Instantly restores health", level);
		
	}
	
}
