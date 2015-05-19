/**
 * 
 */
package arpg.game.sound;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

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
	 * The length of the clip
	 */
	public long clipLength;
	
	LineListener listener;
	
	/**
	 * 
	 */
	public boolean isCurrentlyPlaying = false;
	
	ClassLoader loader = this.getClass().getClassLoader();
	
	Thread thread;
	
	/**
	 * 
	 */
	public LinkedList<String> queue;
	
	/**
	 * The location of the sounds folder
	 */
	public static final String soundsFolderLocation = "arpg/assets/sounds/";
	
	boolean shouldStop;
	
	/**
	 * 
	 */
	public SoundEngine () {
		// TODO Auto-generated constructor stub
		
		soundMap = new HashMap<String, String>();
		initSoundMap();
		
		queue = new LinkedList<String>();
		
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
		SoundEngine engine = new SoundEngine();
		Playlist p = new Playlist("TestList");
		p.add("The Curtain Rises");
		p.add("Discovery Hit");
		
		engine.playPlaylist(p);
		
	}
	
	/**
	 * Resets the sound queue and adds p to the queue
	 * 
	 * @param p
	 * 
	 */
	public <T extends List<String>> void playPlaylist (final T p) {
		
		if (thread != null && thread.isAlive()) {
			shouldStop = true;
			try {
				thread.join();
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		thread = new Thread(
				new Runnable() {
					@Override
					public void run () {
						if (clip != null && clip.isRunning()) {
							stop();
						}
						queue = new LinkedList<String>(p);
						String name;
						try {
							while (!shouldStop && !queue.isEmpty()) {
								
								name = queue.peekFirst();
								
								play(name);
								
								listener = new LineListener() {
									
									@Override
									public void update (LineEvent event) {
										
										if (event.getType() == LineEvent.Type.STOP) {
											queue.pollFirst();
											clip.removeLineListener(listener);
											System.out.println("DEBUG: Removing the first song from the queue");
											// playNextQueuedSound();
											
										}
										
									}
								};
								
								clip.addLineListener(listener);
								
								// playNextQueuedSound(); // TODO Fix?
								
								while (!shouldStop && clip.isRunning()) {
									// System.out.println("DEBUG: Playing Playlist");
									Thread.sleep(10);
									
								}
								// System.out.println("DEBUG: Done playing");
								
							}
						}
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				},
				"SoundThread"
				);
		
		thread.run();
		
	}
	
	/**
	 * 
	 */
	public void playNextQueuedSound () {
		
		assert (queue.size() >= 1);
		
		String name = queue.peekFirst();
		
		play(name);
		
		listener = new LineListener() {
			
			@Override
			public void update (LineEvent event) {
				
				if (event.getType() == LineEvent.Type.STOP) {
					queue.pollFirst();
					clip.removeLineListener(listener);
					// playNextQueuedSound();
					
				}
				
			}
		};
		
		clip.addLineListener(listener);
		
	}
	
	/**
	 * @param name
	 */
	public void addToQueue (String name) {
		
		queue.addLast(name);
		
	}
	
	/**
	 * @param list
	 */
	public void addToQueue (List<String> list) {
		
		for (String s : list) {
			
			queue.addLast(s);
			
		}
		
	}
	
	/**
	 * Clears the queue
	 */
	public void resetSoundQueue () {
		
		queue.clear();
		
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
		
		location = soundsFolderLocation + location;
		
		URL url = loader.getResource(location);
		
		AudioInputStream ais;
		
		try {
			ais = AudioSystem.getAudioInputStream(url);
			
			clipLength = (long) (ais.getFrameLength() / ais.getFormat().getFrameRate());
			
			clip = AudioSystem.getClip();
			System.out.println("Open");
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
	
	/**
	 * Stops the clip
	 */
	public void stop () {
		
		clip.stop();
		clip.close();
		
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
	
	void initPlaylists () {
		
	}
	
}
