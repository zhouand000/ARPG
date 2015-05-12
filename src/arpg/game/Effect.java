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
	 * The remaining duration.
	 */
	public byte remainingDuration;
	
	public boolean isPermanent;
	
	public boolean isOneTimeEffect;
	
	public boolean isTemporaryEffect;
	
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
	 *            be -1. If the effect is a
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
