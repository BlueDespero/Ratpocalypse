package ratpocalypse.backend;

import java.awt.Graphics;
import java.util.ArrayList;

import ratpocalypse.display.buttons.TransparentTile;
import ratpocalypse.entities.Entity;
import ratpocalypse.entities.Mob;
import ratpocalypse.entities.plantUnits.bitingPlant;
import ratpocalypse.entities.plantUnits.bombPlant;
import ratpocalypse.entities.plantUnits.oddishPlant;
import ratpocalypse.entities.plantUnits.palmPlant;
import ratpocalypse.entities.plantUnits.rosePlant;
import ratpocalypse.entities.plantUnits.roseShinyPlant;
import ratpocalypse.entities.plantUnits.shotgunPlant;
import ratpocalypse.entities.plantUnits.shroomPlant;
import ratpocalypse.entities.plantUnits.uziPlant;
import ratpocalypse.entities.ratUnits.armoredRat;
import ratpocalypse.entities.ratUnits.barbarianRat;
import ratpocalypse.entities.ratUnits.basicRat;
import ratpocalypse.entities.ratUnits.bomberRat;
import ratpocalypse.entities.ratUnits.cannonRat;
import ratpocalypse.entities.ratUnits.magicRat;
import ratpocalypse.entities.ratUnits.motherRat;
import ratpocalypse.entities.ratUnits.runningRat;

public class EntityManager {

	private ArrayList<Entity> entities;
	private ArrayList<Entity> futureentities;
	private Handler handler;
	
	public EntityManager(Handler handler) {
		entities = new ArrayList<Entity>();
		futureentities = new ArrayList<Entity>();
		this.handler = handler;
	}
	
	public void clearentities()
	{
		entities.clear();
		futureentities.clear();
	}
	
	public boolean collisionpair(Entity a, Entity b)
	{
		if(a.getY()==b.getY() && (Math.abs(a.getX()-b.getX()) <= (a.getSpeed()+b.getSpeed()) ) )
			return true;
		return false;
	}
	
	public boolean checkforcollision(Entity e)
	{
		for (Entity entity : entities) {
			if (e == entity)
				continue;
			if(collisionpair(entity, e))
				return true;
		}
		return false;
	}
	
	public boolean collisionpairPlants(Entity a, Entity b)
	{
		if(a.getY()==b.getY() && (Math.abs(a.getX()-(b.getX()-128)) <= (a.getSpeed()+b.getSpeed()) ) )
			return true;
		return false;
	}
	
	public boolean checkforcollisionPlants(Entity e)
	{
		for (Entity entity : entities) {
			if (e == entity)
				continue;
			if(collisionpairPlants(entity, e))
				return true;
		}
		return false;
	}
	
	public Entity findcollidorPlants(Entity e)
	{
		for (Entity entity : entities) {
			if (e.getFaction() == entity.getFaction())
				continue;
			if(collisionpairPlants(entity, e))
				return entity;
		}
		return null;
	}
	
	public Entity findcollidor(Entity e)
	{
		for (Entity entity : entities) {
			if (e.getFaction() == entity.getFaction())
				continue;
			if(collisionpair(entity, e))
				return entity;
		}
		return null;
	}
	
	public void tick() {
		for(int i = 0; i<entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g){
		for (Entity entity : entities) {
			entity.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addFutureEntity(Entity e) {
		futureentities.add(e);
	}
	
	public void fflushfutureentities(){
		entities.addAll(futureentities);
		futureentities.clear();
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public Mob createEntity(int faction, int id, int x, int y, TransparentTile tile)
	{
		if (faction == 1) {
			
			switch (id) {
			case 1:
					return new shotgunPlant(x, y, handler, tile);				
			case 2:
					return new uziPlant(x, y, handler, tile);
			case 3:
					return new bitingPlant(x, y, handler, tile);
			case 4:
					return new bombPlant(x, y, handler, tile);
			case 5:
					return new oddishPlant(x, y, handler, tile);
			case 6:
					return new shroomPlant(x, y, handler, tile);
			case 7:
					return new palmPlant(x, y, handler, tile);
			case 8:
					return new rosePlant(x, y, handler, tile);
			case 9:
					return new roseShinyPlant(x, y, handler, tile);
				
			default:
				break;
			}
			
		}
		else {
			switch (id) {
			case 1:
					return new basicRat(y, x, handler);				
			case 2:
					return new armoredRat(y, handler);
			case 3:
					return new barbarianRat(y, handler);
			case 4:
					return new cannonRat(y, handler);
			case 5:
					return new magicRat(y, handler);
			case 6:
					return new bomberRat(y, handler);
			case 7:
					return new runningRat(y, handler);
			case 8:
					return new motherRat(y, handler);
				
			default:
				break;
			}		}
		return null;
	}
}
