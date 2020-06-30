package ratpocalypse.backend.states;

import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.Area;
import ratpocalypse.display.areas.LoseArea;
import ratpocalypse.display.gfx.Assets;

public class LoseState extends State {
	private int timer, counter;
	private Area loseArea;
	
	public LoseState(Handler handler) {
		super(handler);
		loseArea = new LoseArea(handler);
		this.timer = 7;
		this.counter = 0;
		GameVariableManager.setYellowRoses(200);;
		handler.getGame().setStateName("lose");
	}

	@Override
	public void tick() {
		loseArea.tick();
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
		loseArea.render(g);
	}

	@Override
	public void OnClick(int MouseX, int MouseY) {
		loseArea.onClick(MouseX, MouseY);
	}

}
