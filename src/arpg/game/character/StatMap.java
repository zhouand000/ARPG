/**
 * 
 */
package arpg.game.character;

import java.util.*;

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
	
	/*
	@Override
	public Stat get (Object o) {
		
		StatType type;
		if (o instanceof String) {
			type = StatType.lookupStatType((String) o);
			return super.get(type);
		}
		else if (isValidKey(o)) {
			
			return super.get(o);
			
		}
		else {
			return null;
		}
		
	}
	 */
	
	/**
	 * @param o
	 * @return true if o is a valid key
	 */
	public boolean isValidKey (Object o) {
		
		return o instanceof StatType;
		
	}
	
	/**
	 * @param o
	 * @return true if o is a valid value
	 */
	public boolean isValidValue (Object o) {
		
		return o instanceof Stat;
		
	}
	
}
