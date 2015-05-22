/**
 * 
 */
package arpg.game;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Andrew
 * 
 */
public class GameWindow extends JFrame {
	
	/**
	 * Background JPanel.
	 */
	public JPanel background;
	
	/**
	 * Inner panel. Done so that outer
	 */
	public JPanel foreground;
	
	/**
	 * JScrollPane containing the textArea.
	 */
	public JScrollPane scrollPane;
	
	/**
	 * Used to display the event log. Not editable
	 */
	public JTextArea textArea;
	
	/**
	 * Status field. Returns status of current input.
	 */
	public JTextField statusField;
	
	/**
	 * Player can enter text here. The action will commit upon detection of an
	 * enter key press
	 */
	public JTextField textField;
	
	public static Font defaultFont = Font.getFont(Font.MONOSPACED);
	
	public Color backgroundColor
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GameWindow () {
		
		// TODO Auto-generated constructor stub
		
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		textArea = new JTextArea();
		
		textField = new JTextField();
		
		configGUI();
		
	}
	
	/**
	 * Configures the GUI
	 */
	private void configGUI () {
		
		setTitle("ARPG");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		
		
		configTextComponents();
		
	}
	
	private void configTextComponents () {
		
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setFont(defaultFont);
		
		textField.setEditable(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(defaultFont);
		
	}
	
	public class JPanelWithBackgroundImage extends JPanel {
		
		/**
		 * The JPanel's background image
		 */
		public Image backgroundImage;
		public Border border;
		
		/**
		 * 
		 */
		public JPanelWithBackgroundImage () {
			// TODO Auto-generated constructor stub
			
		}
		
		/* (non-Javadoc)
		 * @see javax.swing.JComponent#setBorder(javax.swing.border.Border)
		 */
		@Override
		public void setBorder (Border border) {
			// TODO Auto-generated method stub
			super.setBorder(border);
		}
		
		
		
		
		
	}
}
