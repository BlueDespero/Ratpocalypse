package ratpocalypse.entities.ratUnits;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.gfx.Assets;
import ratpocalypse.entities.Rat;

public class motherRat extends Rat {

	public motherRat(float y, Handler handler) {
		super(y, handler);
		this.texture = Assets.motherRat;
		this.hp = 100;
		this.speed = 1;
		this.damage = 30;
		this.value = 50;
	}

	@Override
	protected void die() {
		super.die();
		if(!alive)
		{
		handler.getGame().getEntityManager().addEntity(
				handler.getGame().getEntityManager().createEntity(0, 1, (int) this.x+30, (int) this.y/128, null)
				);
				System.out.println((int) this.x-30);
				System.out.println((int) this.y/128);
		handler.getGame().getEntityManager().addEntity(
				handler.getGame().getEntityManager().createEntity(0, 1, (int) this.x+60, (int) this.y/128, null)
				);
		handler.getGame().getEntityManager().addEntity(
				handler.getGame().getEntityManager().createEntity(0, 1, (int) this.x+90, (int) this.y/128, null)
				);
		}
	}
	
}
