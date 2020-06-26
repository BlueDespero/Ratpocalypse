package ratpocalypse.display.buttons;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Function;

import ratpocalypse.backend.Handler;
import ratpocalypse.entities.Plant;

public class CreatureButton extends PaintedButton {
	Plant unit;
	
	public CreatureButton(Handler handler, int x, Function<Void, Void> f, Plant unit) {
		super(handler, x, 512, 128, 128, "", f);
		this.unit = unit;
	}
	
	public CreatureButton(Handler handler, int x, Plant unit) {
		super(handler, x, 512, 128, 128, "", ((Void) -> { handler.getGame().getGvmanager().selectedUnit = unit.getId() ;return null;} ) );
		this.unit = unit;
	}

	@Override
	public void render(Graphics g) {
		if(handler.getGame().getGvmanager().selectedUnit == unit.getId())
			g.setColor(Color.green);
		else 
			g.setColor(new Color(69, 137, 89));
		
		g.fillRect(x, y, width, heigth);
		g.setColor(Color.black);
		g.drawRect(x, y, width, heigth);
		g.drawImage(unit.getTexture(), x, y, null);
		g.setColor(Color.yellow);
		String aux = "Koszt: "+unit.getValue();
		g.drawString(aux, (int) (x+(width - g.getFontMetrics().stringWidth(aux))*0.5 ), (int) (y + heigth - 10));
	}
}
