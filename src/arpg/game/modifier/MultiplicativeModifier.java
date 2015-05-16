/**
 * 
 */
package arpg.game.modifier;

import arpg.game.character.*;

/**
 * @author Andrew
 * 
 */
public class MultiplicativeModifier extends Modifier {
	
	/**
	 * The effect of the modifier on the stat. Should be
	 */
	public float amount;
	
	/**
	 * @param s
	 *            the name of the modified stat
	 * @param amount
	 * 
	 */
	public MultiplicativeModifier (String s, float amount) {
		// TODO Auto-generated constructor stub
		
		super(s);
		this.amount = amount;
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.character.Modifier#applyModifier(arpg.game.character.Stat)
	 */
	@Override
	public void applyModifier (StatMap stats) {
		
		// TODO Auto-generated method stub
		
		assert (stats != null);
		
		stats.get(this.type).current *= this.amount;
		
	}
	
}
