package ratpocalypse.display;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;

public abstract class CustomPaintedObject {

	protected int x,y,width, heigth;
	protected Handler handler;
	
	public CustomPaintedObject(Handler handler, int x, int y, int width, int heigth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.heigth=heigth;
		this.handler=handler;
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
}
