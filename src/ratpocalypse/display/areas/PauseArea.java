package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateManager;
import ratpocalypse.display.buttons.ColorTextButton;

public class PauseArea extends Area {
	
	private int startingYellowRoses;

	public PauseArea(Handler handler) {
		super(handler);
		startingYellowRoses = GameVariableManager.getYellowRoses();
		System.out.println(startingYellowRoses);
		buttonlist.add(new ColorTextButton(handler, 150, "Wznów", ((Void) -> {GameVariableManager.setPause(false); return null;} ), Color.green.darker(), Color.black));
		buttonlist.add(new ColorTextButton(handler, 250, "Reset", ((Void) -> {
			GameVariableManager.setYellowRoses(startingYellowRoses);
			StateManager.setState("menu");
			StateManager.setState("game"); 
			GameVariableManager.setPause(false); return null;
			} ), Color.green.darker(), Color.black ));
		buttonlist.add(new ColorTextButton(handler, 350, "Powrót do menu", ((Void) -> {
			GameVariableManager.setYellowRoses(startingYellowRoses);
			StateManager.setState("menu"); return null;
			}), Color.green.darker(), Color.black));
		buttonlist.add(new ColorTextButton(handler, 450, "Zakończ", ((Void) -> {System.exit(0); return null;}), Color.green.darker(), Color.black));
	}

	@Override
	public void render(Graphics g) {
		renderbuttorlist(g);
	}

	@Override
	public void tick() {
		tickbuttonlist();
	}

}
