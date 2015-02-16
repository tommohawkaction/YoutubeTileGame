package entity;

import gfx.Texture;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import math.Vector2f;
import camera.Camera;

public class Player extends Entity{

	private Texture texture = null;
	
	public Player(Texture texture,float x, float y, float width, float height, Vector2f velocity) {
		super(x, y, width, height,velocity);
		this.texture = texture;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture.getImage(), (int)(x-Camera.getX()), (int)(y-Camera.getY()), (int)width, (int)height, null);
	}

	@Override
	public void tick(double delta) {
		Camera.setPosition(this);
		updatePosition(delta);
		
	}
	private void updatePosition(double delta){
		x += delta * velocity.getX();
		y += delta * velocity.getY();
	}
	public void pressedKeys(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_A: velocity.setX(-2f);
			break;
		case KeyEvent.VK_D: velocity.setX(2f);
			break;
		case KeyEvent.VK_W: velocity.setY(-2f);
			break;
		case KeyEvent.VK_S:velocity.setY(2f);
		}
	}
	public void releasedKeys(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_A: velocity.setX(0);
			break;
		case KeyEvent.VK_D: velocity.setX(0);
			break;
		case KeyEvent.VK_W: velocity.setY(0);
			break;
		case KeyEvent.VK_S:velocity.setY(0);
		}
		
	}

}
