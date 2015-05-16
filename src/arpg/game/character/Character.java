/**
 * 
 */
package arpg.game.character;

import java.util.*;

import arpg.game.effects.*;

/**
 * @author Andrew
 * 
 */
public class Character {
	
	/**
	 * A map containing all of the Character's Stats
	 */
	public StatMap stats;
	
	/**
	 * Name
	 */
	public final String name;
	
	boolean isNPC;
	
	boolean isHostile;
	
	private ArrayList<Effect> effects;
	
	/**
	 * @param stats
	 * @param name
	 * @param isHostile
	 * @param isNPC
	 * @param arguments
	 */
	public Character (StatMap stats, String name, boolean isNPC,
			boolean isHostile, Effect... arguments) {
		
		this(stats, name, isNPC, isHostile, new ArrayList<Effect>(Arrays.asList(arguments)));
		
	}
	
	/**
	 * @param stats
	 * @param name
	 * @param isHostile
	 * @param isNPC
	 * @param effects
	 */
	public Character (StatMap stats, String name, boolean isHostile,
			boolean isNPC, ArrayList<Effect> effects) {
		
		this.stats = stats;
		this.name = name;
		this.isHostile = isHostile;
		this.isNPC = isNPC;
		this.effects = effects;
	}
	
	/**
	 * Applies the current effects, and decrements the timer
	 */
	public void applyEffects () {
		
		for (Effect e : effects) {
			
			applyEffect(e);
			
		}
		
	}
	
	/**
	 * @param e
	 */
	public void addEffect (Effect e) {
		
		if (e instanceof PermanentEffect) {
			
			applyEffect(e);
			
		}
		effects.add(e);
		
	}
	
	/**
	 * @param e
	 */
	public void applyEffect (Effect e) {
		
		// TODO Finish
		
	}
	
	/**
	 * Removes an effect
	 * 
	 * @param e
	 */
	public void unapplyEffect (Effect e) {
		
		// TODO Finish method
		
	}
	
	/**
	 * @return the effects
	 */
	public ArrayList<Effect> getEffects () {
		return effects;
	}
	
	/**
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects (ArrayList<Effect> effects) {
		this.effects = effects;
	}
	
}
