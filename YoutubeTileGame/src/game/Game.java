package game;

import java.awt.Graphics;

import level.Level;
import math.Vector2f;
import screen.Screen;
import window.MasterCanvas;
import entity.EntityHandler;
import entity.Player;
import gfx.Texture;

public class Game extends Screen {

	private Level level = new Level();

	public Game() {
		EntityHandler.addEntity(new Player(new Texture("Textures/player.png"),MasterCanvas.WIDTH/2-(40/2),MasterCanvas.HEIGHT/2-(50/2),40,50,new Vector2f()));
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
		EntityHandler.render(g);
	}

	@Override
	public void tick(double delta) {
		//Camera.update();
		level.tick(delta);
		EntityHandler.tick(delta);
	}

}
