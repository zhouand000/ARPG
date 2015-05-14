/**
 * 
 */
package arpg.assets.sounds;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.*;
import javax.swing.*;

/**
 * @author Andrew
 * 
 */
public class TestProgram {
	
	/**
	 * 
	 */
	public TestProgram () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println(Arrays.toString(AudioSystem.getAudioFileTypes()));
		
		AudioInputStream ais;
		Clip c = null;
		File inputFile = null;
		inputFile = new File("/Users/Andy/Documents/Development/RPG/src/arpg/assets/sounds/Cipher2.wav");
		
		try {
			
			System.out.println(AudioSystem.getAudioFileFormat(inputFile));
			ais = AudioSystem.getAudioInputStream(inputFile);
			c = AudioSystem.getClip();
			c.open(ais);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(inputFile.getCanonicalPath());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// JOptionPane.showMessageDialog(null, "Next: Cipher2.wav");
		System.out.println("About to play");
		// c.loop(1);
		c.start();
		// JOptionPane.showMessageDialog(null, "Now Playing: Cipher by Kevin MacLeod");
		System.out.println("Now playing");
		
		String temp;
		do {
			temp = sc.nextLine();
		}
		while (!temp.toLowerCase().matches("stop|s"));
		
		// JOptionPane.showMessageDialog(null, "Done");
		System.out.println("Done");
		
	}
}
