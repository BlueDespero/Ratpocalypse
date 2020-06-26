package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class barbarianRat extends Rat {

	public barbarianRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.barbarianRat;
		this.damage = 40;
		this.attack_speed = 2;
		this.value = 30;
	}

}
