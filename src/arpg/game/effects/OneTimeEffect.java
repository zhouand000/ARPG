/**
 * 
 */
package arpg.game.effects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import arpg.game.effects.modifier.Modifier;

/**
 * @author Andrew
 * 
 */
@XmlRootElement
public abstract class OneTimeEffect extends Effect {
	
	/**
	 * The level of the effect
	 */
	@XmlElement
	public byte level;
	
	/**
	 * 
	 */
	public OneTimeEffect () {
		
		super("", "", null);
		level = 1;
		
	}
	
	/**
	 * @param level
	 */
	public OneTimeEffect (byte level) {
		
		super("", "", null);
		this.level = level;
		
	}
	
	/**
	 * @param name
	 * @param description
	 * @param level
	 */
	public OneTimeEffect (String name, String description, byte level) {
		
		// TODO Auto-generated constructor stub
		
		super(name, description, null);
		this.level = level;
		
	}
	
	/**
	 * @param name
	 * @param description
	 * @param modifier
	 * @param level
	 */
	public OneTimeEffect (String name, String description, Modifier modifier,
			byte level) {
		
		super(name, description, modifier);
		this.level = level;
		
	}
	
}
