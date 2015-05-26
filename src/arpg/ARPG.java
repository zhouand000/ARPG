package arpg;

import java.util.logging.Logger;

/**
 * 
 */

/**
 * @author Main
 */
public class ARPG {
	
	/**
	 * The logger instance for ARPG
	 */
	public static Logger logger = Logger.getLogger("Game Logger");
	
	/**
	 * 
	 */
	public ARPG () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		Game g = new Game();
		g.startGame();
		
	}
	
}
