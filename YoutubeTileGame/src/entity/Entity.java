package entity;

import java.awt.Rectangle;

import math.Vector2f;

public abstract class Entity implements EntityInterface{

	protected Rectangle boundArea;
	protected float x,y,width,height;
	protected Vector2f velocity;
	
	public Entity(float x,float y,float width,float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		boundArea = new Rectangle((int)x,(int)y,(int)width,(int)height);
		velocity = new Vector2f(x, y);
	}
	public Entity(float x,float y,float width,float height,Vector2f velocity){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		boundArea = new Rectangle((int)x,(int)y,(int)width,(int)height);
		this.velocity = velocity;
	}

	public Rectangle getBoundArea() {
		return boundArea;
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

	
}
