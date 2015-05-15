/**
 * 
 */
package arpg.game.character;

/**
 * @author Andrew
 * 
 */
public class Stat {
	
	/**
	 * Name of the stat
	 */
	public final String name;
	
	/**
	 * Base stat; the stat unchanged by effects. 
	 */
	public int base;
	
	/**
	 * Current stat
	 */
	public float current;
	
	/**
	 * @param name
	 * @param base
	 * 
	 */
	public Stat (String name, int base) {
		
		// TODO Auto-generated constructor stub
		this.name = name;
		this.base = base;
		this.current = base;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode () {
		// TODO Auto-generated method stub
		return name.hashCode();
	}
	
}
