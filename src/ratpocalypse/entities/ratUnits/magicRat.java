package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class magicRat extends Rat {

	public magicRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.magicRat;
		this.value = 40;
	}

}
