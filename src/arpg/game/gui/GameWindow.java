/**
 * 
 */
package arpg.game.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import arpg.game.gui.ImagePanel.Mode;

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
	 * Default location for the brick background
	 */
	public static final String BRICK_BACKGROUND_LOCATION = "arpg/assets/images/BrickBackground.png";
	
	ClassLoader loader = getClass().getClassLoader();
	
	/**
	 * The contentPane
	 */
	public Container contentPane;
	
	/**
	 * The outer panel. Acts as background
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
	public JTextArea logArea;
	
	/**
	 * Status field. This text area is not editable
	 */
	public JTextField statusField;
	
	/**
	 * The panel that contains the status field
	 */
	public JPanel statusPanel;
	
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
	public Color backgroundColor = Color.LIGHT_GRAY;
	
	/**
	 * The inputStream associated with the JTextField inputField
	 */
	public InputStream inputStream;
	
	/**
	 * The outputStream associated with the JTextArea logArea
	 */
	public OutputStream outputStream;
	
	/**
	 * 
	 */
	public PrintStream printStream;
	
	/**
	 * 
	 */
	public GameWindow () {
		
		configLookAndFeel();
		
		contentPane = getContentPane();
		outerPanel = new ImagePanel(new BorderLayout());
		innerPanel = new JPanel(new BorderLayout());
		textPanel = new JPanel(new BorderLayout());
		inputContainer = new Container();
		statusPanel = new JPanel(new BorderLayout());
		
		scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		logArea = new JTextArea(10, 40);
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
		inputStream = new TextComponentInputStream(inputField);
		outputStream = new TextAreaOutputStream(logArea);
		printStream = new PrintStream(outputStream);
		
	}
	
	@SuppressWarnings("javadoc")
	public static void main (String[] args) {
		
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.setStatus("Test");
		
	}
	
	/**
	 * @param s
	 */
	public void setStatus (String s) {
		
		statusField.setText(s);
		
	}
	
	/**
	 * 
	 */
	private void configLookAndFeel () {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equalsIgnoreCase(info.getName())) {
					try {
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
					catch (ClassNotFoundException e) {
					}
					catch (InstantiationException e) {
					}
				}
			}
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			try {
				UIManager.setLookAndFeel("Metal");
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Configures the GUI
	 */
	private void configGUI () {
		
		setTitle("ARPG");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		
		inputContainer.setLayout(new BoxLayout(inputContainer, BoxLayout.Y_AXIS));
		
		configTextComponents();
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(logArea);
		scrollPane.setMinimumSize(logArea.getMinimumSize());
		
		textPanel.add(scrollPane, BorderLayout.CENTER);
		
		statusPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
		statusPanel.add(statusField);
		
		inputContainer.add(statusPanel);
		inputContainer.add(inputField);
		
		textPanel.add(inputContainer, BorderLayout.SOUTH);
		
		innerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		innerPanel.add(textPanel, BorderLayout.CENTER);
		
		configBackgroundPanel();
		
		outerPanel.add(innerPanel, BorderLayout.CENTER);
		
		contentPane.add(outerPanel, BorderLayout.CENTER);
		
		gameMenu.add(quitMenuItem);
		menuBar.add(gameMenu);
		// menuBar.setPreferredSize(new Dimension(10, 20));
		setJMenuBar(menuBar);
		
		pack();
		
	}
	
	private void configTextComponents () {
		
		logArea.setEditable(false);
		logArea.setWrapStyleWord(true);
		// logArea.setFont(MONOSPACED_FONT);
		logArea.setVisible(true);
		
		statusField.setEditable(false);
		// statusField.setFont(MONOSPACED_FONT);
		statusField.setBackground(new Color(UIManager.getColor("RootPane.background").getRGB()));
		statusField.setBorder(null);
		
		inputField.setEditable(true);
		// inputField.setFont(MONOSPACED_FONT);
		
	}
	
	private void configBackgroundPanel () {
		
		ImagePanel ip = (ImagePanel) outerPanel;
		try {
			ip.setImage(new File(loader.getResource(BRICK_BACKGROUND_LOCATION).toURI()));
			ip.setMode(Mode.TILED);
		}
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
