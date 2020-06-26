package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;

public class MenuArea extends Area {

	public MenuArea(Handler handler) {
		super(handler);
		buttonlist.add(createDefaultButton("Potyczka", 150, ((Void) -> {StateMenager.setState("game"); return null;} ) ));
		//buttonlist.add(createDefaultButton("Sklep", 250, ((Void) -> {StateMenager.setState(); return null;} )));
		buttonlist.add(createDefaultButton("Ustawienia", 350, ((Void) -> {StateMenager.setState("settings"); return null;} ) ));
		buttonlist.add(createDefaultButton("Zakoncz", 450, ((Void) -> {System.exit(0); return null;} )));
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
