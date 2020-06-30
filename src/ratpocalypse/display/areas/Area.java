package ratpocalypse.display.areas;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.PaintedButton;

public abstract class Area {
	protected static Handler handler;
	protected ArrayList<PaintedButton> buttonlist;

	
	public Area(Handler handler) {
		Area.handler = handler;
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
