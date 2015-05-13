/**
 * 
 */
package arpg.game.effects;

/**
 * @author Andrew
 * 
 */
public class PermanentEffect extends Effect {
	
	public int experience;
	
	public byte level;
	
	public byte strength;
	
	public byte defense;
	
	public byte intelligence;
	
	public byte dexterity;
	
	public byte maxHealth;
	
	public byte speed;
	
	public PermanentEffect (String name, String description, int experience,
			byte level, byte strength,
			byte defense, byte intelligence, byte dexterity, byte maxHealth,
			byte speed) {
		
		super(name, description);
		this.experience = experience;
		this.level = level;
		this.strength = strength;
		this.defense = defense;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.maxHealth = maxHealth;
		this.speed = speed;
	}
}
