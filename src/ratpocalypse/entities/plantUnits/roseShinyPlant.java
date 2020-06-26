package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class roseShinyPlant extends Plant {

	public roseShinyPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.roseShinyPlant;
		this.hp = 1;
		this.attack_speed = 11;
		this.damage = 10;
		this.id = 9;
		this.value = 600;
	}

}
