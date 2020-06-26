package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class bomberRat extends Rat {

	public bomberRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.bomberRat;
		this.value = 20;
	}
	
}
