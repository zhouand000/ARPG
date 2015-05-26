/**
 * 
 */
package arpg.game.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.text.JTextComponent;

/**
 * @author Andrew
 * 
 */
public class TextComponentInputStream extends InputStream {
	
	byte[] contents;
	
	int pointer = 0;
	
	/**
	 * @param component
	 */
	public TextComponentInputStream (final JTextComponent component) {
		
		component.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased (KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					contents = component.getText().getBytes();
					pointer = 0;
					component.setText("");
				}
			}
		});
	}
	
	@Override
	public int read () throws IOException {
		
		System.out.println("DEBUG: read ()");
		
		/*-

		while (!(contents != null)) {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 */
		/*-
		while (pointer >= contents.length) {
		try {
		Thread.sleep(100);
		}
		catch (InterruptedException e) {
		
		}
		}
		*/
		if (contents == null) {
			
			return -1;
			
		}
		return contents[pointer++];
	}
}
