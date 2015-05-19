/**
 * 
 */
package arpg.game.effects.modifier;

import arpg.game.character.StatMap;

/**
 * @author Andrew
 * 
 */
public class BlankModifier extends Modifier {
	
	/**
	 * 
	 */
	private BlankModifier () {
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.modifier.Modifier#applyModifier(arpg.game.character.StatMap)
	 */
	@Override
	public void applyModifier (StatMap stats) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @return an instance of BlankModifier
	 */
	public static BlankModifier getInstance () {
		
		return SingletonHolder.INSTANCE;
		
	}
	
	private static class SingletonHolder {
		
		private static final BlankModifier INSTANCE = new BlankModifier();
		
	}
	
}
