package ratpocalypse.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ratpocalypse.backend.GameVariableManager;
import ratpocalypse.backend.Handler;

public class Rat extends Mob {
	
	protected BufferedImage texture;
	
	public static final int DEFAULT_RAT_SPEED = 1;
	
	public Rat(float y, Handler handler) {
		super(y, handler);
		this.x=1152;
		this.speed=DEFAULT_RAT_SPEED;
		this.faction = 0;
		this.hp = 30;
		this.speed = 1;
		this.damage = 20;
		this.attack_speed=1;
	}

	public void tick() {
		die();
		attack();
	}

	@Override
	protected void die() {
		super.die();
		if(!alive) {
			GameVariableManager.yellowRoses+=this.value;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, (int) width, (int) height, null);
	}

	public void attack() {
			this.readyToAttack+=this.attack_speed;
			Entity aux = handler.getGame().getEntityManager().findcollidor(this);
			if(x>=0 && aux==null)
				x-=this.speed;
			else if (aux!=null && readyToAttack>=100)
			{
					aux.harm(this.damage);
					readyToAttack=0;
			}
			else if(readyToAttack>=100)
			{
				GameVariableManager.yellowRoses-=(damage);
				readyToAttack=0;
			}
	}
	
	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	
}
