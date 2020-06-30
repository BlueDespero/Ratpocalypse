package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;
import ratpocalypse.display.buttons.ColorTextButton;

public class MenuArea extends Area {

	public MenuArea(Handler handler) {
		super(handler);
		buttonlist.add(new ColorTextButton(handler, 476, 150, "Potyczka", ((Void) -> {StateMenager.setState("game"); return null;} ) ));
		buttonlist.add(new ColorTextButton(handler, 350, "Ustawienia", ((Void) -> {StateMenager.setState("settings"); return null;} ) ));
		buttonlist.add(new ColorTextButton(handler, 450, "Zakoncz", ((Void) -> {System.exit(0); return null;} )));
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
