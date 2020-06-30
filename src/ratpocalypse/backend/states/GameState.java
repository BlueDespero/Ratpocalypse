package ratpocalypse.backend.states;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.Area;
import ratpocalypse.display.areas.GameArea;
import ratpocalypse.display.areas.SelectionArea;
import ratpocalypse.display.gfx.Assets;

public class GameState extends State {
	
	private Area gameArea;
	private Area selectionArea;
	private int counter, timer;
		
	public GameState(Handler handler) {
		super(handler);
		handler.getGame().getEntityManager().clearentities();
		this.gameArea = new GameArea(handler);
		this.selectionArea = new SelectionArea(handler);
		this.counter=0;
		this.timer=180;
	}
	
	@Override
	public void OnClick(int MouseX, int MouseY) {
		selectionArea.onClick(MouseX, MouseY);
		gameArea.onClick(MouseX, MouseY);
	}
	
	private void generateRat() {
		if(timer%4 == 0)
		{
			int id = (int)(1 + Math.random()*8);
			int auxy = (int)(Math.random()*4);
			handler.getGame().getEntityManager().addEntity(
					handler.getGame().getEntityManager().createEntity(0, id, 1152, auxy, null)
					);
		}
	}
	
	public void tick() {
		handler.getGame().setStateName("game");
		handler.getGame().getEntityManager().fflushfutureentities();
		handler.getGame().getEntityManager().getEntities().removeIf(n -> (n.isAlive()==false));
		handler.getGame().getEntityManager().tick();
		selectionArea.tick();
		gameArea.tick();
		counter+=1;
		if (counter==60) {
			if(GameVariableManager.yellowRoses<=0)
				StateMenager.setState("lose");
			GameVariableManager.yellowRoses+=(11-GameVariableManager.getDifficulty());
			counter = 0;
			generateRat();
			for (int i = 0; i < (GameVariableManager.getDifficulty()/4); i++)
				generateRat();
			timer--;
			if(timer==0)
				StateMenager.setState("win");
		}
	}

	private void rendertimer(Graphics g) {
		int minutes = timer/60;
		int sec = timer%60;
		g.setColor(Color.yellow);
		String aux = minutes+":";
		if (sec<10) {
			aux+="0";
		}
		aux+=sec;
		g.drawString(aux,
				(int) (handler.getGame().getWidth()/2), 
				10);
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.standardBackground, 0*renderUnitWidth, 0*renderUnitHeight, null);
		handler.getGame().getEntityManager().render(g);
		selectionArea.render(g);
		rendertimer(g);
		gameArea.render(g);
	}

	public  Area getGameArea() {
		return gameArea;
	}

	public  void setGameArea(Area gameArea) {
		this.gameArea = gameArea;
	}

	public  Area getSelectionArea() {
		return selectionArea;
	}

	public  void setSelectionArea(Area selectionArea) {
		this.selectionArea = selectionArea;
	}

}
