/**
 * 
 */
package arpg.game.effects;

/**
 * 
 * 
 * 
 * @author Andrew
 * 
 */
@Deprecated
public class StatusEffect extends Effect {
	
	public byte health;
	
	public byte absorption;
	
	public byte maxHealth;
	
	public byte strength;
	
	public byte defense;
	
	public byte intelligence;
	
	/**
	 * @param name
	 * @param description
	 */
	public StatusEffect (String name, String description) {
		
		// TODO Auto-generated constructor stub
		super(name, description);
		
	}
	
	/**
	 * @param name
	 *            Effect name. If null,
	 * @param description
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
	 * @param affectUser
	 * 
	 */
	public ItemEffect (String name, String description, int experience,
			byte level,
			byte health,
			byte maxHealth, byte strength,
			byte defense, byte remainingDuration, boolean isPermanent,
			boolean isOneTimeEffect, boolean isTemporaryEffect,
			boolean isSemiPermanent, boolean affectUser) {
		
		this.name = name != null ? name : "";
		this.description = description;
		this.health = health;
		this.maxHealth = maxHealth;
		this.strength = strength;
		this.defense = defense;
		this.remainingDuration = remainingDuration;
		this.isPermanent = isPermanent;
		this.isOneTimeEffect = isOneTimeEffect;
		this.isTemporaryEffect = isTemporaryEffect;
		this.isSemiPermanent = isSemiPermanent;
		this.affectUser = affectUser;
		
	}
	
}
