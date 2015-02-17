package entity.tiles;

import java.awt.Graphics;

import camera.Camera;


public class MasterTile {

	private Tile bottom,top;
	private TileInfo tileInfo;
	
	public MasterTile(Tile bottom,Tile top,TileInfo tileInfo) {
		this.bottom = bottom;
		this.top = top;
		this.tileInfo = tileInfo;
	}
	public MasterTile(Tile bottom,TileInfo tileInfo) {
		this.bottom = bottom;
		top = null;
		this.tileInfo = tileInfo;
	}
	public void render(Graphics g){
		if(bottom != null)bottom.render(g, tileInfo.getX()-Camera.getX(), tileInfo.getY()-Camera.getY(), tileInfo.getSize());
		if(top != null)top.render(g, tileInfo.getX()-Camera.getX(), tileInfo.getY()-Camera.getY(), tileInfo.getSize());
	}
	public void tick(double delta){
		if(bottom != null)bottom.tick(delta);
		if(top != null)top.tick(delta);
	}
	public Tile getBottom() {
		return bottom;
	}
	public void setBottom(Tile bottom) {
		this.bottom = bottom;
	}
	public Tile getTop() {
		return top;
	}
	public void setTop(Tile top) {
		this.top = top;
	}
	public TileInfo getTileInfo() {
		return tileInfo;
	}
	public void setTileInfo(TileInfo tileInfo) {
		this.tileInfo = tileInfo;
	}
	
	

}
