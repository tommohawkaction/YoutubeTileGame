package entity;

import java.awt.Graphics;

public interface EntityInterface {

	public void render(Graphics g);
	public void tick(double delta);
}
