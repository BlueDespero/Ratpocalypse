package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Entity;
import ratpocalypse.entities.Plant;

public class bitingPlant extends Plant {

	public bitingPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.bitingPlant;
		this.id = 3;
		this.hp = 100;
		this.damage = 30;
		this.attack_speed=1;
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
