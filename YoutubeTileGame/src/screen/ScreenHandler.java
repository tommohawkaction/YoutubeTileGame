package screen;

import java.awt.Graphics;

public class ScreenHandler {

	private static Screen activeScreen = null;
	
	public static void tick(double delta){
		if(activeScreen != null)activeScreen.tick(delta);
	}
	
	public static void render(Graphics g){
		if(activeScreen != null)activeScreen.render(g);
	}
	public static void setScreen(Screen screen){
		activeScreen = screen;
	}
}
