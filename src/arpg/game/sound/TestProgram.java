/**
 * 
 */
package arpg.game.sound;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.*;

/**
 * @author Andrew
 * 
 */
@SuppressWarnings("javadoc")
public class TestProgram {
	
	public static Clip c;
	
	public static Scanner sc;
	
	public static boolean stop = false;
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
		// System.out.println(new File("").getAbsolutePath());
		
		sc = new Scanner(System.in);
		System.out.println(Arrays.toString(AudioSystem.getAudioFileTypes()));
		
		AudioInputStream ais;
		File inputFile = null;
		inputFile = new File("/Users/Andy/Documents/Development/RPG/src/arpg/assets/sounds/Cipher2.wav");
		
		try {
			
			System.out.println(AudioSystem.getAudioFileFormat(inputFile));
			ais = AudioSystem.getAudioInputStream(inputFile);
			c = AudioSystem.getClip();
			c.open(ais);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			System.out.println(inputFile.getCanonicalPath());
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// JOptionPane.showMessageDialog(null, "Next: Cipher2.wav");
		System.out.println("About to play");
		// c.loop(1);
		c.start();
		// JOptionPane.showMessageDialog(null, "Now Playing: Cipher by Kevin MacLeod");
		System.out.println("Now playing");
		
		Thread inputThread = new Thread(new Runnable() {
			
			@Override
			public void run () {
				
				try {
					loop();
				}
				catch (InterruptedException e) {
					
				}
				
			}
			
			void loop () throws InterruptedException {
				
				String temp;
				do {
					
					temp = sc.nextLine();
					for (int i = 0; i <= temp.length(); i++) {
						System.out.print('\b');
					}
					
				}
				while (!temp.toLowerCase().matches("stop|s") && !stop);
				onStop();
				
			}
			
		});
		
		Thread isRunningThread = new Thread(new Runnable() {
			
			@Override
			public void run () {
				
				try {
					loop();
				}
				catch (InterruptedException e) {
					
				}
				
			}
			
			void loop () throws InterruptedException {
				
				while (c.isRunning() && !stop) {
					
					Thread.sleep(100);
					
				}
				onStop();
				
			}
			
		});
		
		inputThread.start();
		isRunningThread.start();
		
		try {
			while (!stop) {
				
				Thread.sleep(100);
				
			}
		}
		catch (InterruptedException e) {
			
		}
		
		System.out.println("Done");
		sc.close();
		
	}
	
	static void onStop () {
		
		stop = true;
		sc.close();
		c.close();
		
	}
}
