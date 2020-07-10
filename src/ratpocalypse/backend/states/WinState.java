package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.Area;
import ratpocalypse.display.areas.WinArea;
import ratpocalypse.display.gfx.Assets;

public class WinState extends State {
	private int timer, counter;
	private Area winArea;

	public WinState(Handler handler) {
		super(handler);
		winArea = new WinArea(handler);
		this.timer = 7;
		this.counter = 0;
		handler.getGame().setStateName("win");
	}

	@Override
	public void tick() {
		winArea.tick();
		counter++;
		if(counter>=60)
		{
			counter=0;
			timer--;
			if(timer==0)
				StateManager.setState("menu");
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.winBackground, 0, 0, null);
		winArea.render(g);
	}

	@Override
	public void OnClick(int MouseX, int MouseY) {
		winArea.onClick(MouseX, MouseY);
	}
}
