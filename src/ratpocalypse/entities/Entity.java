package ratpocalypse.entities;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;

public abstract class Entity {

	protected static Handler handler;
	protected float x,y;
	protected float width,height, speed;
	protected boolean alive;
	protected int faction, hp, damage;
	public static final int DEFAULT_ENTITY_HEIGHT = 128,
							DEFAULT_ENTITY_WIDTH = 128;
	
	public Entity(float y, Handler handler) {
		Entity.handler = handler;
		this.width=DEFAULT_ENTITY_WIDTH;
		this.height=DEFAULT_ENTITY_HEIGHT;
		this.y=y*DEFAULT_ENTITY_HEIGHT;
		this.alive = true;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void harm(int dmg)
	{
		this.hp-=dmg;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getFaction() {
		return faction;
	}

	public void setFaction(int faction) {
		this.faction = faction;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
