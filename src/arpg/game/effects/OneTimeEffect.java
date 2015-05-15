/**
 * 
 */
package arpg.game.effects;

/**
 * @author Andrew
 * 
 */
public abstract class OneTimeEffect extends Effect {
	
	/**
	 * The level of the effect
	 */
	public byte level;
	
	/**
	 * @param level
	 */
	public OneTimeEffect (byte level) {
		
		super("", "");
		this.level = level;
		
	}
	
	/**
	 * @param name
	 * @param description
	 * @param level
	 */
	public OneTimeEffect (String name, String description, byte level) {
		
		// TODO Auto-generated constructor stub
		
		super(name, description);
		this.level = level;
		
	}
	
}
