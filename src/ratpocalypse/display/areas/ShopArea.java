package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;

public class ShopArea extends Area {
	
	public ShopArea(Handler handler) {
		super(handler);
		//buttonlist.add(createDefaultButton("Jednostki", 150));
		//buttonlist.add(createDefaultButton("Ulepszenia", 250));
		//buttonlist.add(createDefaultButton("Muzyka", 350));
		buttonlist.add(createDefaultButton("Wstecz", 450, ((Void) -> {StateMenager.setState("menu"); return null;} )));
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
