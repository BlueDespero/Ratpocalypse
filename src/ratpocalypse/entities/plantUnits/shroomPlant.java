package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Entity;
import ratpocalypse.entities.Plant;

public class shroomPlant extends Plant {

	public shroomPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.shroomPlant;
		this.hp = 50;
		this.attack_speed = 10;
		this.damage = 25;
		this.speed = 5;
		this.id = 6;
		this.value=75;
	}

	@Override
	public void attack() {
		this.readyToAttack+=this.attack_speed;
		Entity aux = handler.getGame().getEntityManager().findcollidor(this);
		if (aux!=null)
		{
			if(readyToAttack>=100)
			{
				aux.harm(this.damage);
				readyToAttack=0;
			}
		}
	}
	
}
