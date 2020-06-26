package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class uziPlant extends Plant {

	public uziPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture=Assets.uziPlant;
		this.id = 2;
		this.attack_speed=4;
		this.damage = 4;
		this.value = 150;
	}

}
