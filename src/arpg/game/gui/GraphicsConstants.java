/**
 * 
 */
package arpg.game.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * @author Andrew
 * 
 */
public interface GraphicsConstants {
	/**
	 * 
	 */
	public static final String DEFAULT_LOOK_AND_FEEL = "Nimbus";
	
	/**
	 * The default font
	 */
	public static final Font MONOSPACED_FONT = Font.getFont(Font.MONOSPACED);
	
	/**
	 * Empty border
	 */
	public static final Border EMPTY_BORDER = new EmptyBorder(0, 0, 0, 0);
	
	/**
	 * 
	 */
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
}
