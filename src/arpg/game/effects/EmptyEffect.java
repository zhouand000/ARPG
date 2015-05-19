/**
 * 
 */
package arpg.game.effects;

import arpg.game.effects.modifier.BlankModifier;

/**
 * @author Andrew
 * 
 */
public class EmptyEffect extends Effect {
	
	/**
	 * 
	 */
	private EmptyEffect () {
		super("", "", BlankModifier.getInstance());
	}
	
	/**
	 * @return
	 */
	public static EmptyEffect getInstance() {
		
		return SingletonHolder.INSTANCE;
		
	}
	
	private static class SingletonHolder {
		
		private static EmptyEffect INSTANCE = new EmptyEffect();
		
	}
	
}
