package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Plant;

public class oddishPlant extends Plant {

	public oddishPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.oddishPlant;
		this.hp = 50;
		this.attack_speed = 1;
		this.id = 5;
		this.value = 50;
	}

	@Override
	public void attack() {
		if(readyToAttack>=100)
		{
			this.readyToAttack=0;
			GameVariableManager.yellowRoses+=5;
		}
		else
		{
			this.readyToAttack+=this.attack_speed;
		}
	}
	
}
