/**
 * 
 */
package arpg.game;

import java.util.ArrayList;

import arpg.game.effects.*;

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
	 * 
	 */
	public final String description;
	
	/**
	 * Item effect
	 */
	public ArrayList<ItemEffect> effects;
	
	/**
	 * @param name
	 * @param effect
	 * 
	 */
	public Item (String name, String description, ItemEffect... arguments) {
		
		// TODO Auto-generated constructor stub
		this.name = name;
		
		this.description = description;
		
		for (ItemEffect e : arguments) {
			
			effects.add(e);
			
		}
		
	}
	
}
