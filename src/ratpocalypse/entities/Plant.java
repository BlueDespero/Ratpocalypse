package ratpocalypse.entities;

import java.awt.Graphics;
import java.awt.Image;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.TransparentTile;

public class Plant extends Mob {

	public static final int DEFAULT_PLANT_SPEED = 0;

	protected Image texture;
	protected TransparentTile place;
	
	public Plant(float x, float y, Handler handler, TransparentTile place) {
		super(y, handler);
		this.x=(x*128)+DEFAULT_ENTITY_WIDTH;
		this.speed = DEFAULT_PLANT_SPEED;
		this.faction = 1;
		this.place=place;
		this.value=100;
		this.attack_speed=2;
		this.damage = 5;
		this.hp = 50;
	}

	public void tick() {
		die();
		x+=this.speed;
		attack();
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) (x-DEFAULT_ENTITY_WIDTH), (int) y, (int) width, (int) height, null);
	}

	@Override
	protected void die() {
		if (this.hp<=0 || this.x>=1152)
		{
			this.alive=false;
			place.setFull(false);
		}
	}
	
	@Override
	public void attack() {
		
		Entity aux = handler.getGame().getEntityManager().findcollidorPlants(this);
		if(readyToAttack>=100 && aux == null)
		{
			this.readyToAttack=0;
			handler.getGame().getEntityManager().addFutureEntity(new Bullet(x, y, handler, damage));
		}
		else if (readyToAttack>=100 && aux != null)
		{
			this.readyToAttack=0;
			aux.harm(this.damage);
		}
		else
			this.readyToAttack+=this.attack_speed;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

}
