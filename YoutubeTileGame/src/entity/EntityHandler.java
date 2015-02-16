package entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityHandler {

	private static ArrayList<Entity> entitys = new ArrayList<>();

	public static ArrayList<Entity> getEntitys() {
		return entitys;
	}

	public static void setEntitys(ArrayList<Entity> entitys) {
		EntityHandler.entitys = entitys;
	}
	public static void addEntity(Entity e){
		entitys.add(e);
	}
	public static void removeEntity(Entity e){
		entitys.remove(e);
	}
	public static void removeAll(){
		entitys.removeAll(entitys);
	}
	public static void render(Graphics g){
		for(Entity e : entitys){
			e.render(g);
		}
	}
	public static void tick(double delta){
		for(Entity e : entitys){
			e.tick(delta);
		}
	}
	
}
