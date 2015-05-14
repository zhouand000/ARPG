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
	
	private byte level;
	
	private int experience;
	
	private byte health;
	
	private byte strength;
	
	private byte defense;
	
	private byte intelligence;
	
	private byte dexterity;
	
	private byte maxHealth;
	
	private byte speed;
	
	boolean isHostile;
	
	boolean isNPC;
	
	private ArrayList<Effect> effects;
	
	/**
	 * @param name
	 * @param level
	 * @param strength
	 * @param defense
	 * @param intelligence
	 * @param dexterity
	 * @param maxHealth
	 * 
	 */
	public Character (String name, byte level, byte strength, byte defense,
			byte intelligence, byte dexterity, byte maxHealth, byte speed) {
		
		this(name, level, strength, defense, intelligence, dexterity, maxHealth, speed, new ArrayList<Effect>());
		
	}
	
	/**
	 * @param name
	 * @param level
	 * @param strength
	 * @param defense
	 * @param intelligence
	 * @param dexterity
	 * @param maxHealth
	 * @param effects
	 * 
	 */
	public Character (String name, byte level, byte strength, byte defense,
			byte intelligence, byte dexterity, byte maxHealth, byte speed,
			ArrayList<Effect> effects) {
		
		// TODO Auto-generated constructor stub
		this.name = name;
		this.level = level;
		this.strength = strength;
		this.defense = defense;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.speed = speed;
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
		
		increaseLevel(e.level);
		
		this.experience += e.experience;
		updateLevel();
		
		health += e.health;
		maxHealth += e.maxHealth;
		
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
	 * Updates level to reflect experience gain
	 */
	private void updateLevel () {
		
		while (experience > (16 * 2 ^ level)) {
			
			level++;
			
		}
		
	}
	
	/**
	 * Should only be called when level is increased by an effect
	 * 
	 * @param amount
	 */
	private void increaseLevel (int amount) {
		
		level += amount;
		experience = 16 * 2 ^ level;
		
	}
	
	/**
	 * @return the experience
	 */
	public int getExperience () {
		return experience;
	}
	
	/**
	 * @return the level
	 */
	public byte getLevel () {
		return level;
	}
	
	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel (byte level) {
		this.level = level;
	}
	
	/**
	 * @param experience
	 *            the experience to set
	 */
	public void setExperience (int experience) {
		this.experience = experience;
	}
	
	/**
	 * @return the health
	 */
	public int getHealth () {
		return health;
	}
	
	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth (byte health) {
		this.health = health;
	}
	
	/**
	 * @return the strength
	 */
	public byte getStrength () {
		return strength;
	}
	
	/**
	 * @param strength
	 *            the strength to set
	 */
	public void setStrength (byte strength) {
		this.strength = strength;
	}
	
	/**
	 * @return the defense
	 */
	public byte getDefense () {
		return defense;
	}
	
	/**
	 * @param defense
	 *            the defense to set
	 */
	public void setDefense (byte defense) {
		this.defense = defense;
	}
	
	/**
	 * @return the intelligence
	 */
	public byte getIntelligence () {
		return intelligence;
	}
	
	/**
	 * @param intelligence
	 *            the intelligence to set
	 */
	public void setIntelligence (byte intelligence) {
		this.intelligence = intelligence;
	}
	
	/**
	 * @return the dexterity
	 */
	public byte getDexterity () {
		return dexterity;
	}
	
	/**
	 * @param dexterity
	 *            the dexterity to set
	 */
	public void setDexterity (byte dexterity) {
		this.dexterity = dexterity;
	}
	
	/**
	 * @return the maxHealth
	 */
	public byte getMaxHealth () {
		return maxHealth;
	}
	
	/**
	 * @param maxHealth
	 *            the maxHealth to set
	 */
	public void setMaxHealth (byte maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	 * @return the speed
	 */
	public byte getSpeed () {
		return speed;
	}
	
	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed (byte speed) {
		this.speed = speed;
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
