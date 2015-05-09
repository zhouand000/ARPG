/**
 * 
 */
package arpg.game;

/**
 * @author Andrew
 * 
 */
public class Character {
	
	/**
	 * Name
	 */
	public final String name;
	
	private int health;
	
	private byte strength;
	
	private byte defense;
	
	private byte intelligence;
	
	private byte dexterity;
	
	private byte maxHealth;
	
	boolean isHostile;
	
	boolean isNPC;
	
	/**
	 * @param name
	 * @param strength
	 * @param defense 
	 * @param intelligence 
	 * @param dexterity 
	 * @param maxHealth
	 * 
	 */
	public Character (String name, byte strength, byte defense,
			byte intelligence, byte dexterity, byte maxHealth) {
		
		// TODO Auto-generated constructor stub
		this.name = name;
		this.strength = strength;
		this.defense = defense;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		
		
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
	public void setHealth (int health) {
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
	
}
