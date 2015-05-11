/**
 * 
 */
package arpg.game;

/**
 * @author Andrew
 * 
 */
public class Item {
	
	/**
	 * Name
	 */
	public final String name;
	
	/**
	 * Item effect 
	 */
	public Effect effect;
	
	/**
	 * @param name
	 * @param effect
	 * 
	 */
	public Item (String name, Effect effect) {
		
		// TODO Auto-generated constructor stub
		this.name = name;
		this.effect = effect;
	}
	
}
