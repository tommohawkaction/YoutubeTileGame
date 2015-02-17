package entity;

import gfx.Texture;

import java.awt.event.KeyEvent;

public class Player extends GameActor{

	
	public Player(float x, float y) {
		super(new Texture("Textures/player.png"),x, y, 40,40);
	}


	@Override
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
	@Override
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
