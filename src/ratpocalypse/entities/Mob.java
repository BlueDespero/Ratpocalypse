package ratpocalypse.entities;

import ratpocalypse.backend.Handler;

public abstract class Mob extends Entity {

	protected float attack_speed;
	protected String name;
	protected float readyToAttack;
	protected int id, value;
	
	public abstract void attack();
	
	public static final int DEFAULT_HEALTH = 10;
	
	public Mob(float y, Handler handler) {
		super(y, handler);
		this.hp=DEFAULT_HEALTH;
	}
		
	protected void die()
	{
		if (this.hp<=0)
			this.alive=false;
	}

	public float getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(float attack_speed) {
		this.attack_speed = attack_speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
