package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateManager;
import ratpocalypse.display.buttons.ColorTextButton;

public class ShopArea extends Area {
	
	public ShopArea(Handler handler) {
		super(handler);
		//buttonlist.add(createDefaultButton("Jednostki", 150));
		//buttonlist.add(createDefaultButton("Ulepszenia", 250));
		//buttonlist.add(createDefaultButton("Muzyka", 350));
		buttonlist.add(new ColorTextButton(handler, 450, "Wstecz", ((Void) -> {StateManager.setState("menu"); return null;} )));
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
