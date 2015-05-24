/**
 * 
 */
package arpg.game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Andrew
 * 
 */
public class GameWindow extends JFrame implements GraphicsConstants {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The contentPane
	 */
	public Container contentPane;
	
	/**
	 * The outer panel.
	 */
	public JPanel outerPanel;
	
	/**
	 * The inner panel. Contains the inner GUI elements.
	 */
	public JPanel innerPanel;
	
	/**
	 * JPanel for the text boxes
	 */
	public JPanel textPanel;
	
	/**
	 * Container containing the input text field and the status text field
	 */
	public Container inputContainer;
	
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
	 * Used to display the event log. This text area is not editable
	 */
	public JTextArea textArea;
	
	/**
	 * Status field. This text area is not editable
	 */
	public JTextField statusField;
	
	/**
	 * Player can enter text here. The text will be processed upon detection of
	 * an enter key press
	 */
	public JTextField inputField;
	
	/**
	 * 
	 */
	public JMenuBar menuBar;
	
	/**
	 * 
	 */
	public JMenu gameMenu;
	
	/**
	 * 
	 */
	public JMenuItem quitMenuItem;
	
	/**
	 * The background color of the inner frame
	 */
	public Color backgroundColor;
	
	/**
	 * 
	 */
	public GameWindow () {
		
		// TODO Auto-generated constructor stub
		
		contentPane = getContentPane();
		outerPanel = new ImagePanel();
		innerPanel = new JPanel();
		textPanel = new JPanel();
		inputContainer = new Container();
		
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		textArea = new JTextArea(10, 40);
		statusField = new JTextField(40);
		inputField = new JTextField(40);
		
		menuBar = new JMenuBar();
		gameMenu = new JMenu("Game");
		quitMenuItem = new JMenuItem(new AbstractAction("Quit") {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed (ActionEvent e) {
				for (Frame f : Frame.getFrames()) {
					if (f.isActive()) {
						f.dispose();
					}
				}
			}
		});
		
		configGUI();
		
	}
	
	@SuppressWarnings("javadoc")
	public static void main (String[] args) {
		
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		
	}
	
	/**
	 * Configures the GUI
	 */
	private void configGUI () {
		
		setTitle("ARPG");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		
		textPanel.setLayout(new BorderLayout());
		inputContainer.setLayout(new BoxLayout(inputContainer, BoxLayout.Y_AXIS));
		
		configTextComponents();
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(textArea);
		scrollPane.setMinimumSize(textArea.getMinimumSize());
		
		textPanel.add(scrollPane, BorderLayout.CENTER);
		
		inputContainer.add(statusField);
		inputContainer.add(inputField);
		
		textPanel.add(inputContainer, BorderLayout.SOUTH);
		
		innerPanel.setLayout(new BorderLayout());
		innerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		innerPanel.add(new JButton("Test Button"), BorderLayout.SOUTH);
		innerPanel.add(textPanel, BorderLayout.CENTER);
		
		outerPanel.setLayout(new BorderLayout());
		outerPanel.add(innerPanel, BorderLayout.CENTER);
		
		contentPane.add(outerPanel, BorderLayout.CENTER);
		
		setJMenuBar(menuBar);
		
		pack();
		
	}
	
	private void configTextComponents () {
		
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setFont(MONOSPACED_FONT);
		textArea.setVisible(true);
		
		statusField.setEditable(false);
		statusField.setFont(MONOSPACED_FONT);
		statusField.setBackground(backgroundColor);
		
		inputField.setEditable(true);
		inputField.setFont(MONOSPACED_FONT);
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JFrame#setContentPane(java.awt.Container)
	 */
	@Override
	public void setContentPane (Container contentPane) {
		super.setContentPane(contentPane);
		this.contentPane = contentPane;
	}
	
}
