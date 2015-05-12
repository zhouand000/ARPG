/**
 * 
 */
package arpg.game.effects;

/**
 * @author Andrew
 * 
 */
public class InstantHealth extends OneTimeEffect {
	
	public final String name = "Health";
	
	public final String description = "Restores health";
	
	/**
	 * @param level
	 */
	public InstantHealth (byte level) {
		
		this.level = level;
		
	}
	
}
