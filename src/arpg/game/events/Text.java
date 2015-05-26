/**
 * 
 */
package arpg.game.events;

/**
 * @author Andrew
 * 
 */
public class Text implements TextContainer{
	
	/**
	 * 
	 */
	public final String text;
	
	/**
	 * @param text
	 * 
	 */
	public Text (String text) {
		this.text = text;
		
	}
	
	/**
	 * @return the text
	 */
	@Override
	public String getText () {
		
		return text;
		
	}

	@Override
	public String toString () {
		
		return text;
		
	}
}
