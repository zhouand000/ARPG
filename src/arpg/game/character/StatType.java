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
	 * The character's health
	 */
	HEALTH,
	/**
	 * The character's strength
	 */
	STRENGTH,
	/**
	 * The character's defense
	 */
	DEFENSE,
	/**
	 * The character's dexterity
	 */
	DEXTERITY,
	/**
	 * The character's intelligence
	 */
	INTELLIGENCE,
	/**
	 * The character's speed
	 */
	SPEED,
	/**
	 * The character's perception
	 */
	PERCEPTION,
	/**
	 * The character's willpower
	 */
	WILLPOWER,
	/**
	 * The character's luck
	 */
	LUCK,
	/**
	 * The character's karma
	 */
	KARMA;
	
	private StatType () {
	}
	
	private StatType (String name, String abbreviation) {
		
	}
	
	/**
	 * @param s
	 * @return the StatType that corresponds with s, or null, if there are no
	 *         matches
	 */
	public static StatType lookupStatType (String s) {
		
		s = s.trim().toLowerCase();
		
		switch (s) {
			
		}
		
		// TODO Finish method
		return null;
		
	}
	
}
