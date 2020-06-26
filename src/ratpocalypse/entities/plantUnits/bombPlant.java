package ratpocalypse.entities.plantUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Entity;
import ratpocalypse.entities.Plant;

public class bombPlant extends Plant {

	public bombPlant(float x, float y, Handler handler, TransparentTile place) {
		super(x, y, handler, place);
		this.texture = Assets.bombPlant;
		this.hp = 50;
		this.attack_speed = 10;
		this.damage = 100;
		this.id = 4;
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
				this.alive=false;
				this.place.setFull(false);
			}
		}
	}
	
}
