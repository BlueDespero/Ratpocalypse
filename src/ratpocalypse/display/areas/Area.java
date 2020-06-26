package ratpocalypse.display.areas;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.function.Function;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.PaintedButton;

public abstract class Area {
	protected static Handler handler;
	protected ArrayList<PaintedButton> buttonlist;
	protected static final int DEFAULT_BUTTON_WIDTH = 200;
	protected static final int DEFAULT_BUTTON_HEIGTH = 50;
	protected static int DEFAULT_MIDDLE_WIDTH;
	protected static int DEFAULT_MIDDLE_HEIGTH;
	
	public Area(Handler handler) {
		Area.handler = handler;
		Area.DEFAULT_MIDDLE_HEIGTH = (int) ((handler.getGame().getHeight()-DEFAULT_BUTTON_HEIGTH)*0.5);
		Area.DEFAULT_MIDDLE_WIDTH = (int) ((handler.getGame().getWidth()-DEFAULT_BUTTON_WIDTH)*0.5);
		this.buttonlist = new ArrayList<PaintedButton>();
	}
	
	public void onClick(int x, int y)
	{
		for (PaintedButton paintedButton : buttonlist) {
			Rectangle aux = new Rectangle(paintedButton.getX(), paintedButton.getY(), paintedButton.getWidth(), paintedButton.getHeigth());
			if(aux.contains(x, y))
				paintedButton.setSelected(true);
		}
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	protected PaintedButton createDefaultButton(String text, int heigth, Function<Void, Void> f){
		PaintedButton out = new PaintedButton(handler, DEFAULT_MIDDLE_WIDTH, heigth, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGTH, text, f);
		return out;
	}
	
	protected void tickbuttonlist()
	{
		for (PaintedButton paintedButton : buttonlist) {
			paintedButton.tick();
		}
	}
	
	protected void renderbuttorlist(Graphics g) {
		for (PaintedButton paintedButton : buttonlist) {
			paintedButton.render(g);
		}
	}

	public ArrayList<PaintedButton> getButtonlist() {
		return buttonlist;
	}

	public void setButtonlist(ArrayList<PaintedButton> buttonlist) {
		this.buttonlist = buttonlist;
	}
	
}
