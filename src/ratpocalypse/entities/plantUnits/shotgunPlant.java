package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class shotgunPlant extends Plant {

	public shotgunPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture=Assets.shotgunPlant;
		this.id = 1;
		}

}
