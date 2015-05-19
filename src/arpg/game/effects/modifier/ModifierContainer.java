/**
 * 
 */
package arpg.game.effects.modifier;

import java.util.ArrayList;
import java.util.Arrays;

import arpg.game.character.StatMap;

/**
 * @author Andrew
 * 
 */
public class ModifierContainer extends Modifier {
	
	/**
	 * 
	 */
	public ArrayList<Modifier> modifiers;
	
	/**
	 * @param name
	 * @param modifiers
	 * 
	 */
	public ModifierContainer (String name, Modifier... modifiers) {
		// TODO Auto-generated constructor stub
		
		this.modifiers = new ArrayList<Modifier>(Arrays.asList(modifiers));
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.modifier.Modifier#applyModifier(arpg.game.character.StatMap)
	 */
	@Override
	public void applyModifier (StatMap stats) {
		
		assert (stats != null);
		
		for (Modifier m : modifiers) {
			
			m.applyModifier(stats);
			
		}
		
	}
	
}
