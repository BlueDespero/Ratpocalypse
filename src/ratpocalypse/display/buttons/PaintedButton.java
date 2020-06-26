package ratpocalypse.display.buttons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Function;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.CustomPaintedObject;

public class PaintedButton extends CustomPaintedObject {
	
	private String text;
	protected boolean selected;
	protected Function<Void, Void> f;
	
	public static final int DEFAULT_BUTTON_ROUNDNESS = 10;

	public PaintedButton(Handler handler, int x, int y, int width, int heigth, String text, Function<Void, Void> f) {
		super(handler, x, y, width, heigth);
		this.text=text;
		this.f=f;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRoundRect(x, y, width, heigth, DEFAULT_BUTTON_ROUNDNESS, DEFAULT_BUTTON_ROUNDNESS);
		g.setColor(Color.black);
		g.drawString(text, (int) (x+(width - g.getFontMetrics().stringWidth(text))*0.5 ), (int) (y + 0.5*heigth));
	}

	public void functionality() {
		selected = false;
		f.apply(null);
	}
	
	@Override
	public void tick() {
		if(selected)
			functionality();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
