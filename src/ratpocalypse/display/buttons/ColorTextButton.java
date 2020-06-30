package ratpocalypse.display.buttons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Function;

import ratpocalypse.backend.Handler;

public class ColorTextButton extends PaintedButton {

	private Color buttonColor, textColor;
	public ColorTextButton(Handler handler, int x, int y, int width, int heigth, String text, Function<Void, Void> f, Color buttonColor, Color textColor) {
		super(handler, x, y, width, heigth, text, f);
		this.buttonColor=buttonColor;
		this.textColor=textColor;
	}
	
	public ColorTextButton(Handler handler, int x, int y, int width, int heigth, String text, Function<Void, Void> f) {
		this(handler, x, y, width, heigth, text, f, Color.green, Color.black);
	}
	
	public ColorTextButton(Handler handler, int x, int y, String text, Function<Void, Void> f) {
		this(handler, x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGTH, text, f, Color.green, Color.black);
	}
	
	public ColorTextButton(Handler handler, int x, int y, String text, Function<Void, Void> f, Color buttonColor, Color textColor) {
		this(handler, x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGTH, text, f, buttonColor, textColor);
	}
	
	public ColorTextButton(Handler handler, int y, String text, Function<Void, Void> f) {
		this(handler, DEFAULT_MIDDLE_WIDTH, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGTH, text, f, Color.green, Color.black);
	}
	
	public ColorTextButton(Handler handler, int y, String text, Function<Void, Void> f, Color buttonColor, Color textColor) {
		this(handler, DEFAULT_MIDDLE_WIDTH, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGTH, text, f, buttonColor, textColor);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(buttonColor);
		g.fillRoundRect(x, y, width, heigth, DEFAULT_BUTTON_ROUNDNESS, DEFAULT_BUTTON_ROUNDNESS);
		g.setColor(textColor);
		g.drawString(text, (int) (x+(width - g.getFontMetrics().stringWidth(text))*0.5 ), (int) (y + 0.5*heigth));
	}
	
	public Color getButtonColor() {
		return buttonColor;
	}
	public void setButtonColor(Color buttonColor) {
		this.buttonColor = buttonColor;
	}	
}
