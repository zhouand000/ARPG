/**
 * 
 */
package arpg.game.events;

/**
 * @author Andrew
 * 
 */
public class TextListReference implements TextContainer {
	
	/**
	 * 
	 */
	public TextList textList;
	
	/**
	 * 
	 */
	public TextListReference () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param textList
	 */
	public TextListReference (TextList textList) {
		this.textList = textList;
	}
	
	/* (non-Javadoc)
	 * @see arpg.game.events.TextContainer#getText()
	 */
	@Override
	public String getText () {
		return textList.getText();
	}
	
}
