package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;

public class LoseState extends State {
	private int timer, counter;
	
	public LoseState(Handler handler) {
		super(handler);
		this.timer = 7;
		this.counter = 0;
		GameVariableManager.yellowRoses=0;
		handler.getGame().setStateName("lose");
	}

	@Override
	public void tick() {
		counter++;
		if(counter>=60)
		{
			counter=0;
			timer--;
			if(timer==0)
				System.exit(0);
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.loseBackground, 0, 0, null);
	}

	@Override
	public void OnClick(int MouseX, int MouseY) {		
	}

}
