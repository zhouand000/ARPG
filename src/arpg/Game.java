/**
 * 
 */
package arpg;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import arpg.game.Player;
import arpg.game.character.StatMap;
import arpg.game.events.*;
import arpg.game.gui.GameWindow;
import arpg.game.sound.SoundEngine;

/**
 * @author Andrew
 * 
 */
public class Game {
	
	/**
	 * A regex that matches a integer
	 */
	public static final String INTEGER_PATTERN = "^\\d+$";
	
	GameWindow gw;
	
	EventFactory ef;
	
	SoundEngine soundEngine;
	
	Map<String, EventGroup> eventGroupMap;
	
	Map<String, Event> eventMap;
	
	Map<String, TextList> textMap;
	
	PrintStream ps;
	
	Scanner sc;
	
	Event currentEvent;
	
	Event nextEvent;
	
	Player p;
	
	int progress;
	
	int goal;
	
	StatMap stats;
	
	boolean continueGame;
	
	Thread gameThread;
	
	private boolean nextTick = false;
	
	/**
	 * 
	 */
	public Game () {
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				
				@Override
				public void run () {
					gw = new GameWindow();
					
				}
			});
		}
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		ef = new EventFactory();
		soundEngine = new SoundEngine();
		eventGroupMap = ef.getEventGroupMap();
		eventMap = ef.getEventMap();
		textMap = ef.getTextListMap();
		
		try {
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			
		}
		
		System.out.println(gw != null && gw.outputStream != null);
		ps = new PrintStream(gw.outputStream);
		sc = new Scanner(gw.inputStream);
		
	}
	
	/**
	 * 
	 */
	public void startGame () {
		
		currentEvent = eventMap.get("Start");
		System.out.println(eventMap);
		System.out.println(currentEvent);
		continueGame = true;
		p = new Player();
		progress = 0;
		
		gw.setVisible(true);
		System.out.println("DEBUG: GameWindow now visible");
		soundEngine.playPlaylist("ADVENTURE_INTRO3");
		
		gameThread = new Thread(new Runnable() {
			
			@Override
			public void run () {
				
				while (continueGame) {
					/*-
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException e) {
						
					}
					 */
					onTick();
				}
			}
		});
		gameThread.run();
		
	}
	
	/**
	 * 
	 */
	public void onTick () {
		displayEvent();
		while (!nextTick) {
			
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				
			}
			
		}
		nextTick = true;
	}
	
	/**
	 * 
	 */
	public void displayEvent () {
		// System.setOut(ps);
		final Event event = currentEvent;
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run () {
				
				System.out.println("DEBUG: running runnable");
				
				if (event == null) {
					throw new NullPointerException("event is null");
				}
				if (event.text == null) {
					throw new NullPointerException("event.text is null");
				}
				if (event.text.getText() == null) {
					throw new NullPointerException("event.text.getText() returned null");
				}
				
				ps.println(event.text.getText());
				System.out.println(event.text.getText());
				System.out.println(event.text);
				System.out.println("DEBUG: Tried printing text");
				ps.println();
				for (int i = 0; i < event.choices.getChoiceText().size(); i++) {
					
					ps.printf("%s. %s", i, event.choices.getChoiceText().get(i));
					
				}
				ps.println();
				nextEvent = event.getChoice(getPlayerChoiceNumber()).getNextEvent();
				
				nextEvent
				= nextEvent == null ? eventMap.values().iterator().next()
						: nextEvent;
				nextTick = true;
				
			}
			
			public int getPlayerChoiceNumber () {
				
				gw.setStatus("Enter a number");
				String input;
				int choice = -1;
				
				while (choice < 0) {
					System.out.println("read");
					input = sc.findInLine(INTEGER_PATTERN);
					
					try {
						choice = Integer.parseInt(input);
					}
					catch (NumberFormatException e) {
						try {
							Thread.sleep(1000);
						}
						catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					
				}
				return choice;
			}
			
		});
		
	}
}
