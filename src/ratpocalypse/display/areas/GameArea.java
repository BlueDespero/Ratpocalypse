package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;

public class GameArea extends Area {

	public GameArea(Handler handler) {
		super(handler);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 4; j++) {
				buttonlist.add(new TransparentTile(handler, i, j));
			}
		}
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
