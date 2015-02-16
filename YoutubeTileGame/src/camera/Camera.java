package camera;

import java.awt.event.KeyEvent;

import window.MasterCanvas;
import entity.Entity;

public class Camera {

	private static int x, y;
	private static int speedX, speedY;

	public static void setPosition(int x, int y) {
		Camera.x = x;
		Camera.y = y;
	}

	public static void setPosition(Entity e){
		setX((int) e.getX()-MasterCanvas.WIDTH/2);
		setY((int) e.getY()-MasterCanvas.HEIGHT/2);
	}
	public static void pressedCamera(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: speedX = -5;
			break;
		case KeyEvent.VK_RIGHT: speedX = 5;
			break;
		case KeyEvent.VK_UP: speedY = -5;
			break;
		case KeyEvent.VK_DOWN:speedY = 5;
		}
	}
	public static void releasedCamera(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: speedX = 0;
			break;
		case KeyEvent.VK_RIGHT: speedX = 0;
			break;
		case KeyEvent.VK_UP: speedY = 0;
			break;
		case KeyEvent.VK_DOWN:speedY = 0;
		}
		
	}
	public static void update(){
		x += MasterCanvas.getDelta() * speedX;
		y += MasterCanvas.getDelta() * speedY;
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Camera.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Camera.y = y;
	}

	public static int getSpeedX() {
		return speedX;
	}

	public static void setSpeedX(int speedX) {
		Camera.speedX = speedX;
	}

	public static int getSpeedY() {
		return speedY;
	}

	public static void setSpeedY(int speedY) {
		Camera.speedY = speedY;
	}
	
}
