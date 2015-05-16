/**
 *
 */
package arpg.game.character;

// TODO Finish StatType Enum
/**
 * 
 * @author Andrew
 * 
 */
public enum StatType {
	
	/**
	 * Level of the character
	 */
	// TODO Fill out like this
	LEVEL(),
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
	
	/**
	 * The name of the stat
	 */
	public final String name;
	
	/**
	 * The stat's abbreviation
	 */
	public final String abbreviation;
	
	private StatType () {
		
		this.name = "";
		this.abbreviation = "";
		
	}
	
	/**
	 * @param name
	 * @param abbreviation
	 */
	private StatType (String name, String abbreviation) {
		
		this.name = name;
		this.abbreviation = abbreviation;
		
	}
	
	/**
	 * @param s
	 * @return the StatType that corresponds with s, or null, if there are no
	 *         matches
	 */
	public static StatType lookupStatType (String s) {
		
		s = s.trim().toLowerCase();
		
		switch (s) {
			case "LEVEL":
				return StatType.LEVEL;
			case "EXPERIENCE":
				return StatType.EXPERIENCE;
			case "HEALTH":
				return StatType.HEALTH;
			case "STRENGTH":
				return StatType.STRENGTH;
			case "DEFENSE":
				return StatType.DEFENSE;
			case "DEXTERITY":
				return StatType.DEXTERITY;
			case "INTELLIGENCE":
				return StatType.INTELLIGENCE;
			case "SPEED":
				return StatType.SPEED;
			case "PERCEPTION":
				return StatType.PERCEPTION;
			case "WILLPOWER":
				return StatType.WILLPOWER;
			case "LUCK":
				return StatType.LUCK;
			case "KARMA":
				return StatType.KARMA;
			default:
				return null;
		}
		
	}
	
}
