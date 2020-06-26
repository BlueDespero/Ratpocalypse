package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;

public class WinState extends State {
	private int timer, counter;

	public WinState(Handler handler) {
		super(handler);
		this.timer = 7;
		this.counter = 0;
		handler.getGame().setStateName("win");
	}

	@Override
	public void tick() {
		counter++;
		if(counter>=60)
		{
			counter=0;
			timer--;
			if(timer==0)
				StateMenager.setState("menu");
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.winBackground, 0, 0, null);
	}

	@Override
	public void OnClick(int MouseX, int MouseY) {		
	}
}
