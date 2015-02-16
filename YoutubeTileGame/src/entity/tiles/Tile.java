package entity.tiles;

import java.awt.Graphics;

import files.Assets;

public class Tile {

	private String name;
	
	public Tile(String name) {
		this.name = name;
	}
	public void render(Graphics g,int x,int y,int size){
		g.drawImage(Assets.mainSheet.getImage(name), x, y, size, size,null);
	}
	public void tick(double delta){
		
	}
	
}
