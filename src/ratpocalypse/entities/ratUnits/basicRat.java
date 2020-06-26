package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class basicRat extends Rat {

	public basicRat(float y, Handler handler) {
		this(y, 1152, handler);
	}
	
	public basicRat(float y, int x, Handler handler) {
		super(y, handler);
		this.x = x;
		this.texture = Assets.basicRat;
		this.value = 10;
	}

}
