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
	LEVEL ("Level", "Lvl"),
	/**
	 * Amount of experience
	 */
	EXPERIENCE ("Experience", "Exp"),
	/**
	 * The character's health
	 */
	HEALTH ("Health", "Hp"),
	/**
	 * The character's strength
	 */
	STRENGTH ("Strength", "Str"),
	/**
	 * The character's defense
	 */
	DEFENSE ("Defense", "Def"),
	/**
	 * The character's dexterity
	 */
	DEXTERITY ("Dexterity", "Dex"),
	/**
	 * The character's intelligence
	 */
	INTELLIGENCE ("Intelligence", "Int"),
	/**
	 * The character's speed
	 */
	SPEED ("Speed", "Spd"),
	/**
	 * The character's perception
	 */
	PERCEPTION ("Perception", "Pcp"),
	/**
	 * The character's willpower
	 */
	WILLPOWER ("Willpower", "Wil"),
	/**
	 * The character's luck
	 */
	LUCK ("Luck", "Lck"),
	/**
	 * The character's karma
	 */
	KARMA ("Karma", "Krm");
	
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
		}
		
		// TODO Finish method
		return null;
		
	}
	
}
