package ratpocalypse.backend.states;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;

public class StateMenager {
	
	private static State currentState = null;
	static Handler handler;
	
	public StateMenager(Handler handler) {
		StateMenager.handler = handler;
	}
	
	public static void setState(String s) {
		switch (s) {
		case "menu":
			currentState = new MenuState(handler);
			break;
			
		case "game":
			currentState = new GameState(handler);
			break;
			
		case "settings":
			currentState = new SettingsState(handler);
			break;
			
		case "lose":
			currentState = new LoseState(handler);
			break;

		case "win":
			currentState = new WinState(handler);
			break;
			
		default:
			break;
		}
		
		GameVariableManager.lastYellowRoses=GameVariableManager.yellowRoses;
	}
	
	public static State getState(){
		return currentState;
	}

}
