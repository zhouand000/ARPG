/**
 * 
 */
package arpg.game.character;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrew
 * 
 */
public class StatMap extends HashMap<String, Stat> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public StatMap () {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * @param map
	 */
	public StatMap (Map<String, Stat> map) {
		
		super(map);
		
	}
	
}
