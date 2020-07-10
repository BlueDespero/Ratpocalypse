package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateManager;
import ratpocalypse.display.buttons.ColorTextButton;

public class LoseArea extends Area {
	
	public LoseArea(Handler handler) {
		super(handler);
		buttonlist.add(new ColorTextButton(handler, 500, "Menu", ((Void) -> {StateManager.setState("menu"); return null;}), Color.red, Color.black ));
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
