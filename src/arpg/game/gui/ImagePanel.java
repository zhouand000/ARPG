package arpg.game.gui;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
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
	 * The default border insets
	 */
	public static final Insets DEFAULT_BORDER_INSETS = new Insets(40, 40, 40, 40);
	
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
	
	private boolean shouldUpdate = true;
	
	/**
	 * The texturePaint object
	 */
	public TexturePaint texturePaint;
	
	/**
	 * Determines if the image should be resized, tiled, left as-is, or not
	 * painted
	 */
	public Mode mode = Mode.NONE;
	
	/**
	 * 
	 */
	public ImagePanel () {
		
		this(new EmptyBorder(DEFAULT_BORDER_INSETS));
		
	}
	
	/**
	 * @param b
	 * 
	 */
	public ImagePanel (Border b) {
		// TODO Auto-generated constructor stub
		System.out.println("");
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
				shouldUpdate = true;
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
	 * @param layoutManager
	 */
	public ImagePanel (LayoutManager layoutManager) {
		this();
		setLayout(layoutManager);
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
			
			shouldUpdate = true;
			
			updateImage();
			
		}
		catch (IOException e) {
			backgroundImage = null;
			mode = Mode.NONE;
		}
		
	}
	
	private void updateImage () {
		
		switch (mode) {
		
			case SCALED:
				updateScaledImage();
				break;
			case TILED:
				updateTiledImage();
				break;
			default:
				break;
		
		}
		
	}
	
	private void updateScaledImage () {
		
		if (backgroundImage != null && shouldUpdate) {
			
			scaledImage = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			
		}
		shouldUpdate = false;
		
	}
	
	private void updateTiledImage () {
		
		if (backgroundImage != null && shouldUpdate) {
			
			texturePaint = new TexturePaint((BufferedImage) backgroundImage, (Rectangle2D) getBounds());
			
		}
		shouldUpdate = false;
		
	}
	
	/**
	 * @param mode
	 *            Sets the mode of the panel
	 */
	public void setMode (Mode mode) {
		
		this.mode = mode;
		shouldUpdate = true;
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent (Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		updateImage();
		
		switch (mode) {
			case SCALED:
				g.drawImage(scaledImage, 0, 0, this);
				break;
			case PLAIN:
				g.drawImage(backgroundImage, 0, 0, this);
				break;
			case TILED:
				Graphics2D g2d = (Graphics2D) g;
				g2d.setPaint(texturePaint);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			default:
				break;
		}
	}
	
	/**
	 * @author Andrew
	 * 
	 */
	@SuppressWarnings("javadoc")
	public enum Mode {
		
		TILED,
		SCALED,
		PLAIN,
		NONE;
		
	}
	
}
