package entity;

import gfx.Texture;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameActor extends Entity {

	public GameActor(Texture texture, float x, float y, float width, float height) {
		super(x, y, width, height);
		setTexture(texture);
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
	}

	@Override
	public void tick(double delta) {
		super.tick(delta);

	}

	public void pressedKeys(KeyEvent e) {
	}

	public void releasedKeys(KeyEvent e) {
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

}
