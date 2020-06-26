package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;

public abstract class State {
	
	protected static int renderUnitWidth = 128;
	protected static int renderUnitHeight = 128;
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler=handler;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void OnClick(int MouseX, int MouseY);
}
