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
public abstract class Effect {
	
	/**
	 * The name of the effect.
	 */
	@XmlElement
	public final String name;
	
	/**
	 * A description of the effect
	 */
	@XmlElement
	public final String description;
	
	/**
	 * The modifier associated with the effect
	 */
	@XmlElement
	public final Modifier modifier;
	
	/**
	 * @param name
	 * @param description
	 * @param modifier
	 *
	 */
	public Effect (String name, String description, Modifier modifier) {
		
		this.name = name;
		this.description = description;
		this.modifier = modifier;
		
	}
	
}
