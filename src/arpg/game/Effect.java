/**
 * 
 */
package arpg.game;

/**
 * @author Andrew
 * 
 */
public class Effect {
	
	// TODO Finish the class
	
	public final String name;
	
	public final int experience;
	
	public final byte level;
	
	public byte health;
	
	public byte maxHealth;
	
	public byte strength;
	
	public byte defense;
	
	public byte intelligence;
	
	/**
	 * The remaining duration.
	 */
	public byte remainingDuration;
	
	public boolean isPermanent;
	
	public boolean isOneTimeEffect;
	
	public boolean isItemEffect = false;
	
	/**
	 * @param name Effect name
	 * @param experience
	 * @param level 
	 * @param health
	 * @param maxHealth
	 * @param strength
	 * @param defense
	 * @param remainingDuration
	 * @param isPermanent
	 * @param isOneTimeEffect
	 * 
	 */
	public Effect (String name, int experience, byte level, byte health, byte maxHealth, byte strength,
			byte defense, byte remainingDuration, boolean isPermanent,
			boolean isOneTimeEffect) {
		
		this.name = name;
		this.experience = experience;
		this.level = level;
		this.health = health;
		this.maxHealth = maxHealth;
		this.strength = strength;
		this.defense = defense;
		this.remainingDuration = remainingDuration;
		this.isPermanent = isPermanent;
		this.isOneTimeEffect = isOneTimeEffect;
		
	}
	
}
