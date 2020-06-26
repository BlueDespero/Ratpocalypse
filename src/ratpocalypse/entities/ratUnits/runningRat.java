package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class runningRat extends Rat {

	public runningRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.runningRat;
		this.speed = 2;
		this.value = 20;
	}

}
