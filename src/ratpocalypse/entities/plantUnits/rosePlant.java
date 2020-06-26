package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class rosePlant extends Plant {

	public rosePlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.rosePlant;
		this.hp = 10;
		this.attack_speed = 10;
		this.damage = 8;
		this.id = 8;
		this.value = 400;
	}

}
