/**
 * 
 */
package arpg.game.character;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Andrew
 * 
 */
public class StatMap extends EnumMap<StatType, Stat> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param keyType
	 */
	public StatMap (Class<StatType> keyType) {
		
		// TODO Auto-generated constructor stub
		super(keyType);
		
	}
	
	/**
	 * @param m
	 */
	public StatMap (Map<StatType, ? extends Stat> m) {
		
		// TODO Auto-generated constructor stub
		super(m);
		
	}
	
	/**
	 * @param m
	 */
	public StatMap (EnumMap<StatType, ? extends Stat> m) {
		
		// TODO Auto-generated constructor stub
		super(m);
		
	}
	
}
