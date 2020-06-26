package ratpocalypse.entities;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.Handler;

public class Bullet extends Entity {

	public final static Color DEFAULT_BULLET_COLOR = Color.red;
	public final static int DEFAULT_BULLET_SIZE = 10;
	public final static int DEFAULT_BULLET_OFFSET = (int) ((0.5*DEFAULT_ENTITY_HEIGHT)-(0.5*DEFAULT_BULLET_SIZE));
	
	public Bullet(float x, float y, Handler handler, int damage) {
		super(0, handler);
		this.y=y;
		this.x = x;
		this.damage=damage;
		this.speed=5;
		this.alive=true;
		this.faction = 1;
	}

	@Override
	public void tick() {
		Entity e = handler.getGame().getEntityManager().findcollidor(this);
		if (e == null)
			this.x+=speed;
		else
		{
			alive=false;
			e.harm(damage);
		}
		
		if(x>=handler.getGame().getWidth())
			alive=false;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(DEFAULT_BULLET_COLOR);
		g.fillOval( (int) x, (int) (y+DEFAULT_BULLET_OFFSET), DEFAULT_BULLET_SIZE, DEFAULT_BULLET_SIZE);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
