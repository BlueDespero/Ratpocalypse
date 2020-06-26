package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class palmPlant extends Plant {

	public palmPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.palmPlant;
		this.hp = 400;
		this.attack_speed = 0;
		this.damage = 0;
		this.id = 7;
		}

}
