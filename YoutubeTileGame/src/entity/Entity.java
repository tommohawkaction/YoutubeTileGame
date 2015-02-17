package entity;

import game.Game;
import gfx.Texture;

import java.awt.Graphics;
import java.awt.Rectangle;

import level.Level;
import math.Vector2f;
import camera.Camera;

public abstract class Entity implements EntityInterface {

	protected Rectangle boundArea;
	protected float x, y, width, height;
	protected Vector2f velocity;
	protected Texture texture;
	protected float oldX, oldY;

	public Entity(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		boundArea = new Rectangle((int) x, (int) y, (int) width, (int) height);
		velocity = new Vector2f();
	}

	public Entity(float x, float y, float width, float height, Vector2f velocity) {
		this(x, y, width, height);
		this.velocity = velocity;
	}

	public Rectangle getBoundArea() {
		return boundArea;
	}

	private void updatePosition(double delta) {
		x += delta * velocity.getX();
		y += delta * velocity.getY();
	}

	@Override
	public void tick(double delta) {

		setOldX(getX());
		setOldY(getY());
		// -----------------
		updatePosition(delta);
		// --COLLISION-UNDER-HERE----
		updateCollision();

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getTexture().getImage(), (int) (x - Camera.getX()), (int) (y - Camera.getY()), (int) width, (int) height, null);

	}

	protected void updateCollision() {
		boolean collisionX = false;
		boolean collisionY = false;
		int cellX = (int) (getX() / Level.SIZE);
		int cellY = (int) (getY() / Level.SIZE);

		if (cellX < 0 || cellY < 0 || cellX >= Game.level.getLengthX()-1 || cellY > Game.level.getLengthY()-1)
			return;

		// X
		if (getVelocity().getX() < 0) {
			// TOP LEFT
			collisionX = checkCollision(getX(), getY() + getHeight() -5);

			// MIDDLE LEFT
			collisionX |= checkCollision(getX(), getY() + (getHeight() / 2));

			// BOTTOM LEFT
			collisionX |= checkCollision(getX() +5, getY());

		} else if (getVelocity().getX() > 0) {
			// TOP RIGHT
			collisionX = checkCollision(getX() + getWidth(), getY() + getHeight() -5);

			// MIDDLE RIGHT
			collisionX |= checkCollision(getX() + getWidth(), getY() + (getHeight() / 2));

			// BOTTOM RIGHT
			collisionX |= checkCollision(getX() + getWidth(), getY() +5);
		}
		if (collisionX) {
			getVelocity().setX(0);
			setX(getOldX());
		}

		// Y
		if (getVelocity().getY() < 0) {
			// BOTTOM LEFT
			collisionY = checkCollision(getX()+5, getY());

			// BOTTOM MIDDLE
			collisionY |= checkCollision(getX() + (getWidth() / 2), getY());

			// BOTTOM RIGHT
			collisionY |= checkCollision(getX() + getWidth()-5, getY());

		} else if (getVelocity().getY() > 0) {
			// TOP LEFT
			collisionY = checkCollision(getX(), getY() + getHeight());

			// TOP MIDDLE
			collisionY |= checkCollision(getX() + (getWidth() / 2), getY() + getHeight());

			// TOP RIGHT
			collisionY |= checkCollision(getX() + getWidth(), getY() + getHeight());

		}
		if (collisionY) {
			getVelocity().setY(0);
			setY(getOldY());
		}

	}

	protected boolean checkCollision(float x, float y) {
		if (Game.level.getTile((int) (x / Level.SIZE), (int) (y / Level.SIZE)).getTop() != null) {
			return true;
		}
		return false;
	}

	public void setBoundArea(Rectangle boundArea) {
		this.boundArea = boundArea;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public float getOldX() {
		return oldX;
	}

	public void setOldX(float oldX) {
		this.oldX = oldX;
	}

	public float getOldY() {
		return oldY;
	}

	public void setOldY(float oldY) {
		this.oldY = oldY;
	}

}
