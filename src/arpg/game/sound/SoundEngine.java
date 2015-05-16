/**
 * 
 */
package arpg.game.sound;

import java.util.HashMap;

import javax.sound.sampled.Clip;

/**
 * @author Andrew
 * 
 */
public class SoundEngine {
	
	/**
	 * Maps Strings to the file location
	 */
	public final HashMap<String, String> soundMap;
	
	/**
	 * The clip
	 */
	public Clip clip;
	
	/**
	 * 
	 */
	public SoundEngine () {
		// TODO Auto-generated constructor stub
		
		soundMap = new HashMap<String, String>();
		initSoundMap();
		
	}
	
	void initSoundMap () {
		
	}
	
	/**
	 * Plays the matching sound
	 * 
	 * @param name
	 *            The name of the sound
	 */
	public void play (String name) {
		
		String location = soundMap.get(name);
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
	}
	
}
