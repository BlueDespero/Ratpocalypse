package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;
import ratpocalypse.display.buttons.ColorTextButton;

public class WinArea extends Area {

	public WinArea(Handler handler) {
		super(handler);
		buttonlist.add(new ColorTextButton(handler, 600, "Menu", ((Void) -> {StateMenager.setState("menu"); return null;}), Color.red, Color.black ));
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
