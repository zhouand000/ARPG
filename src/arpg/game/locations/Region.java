/**
 * 
 */
package arpg.game.locations;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Andrew
 * 
 */
public class Region {
	
	/**
	 * The name of the region
	 */
	public final String name;
	
	/**
	 * List of possible locations
	 */
	public final ArrayList<Location> locations;
	
	/**
	 * @param name 
	 * @param locations 
	 * 
	 */
	public Region (String name, ArrayList<Location> locations) {
		this.name = name;
		this.locations = locations;
	}
	
	/**
	 * @param name
	 * @param arguments Locations varargs
	 */
	public Region (String name, Location... arguments) {
		
		this.name = name;
		this.locations = new ArrayList<Location>(Arrays.asList(arguments));
		
	}
	
}
