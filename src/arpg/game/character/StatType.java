/**
 * 
 */
package arpg.game.character;

/**
 * @author Andrew
 * 
 */
public enum StatType {
	
	/**
	 * Level of the character 
	 */
	LEVEL,
	/**
	 * Amount of experience
	 */
	EXPERIENCE,
	/**
	 * The character's current amount of HP 
	 */
	HEALTH,
	/**
	 * The character's maximum amount of HP
	 */
	MAXIMUM_HEALTH,
	/**
	 * The character's strength
	 */
	STRENGTH,
	DEFENSE,
	DEXTERITY,
	INTELLIGENCE,
	SPEED,
	PERCEPTION,
	WILLPOWER,
	LUCK,
	KARMA
	;
	
	private StatType () {}
	
	private StatType (String name, String abbreviation) {
		
		
		
	}
	
}
