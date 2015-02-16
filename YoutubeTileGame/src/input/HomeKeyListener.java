package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import camera.Camera;
import entity.EntityHandler;
import entity.Player;

public class HomeKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		Camera.pressedCamera(e);
		
		Player p = (Player)EntityHandler.getEntitys().get(0);
		p.pressedKeys(e);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Camera.releasedCamera(e);
		Player p = (Player)EntityHandler.getEntitys().get(0);
		p.releasedKeys(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

}
