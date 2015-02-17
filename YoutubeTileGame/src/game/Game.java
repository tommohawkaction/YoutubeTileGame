package game;

import java.awt.Graphics;

import level.Level;
import screen.Screen;
import window.MasterCanvas;
import camera.Camera;
import entity.Entity;
import entity.EntityHandler;
import entity.Player;

public class Game extends Screen {

	public static Level level = new Level();

	public Game() {
		EntityHandler.addEntity(new Player(MasterCanvas.WIDTH/2-(40/2),MasterCanvas.HEIGHT/2-(40/2)));
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
		EntityHandler.render(g);
	}

	@Override
	public void tick(double delta) {
		Camera.setPosition(getPlayer());
		
		
		level.tick(delta);
		EntityHandler.tick(delta);
	}
	public static Player getPlayer(){
		for(int i = 0;i < EntityHandler.getEntitys().size();i++){
			Entity e = EntityHandler.getEntitys().get(i);
			if(e instanceof Player){
				Player p = (Player) e;
				return p;
			}
		}
		return null;
	}

	public static Level getLevel() {
		return level;
	}

	public static void setLevel(Level level) {
		Game.level = level;
	}
	

}
