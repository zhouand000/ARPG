package arpg.game.gui;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * @author Andrew A JPanel that supports background images
 */
public class ImagePanel extends JPanel implements GraphicsConstants {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The background color to be used as a fail-safe in case the image is null;
	 */
	public Color backgroundColor = DEFAULT_BACKGROUND_COLOR;
	
	/**
	 * The JPanel's background image
	 */
	public Image backgroundImage;
	
	/**
	 * The scaled image
	 */
	public Image scaledImage;
	
	/**
	 * The border of the JPanel
	 */
	public Border border;
	
	/**
	 * Determines if the image should be resized
	 */
	public boolean shouldRescale = true;
	
	/**
	 * 
	 */
	public ImagePanel () {
		
		this (new EmptyBorder(20, 20, 20, 20));
		
	}
	
	/**
	 * @param b
	 * 
	 */
	public ImagePanel (Border b) {
		// TODO Auto-generated constructor stub
		
		setBorder(b);
		backgroundImage = null;
		scaledImage = null;
		addComponentListener(new ComponentListener() {
			@Override
			public void componentShown (ComponentEvent e) {
				// NO-OP
			}
			
			@Override
			public void componentResized (ComponentEvent e) {
				shouldRescale = true;
			}
			
			@Override
			public void componentMoved (ComponentEvent e) {
				// NO-OP
			}
			
			@Override
			public void componentHidden (ComponentEvent e) {
				// NO-OP
			}
		});
		
	}
	
	/**
	 * 
	 */
	public void resetToDefaults () {
		
		backgroundColor = DEFAULT_BACKGROUND_COLOR;
		border = EMPTY_BORDER;
		backgroundImage = null;
		scaledImage = null;
		
	}
	
	/**
	 * @param f
	 */
	public void setImage (File f) {
		
		try {
			
			backgroundImage = ImageIO.read(f);
			
			shouldRescale = true;
			
			updateScaledImage();
			
		}
		catch (IOException e) {
			
		}
		
	}
	
	private void updateScaledImage () {
		
		if (backgroundImage != null && shouldRescale) {
			
			scaledImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent (Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (backgroundImage != null) {
			
			g.drawImage(backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_AREA_AVERAGING), 0, 0, this);
			
		}
		
	}
	
}
