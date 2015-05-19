/**
 * 
 */
package arpg.game.effects.modifier;

import arpg.game.character.StatMap;

/**
 * @author Andrew
 * 
 */
public class FixedModifier extends SimpleModifier {
	
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
		
		stats.get(type).current += amount;
		
	}
	
}
