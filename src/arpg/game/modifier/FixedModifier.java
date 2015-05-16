/**
 * 
 */
package arpg.game.modifier;

import arpg.game.character.*;

/**
 * @author Andrew
 * 
 */
public class FixedModifier extends Modifier {
	
	/**
	 * 
	 */
	public int amount;
	
	/**
	 * @param s
	 *            Name of the modified stat
	 * @param amount
	 * 
	 */
	public FixedModifier (String s, int amount) {
		
		// TODO Auto-generated constructor stub
		
		super(s);
		this.amount = amount;
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.character.Modifier#applyModifier(arpg.game.character.Stat)
	 */
	@Override
	public void applyModifier (StatMap stats) {
		
		assert(stats != null);
		
		stats.get(this.type).current += this.amount;
		
	}
	
}
