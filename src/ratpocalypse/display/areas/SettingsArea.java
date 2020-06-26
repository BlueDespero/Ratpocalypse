package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;
import ratpocalypse.display.gfx.Assets;

public class SettingsArea extends Area {

	public SettingsArea(Handler handler) {
		super(handler);	
		buttonlist.add(createDefaultButton("Zwiększ poziom trudności!", 150, ((Void) -> {handler.getGame().getGvmanager().difficulty++; return null;} ) ));
		buttonlist.add(createDefaultButton("Zmniejsz poziom trudności", 350, ((Void) -> {handler.getGame().getGvmanager().difficulty--; if(handler.getGame().getGvmanager().difficulty<1) handler.getGame().getGvmanager().difficulty=1; return null;} ) ));
		buttonlist.add(createDefaultButton("Wstecz", 450, ((Void) -> {StateMenager.setState("menu"); return null;} )));

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.settings, 0, 0, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.setColor(Color.yellow);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
		g.drawString("Poziom trudności: "+handler.getGame().getGvmanager().difficulty, 520, 250);
		renderbuttorlist(g);
	}

	@Override
	public void tick() {
		tickbuttonlist();
	}

}
