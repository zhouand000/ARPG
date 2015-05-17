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
	
	/**
	 * The name of the effect.
	 */
	public final String name;
	
	public final int experience;
	
	public final byte level;
	
	public byte health;
	
	public byte maxHealth;
	
	public byte strength;
	
	public byte defense;
	
	public byte intelligence;
	
	/**
	 * The effect's remaining duration. Should be positive if the effect has a
	 * set duration. When this reaches 0, the effect should be unapplied. If the
	 * effect is permanent, this should be -1. If the effect is a semi-permanent
	 * effect, this should be -2
	 */
	public byte remainingDuration;
	
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
	 * If the effect is caused by an item or an ability
	 */
	public boolean isSemiPermanent;
	
	/**
	 * @param name
	 *            Effect name. If null,
	 * @param experience
	 *            Experience change.
	 * @param level
	 *            Change in Level. Should be positive.
	 * @param health
	 *            Change in Health. Can be positive and negative. Can exceed
	 *            Maximum Health (Intended). Does not need to be unapplied.
	 * @param maxHealth
	 *            Change in Maximum Health. Should be positive
	 * @param strength
	 *            Change in Strength. Can be positive and negative
	 * @param defense
	 *            Change in Defense
	 * @param remainingDuration
	 *            The effect's remaining duration. Should be positive if the
	 *            effect has a set duration. When this reaches 0, the effect
	 *            should be unapplied. If the effect is permanent, this should
	 *            be -1. If the effect is a semi-permanent effect, this should
	 *            be -2
	 * @param isPermanent
	 * @param isOneTimeEffect
	 *            Indicates if the effect is a one time effect; whether it
	 *            should be applied once, or whether it should be applied every
	 *            turn
	 * @param isTemporaryEffect
	 * @param isSemiPermanent
	 * 
	 */
	public Effect (String name, int experience, byte level, byte health,
			byte maxHealth, byte strength,
			byte defense, byte remainingDuration, boolean isPermanent,
			boolean isOneTimeEffect, boolean isTemporaryEffect,
			boolean isSemiPermanent) {
		
		this.name = name != null ? name : "";
		this.experience = experience;
		this.level = level;
		this.health = health;
		this.maxHealth = maxHealth;
		this.strength = strength;
		this.defense = defense;
		this.remainingDuration = remainingDuration;
		this.isPermanent = isPermanent;
		this.isOneTimeEffect = isOneTimeEffect;
		this.isTemporaryEffect = isTemporaryEffect;
		this.isSemiPermanent = isSemiPermanent;
		
	}
	
}
