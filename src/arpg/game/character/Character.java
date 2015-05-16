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
	
	private byte dexterity;
	
	private byte intelligence;
	
	private byte maxHealth;
	
	private byte speed;
	
	private byte perception;
	
	private byte willpower;
	
	private byte luck;
	
	private byte karma;
	
	boolean isHostile;
	
	boolean isNPC;
	
	private ArrayList<Effect> effects;
	
	/**
	 * @param stats
	 * @param name
	 * @param level
	 * @param experience
	 * @param strength
	 * @param defense
	 * @param dexterity
	 * @param intelligence
	 * @param maxHealth
	 * @param speed
	 * @param perception
	 * @param willpower
	 * @param luck
	 * @param karma
	 * @param isHostile
	 * @param isNPC
	 * @param arguments
	 */
	public Character (StatMap stats, String name, byte level, int experience,
			byte strength, byte defense, byte dexterity,
			byte intelligence, byte maxHealth, byte speed, byte perception,
			byte willpower, byte luck, byte karma, boolean isHostile,
			boolean isNPC, Effect... arguments) {
		
		this (stats, name, level, experience, maxHealth, strength, defense, dexterity, intelligence, maxHealth, speed, perception, willpower, luck, karma, isNPC, isNPC, new ArrayList<Effect>(Arrays.asList(arguments)));
		
	}
	
	/**
	 * @param stats
	 * @param name
	 * @param level
	 * @param experience
	 * @param health
	 * @param strength
	 * @param defense
	 * @param dexterity
	 * @param intelligence
	 * @param maxHealth
	 * @param speed
	 * @param perception
	 * @param willpower
	 * @param luck
	 * @param karma
	 * @param isHostile
	 * @param isNPC
	 * @param effects
	 */
	public Character (StatMap stats, String name, byte level, int experience,
			byte health, byte strength, byte defense, byte dexterity,
			byte intelligence, byte maxHealth, byte speed, byte perception,
			byte willpower, byte luck, byte karma, boolean isHostile,
			boolean isNPC, ArrayList<Effect> effects) {
		
		this.stats = stats;
		this.name = name;
		this.level = level;
		this.experience = experience;
		this.health = health;
		this.strength = strength;
		this.defense = defense;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.maxHealth = maxHealth;
		this.speed = speed;
		this.perception = perception;
		this.willpower = willpower;
		this.luck = luck;
		this.karma = karma;
		this.isHostile = isHostile;
		this.isNPC = isNPC;
		this.effects = effects;
	}
	
	/**
	 * Applies the current effects, and decrements the timer
	 */
	public void applyEffects () {
		
		for (Effect e : this.effects) {
			
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
		this.effects.add(e);
		
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
	 * Updates level to reflect experience gain
	 */
	private void updateLevel () {
		
		while (this.experience > (16 * 2 ^ this.level)) {
			
			this.level++;
			
		}
		
	}
	
	/**
	 * Should only be called when level is increased by an effect
	 * 
	 * @param amount
	 */
	private void increaseLevel (int amount) {
		
		this.level += amount;
		this.experience = 16 * 2 ^ this.level;
		
	}
	
	/**
	 * @return the experience
	 */
	public int getExperience () {
		return this.experience;
	}
	
	/**
	 * @return the level
	 */
	public byte getLevel () {
		return this.level;
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
		return this.health;
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
		return this.strength;
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
		return this.defense;
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
		return this.intelligence;
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
		return this.dexterity;
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
		return this.maxHealth;
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
		return this.speed;
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
		return this.effects;
	}
	
	/**
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects (ArrayList<Effect> effects) {
		this.effects = effects;
	}
	
}
