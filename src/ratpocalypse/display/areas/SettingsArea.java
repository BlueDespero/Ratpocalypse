package ratpocalypse.display.areas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.backend.states.StateMenager;
import ratpocalypse.display.buttons.ColorTextButton;
import ratpocalypse.display.gfx.Assets;

public class SettingsArea extends Area {

	public SettingsArea(Handler handler) {
		super(handler);	
		buttonlist.add(new ColorTextButton(handler, 150, "Zwiększ poziom trudności!", ((Void) -> {GameVariableManager.incrementDifficulty(); return null;} ) ));
		buttonlist.add(new ColorTextButton(handler, 350, "Zmniejsz poziom trudności", ((Void) -> {GameVariableManager.decrementDifficulty(); if(GameVariableManager.getDifficulty()<1) GameVariableManager.setDifficulty(1); return null;} ) ));
		buttonlist.add(new ColorTextButton(handler, 450, "Wstecz", ((Void) -> {StateMenager.setState("menu"); return null;} )));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.settings, 0, 0, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
		g.drawString("Poziom trudności: "+GameVariableManager.getDifficulty(), 520, 250);
		renderbuttorlist(g);
	}

	@Override
	public void tick() {
		tickbuttonlist();
	}

}
