package ratpocalypse.display.buttons;

import java.awt.Graphics;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.entities.Mob;

public class TransparentTile extends PaintedButton {
	private int unitX, unitY;
	private boolean full;
	
	public TransparentTile(Handler handler, int x, int y) {
		super(handler, x*128, y*128, 128, 128, "", ( (Void) -> {return null;} ));
		this.unitX = x;
		this.unitY = y;
	}
	
	@Override
	public void functionality() {
		if(!this.full && handler.getGame().getGvmanager().selectedUnit!=0)
		{
			Mob aux = handler.getGame().getEntityManager().createEntity(
					1,
					handler.getGame().getGvmanager().selectedUnit,
					unitX,
					unitY,
					this);
			handler.getGame().getGvmanager();
			if (GameVariableManager.yellowRoses>aux.getValue())
			{
				handler.getGame().getEntityManager().addEntity(aux);
				handler.getGame().getGvmanager();
				GameVariableManager.yellowRoses-=aux.getValue();
				full=true;
			}
		}
		else if (full) {
			System.out.println("FULL!");
		}
		selected=false;
	}
	
	@Override
	public void render(Graphics g) {
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

}
