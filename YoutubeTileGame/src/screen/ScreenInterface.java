package screen;

import java.awt.Graphics;

public interface ScreenInterface {

	public void tick(double delta);
	public void render(Graphics g);
}
