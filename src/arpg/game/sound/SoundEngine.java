/**
 * 
 */
package arpg.game.sound;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.*;

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
	public boolean isCurrentlyPlaying = false;
	
	ClassLoader loader = this.getClass().getClassLoader();
	
	/**
	 * The location of the sounds folder
	 */
	public static final String soundsFolderLocation = "arpg/assets/sounds/";
	
	/**
	 * 
	 */
	public SoundEngine () {
		// TODO Auto-generated constructor stub
		
		soundMap = new HashMap<String, String>();
		initSoundMap();
		try {
			clip = AudioSystem.getClip();
		}
		catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Plays the matching sound
	 * 
	 * @param name
	 *            The name of the sound
	 */
	public void play (String name) {
		
		String location = soundMap.get(name);
		
		if (location == null) {
			throw new IllegalArgumentException(name + "could not be found");
		}
		
		AudioInputStream ais;
		
		try {
			ais = AudioSystem.getAudioInputStream(new URL(location));
			clip.open(ais);
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clip.start();
		isCurrentlyPlaying = true;
		
	}
	
	void initSoundMap () {
		
		soundMap.put("8bit Dungeon Boss", "8bit Dungeon Boss.wav");
		soundMap.put("Adventure Meme", "Adventure Meme.wav");
		soundMap.put("All This", "All This.wav");
		soundMap.put("Black Vortex", "Black Vortex.wav");
		soundMap.put("Call to Adventure", "Call to Adventure.wav");
		soundMap.put("Carefree", "Carefree.wav");
		soundMap.put("Cipher", "Cipher2.wav");
		soundMap.put("Cipher2", "Cipher2.wav");
		soundMap.put("Discovery Hit", "Discovery Hit.wav");
		soundMap.put("Fanfare for Space", "Fanfare for Space.wav");
		soundMap.put("Full On", "Full On.wav");
		soundMap.put("Hitman", "Hitman.wav");
		soundMap.put("Life of Riley", "Life of Riley.wav");
		soundMap.put("Take a Chance", "Take a Chance.wav");
		soundMap.put("Tempting Secrets", "Tempting Secrets.wav");
		soundMap.put("The Complex", "The Complex.wav");
		soundMap.put("The Curtain Rises", "The Curtain Rises.wav");
		soundMap.put("The Descent", "The Descent.wav");
		soundMap.put("Video Dungeon Boss", "Video Dungeon Boss.wav");
		
	}
	
}
