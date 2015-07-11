package arpg.game.gui;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * @author Andrew
 * 
 */
public class TextAreaOutputStream extends OutputStream {
	
	private final JTextArea textArea;
	
	private final StringBuilder sb = new StringBuilder();
	
	/**
	 * @param textArea
	 * 
	 */
	public TextAreaOutputStream (JTextArea textArea) {
		this.textArea = textArea;
		
	}
	
	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write (int b) throws IOException {
		
		System.out.println("DEBUG: write ()");
		
		if (b == '\r') {
			return;
		}
		if (b == '\n') {
			sb.append(new String(new int[] { b }, 0, 1));
			final String text = sb.toString();
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run () {
					System.out.println("DEBUG: write () : invokeLater () : run ()");
					textArea.append(text);
				}
			});
		}
		sb.setLength(0);
		return;
	}
}
