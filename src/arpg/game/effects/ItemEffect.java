/**
 * 
 */
package arpg.game.effects;

import javax.xml.bind.annotation.*;

import arpg.game.character.StatMap;
import arpg.game.effects.modifier.Modifier;

/**
 * @author Andrew
 * 
 */
@XmlRootElement
public class ItemEffect extends Effect {
	
	// TODO Finish the class and update to reflect the new Stat API
	
	/**
	 * The instance of StatMap
	 */
	@XmlElementWrapper
	public StatMap stats;
	
	/**
	 * If the effect should be permanently applied to the character
	 */
	@XmlAttribute
	public boolean isPermanent;
	
	/**
	 * If the effect should only get applied, and removed when the duration ends
	 */
	@XmlAttribute
	public boolean isOneTimeEffect;
	
	/**
	 * If the effect is temporary
	 */
	@XmlAttribute
	public boolean isTemporaryEffect;
	
	/**
	 * Determines if the effect will affect the user
	 */
	@XmlAttribute
	public boolean affectUser;
	
	/**
	 * @param name
	 * @param description
	 * @param modifier
	 */
	public ItemEffect (String name, String description, Modifier modifier) {
		super(name, description, modifier);
		
	}
	
}
