package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.Area;
import ratpocalypse.display.areas.SettingsArea;

public class SettingsState extends State {
	
	private Area settingsArea;
	
	public SettingsState(Handler handler) {
		super(handler);
		settingsArea = new SettingsArea(handler);
	}

	public void tick() {
		handler.getGame().setStateName("settings");
		settingsArea.tick();
	}

	public void render(Graphics g) {
		settingsArea.render(g);
	}

	@Override
	public void OnClick(int MouseX, int MouseY) {
		settingsArea.onClick(MouseX, MouseY);
	}
	
	public Area getSettingsArea() {
		return settingsArea;
	}

	public void setSettingsArea(Area settingsArea) {
		this.settingsArea = settingsArea;
	}
	
}
