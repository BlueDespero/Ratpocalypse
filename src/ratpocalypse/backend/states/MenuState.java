package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.Area;
import ratpocalypse.display.areas.MenuArea;
import ratpocalypse.display.gfx.Assets;

public class MenuState extends State {

	private Area menuArea;
	
	public MenuState(Handler handler) {
		super(handler);
		menuArea = new MenuArea(handler);
	}

	public void tick() {
		handler.getGame().setStateName("menu");
		menuArea.tick();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.mainBackground, 0, 0, null);
		menuArea.render(g);
	}
	
	@Override
	public void OnClick(int MouseX, int MouseY) {
		menuArea.onClick(MouseX, MouseY);
	}

	public Area getMenuArea() {
		return menuArea;
	}

	public void setMenuArea(Area menuArea) {
		this.menuArea = menuArea;
	}

}
