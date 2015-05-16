/**
 * 
 */
package arpg.game.modifier;

import java.util.*;

import arpg.game.character.*;

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
		
		super(name);
		this.modifiers = new ArrayList<Modifier>(Arrays.asList(modifiers));
		
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.modifier.Modifier#applyModifier(arpg.game.character.StatMap)
	 */
	@Override
	public void applyModifier (StatMap stats) {
		
		assert (stats != null);
		
		for (Modifier m : this.modifiers) {
			
			m.applyModifier(stats);
			
		}
		
	}
	
}
