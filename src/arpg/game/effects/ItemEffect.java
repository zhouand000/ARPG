/**
 * 
 */
package arpg.game.effects;

import arpg.game.character.*;

/**
 * @author Andrew
 * 
 */
public class ItemEffect extends Effect {
	
	// TODO Finish the class and update to reflect the new Stat API
	
	/**
	 * The instance of StatMap
	 */
	public StatMap stats;
	
	/**
	 * If the effect should be permanently applied to the character
	 */
	public boolean isPermanent;
	
	/**
	 * If the effect should only get applied, and removed when the duration ends
	 */
	public boolean isOneTimeEffect;
	
	/**
	 * If the effect is temporary
	 */
	public boolean isTemporaryEffect;
	
	/**
	 * Determines if the effect will affect the user
	 */
	public boolean affectUser;
	
	
	
}
