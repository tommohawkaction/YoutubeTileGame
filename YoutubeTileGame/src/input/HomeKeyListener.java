package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.EntityHandler;
import entity.Player;

public class HomeKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		Player p = (Player)EntityHandler.getEntitys().get(0);
		p.pressedKeys(e);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Player p = (Player)EntityHandler.getEntitys().get(0);
		p.releasedKeys(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

}
