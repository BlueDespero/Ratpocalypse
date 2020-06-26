package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class armoredRat extends Rat {

	public armoredRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.armoredRat;
		this.hp = 80;
		this.value = 30;
		}

}
