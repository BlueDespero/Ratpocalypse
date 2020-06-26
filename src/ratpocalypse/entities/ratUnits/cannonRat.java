package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class cannonRat extends Rat {

	public cannonRat(float y, Handler handler) {
		super(y, handler);
		this.texture=Assets.cannonRat;
		this.hp = 10;
		this.speed = 1;
		this.damage = 10;
		this.value = 20;
	}

}
