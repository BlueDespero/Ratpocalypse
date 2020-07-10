package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.ColorTextButton;
import ratpocalypse.display.buttons.TransparentTile;

public class GameArea extends Area {

	public GameArea(Handler handler) {
		super(handler);
		buttonlist.add(new ColorTextButton(handler, 1070, 0, 70, 20, "Pauza", ((Void) -> {GameVariableManager.setPause(true); return null;}), Color.green, Color.black ) );
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
