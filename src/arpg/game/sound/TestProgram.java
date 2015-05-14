/**
 * 
 */
package arpg.game.sound;

import java.io.File;
import java.io.IOException;

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
		
		AudioInputStream ais;
		Clip c = null;
		
		System.out.println(new File("TestFile").getAbsolutePath());
		
		try {
			ais = AudioSystem.getAudioInputStream(new File("./src/arpg/assets/sounds/Adventure Meme.mp3"));
			c = AudioSystem.getClip();
			c.open(ais);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Next: Adventure Meme.mp3");
		if (c != null) c.start();
		JOptionPane.showMessageDialog(null, "Now Playing: Adventure Meme.mp3");
		
		
		
	}
	
}
