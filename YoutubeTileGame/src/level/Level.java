package level;

import java.awt.Graphics;
import java.util.Random;

import window.MasterCanvas;
import camera.Camera;
import entity.tiles.Grass;
import entity.tiles.MasterTile;
import entity.tiles.TileInfo;
import entity.tiles.Tree;

public class Level {
	public static final int SCALE = 3;
	public static final int SIZE = 50;
	public static final int SEED = 255;

	private MasterTile[][] tiles;
	private int lengthX, lengthY;
	private Random r = new Random(SEED);

	public Level() {
		lengthX = (MasterCanvas.WIDTH / SIZE) * SCALE;
		lengthY = (MasterCanvas.HEIGHT / SIZE) * SCALE;

		tiles = new MasterTile[lengthX][lengthY];

		for (int x = 0; x < lengthX; x++) {
			for (int y = 0; y < lengthY; y++) {
				if (r.nextFloat() < 0.2f) {
					tiles[x][y] = new MasterTile(new Grass(), new Tree(), new TileInfo(x*SIZE, y*SIZE, SIZE));
				} else {
					tiles[x][y] = new MasterTile(new Grass(), new TileInfo(x*SIZE, y*SIZE, SIZE));
				}
			}
		}

	}
	public MasterTile getTile(int x,int y){
		return tiles[x][y];
	}

	public void render(Graphics g) {
		int cameraX = Camera.getX() / SIZE;
		int cameraY = Camera.getY() / SIZE;

		int cameraWidth = MasterCanvas.WIDTH / SIZE + 3;
		int cameraHeight = MasterCanvas.HEIGHT / SIZE + 3;

		if (cameraX < 0)
			cameraX = 0;
		if (cameraY < 0)
			cameraY = 0;

		if (cameraX > lengthX - cameraWidth)
			cameraX = lengthX - cameraWidth;
		if (cameraY > lengthY - cameraHeight)
			cameraY = lengthY - cameraHeight;

		for (int x = cameraX; x < cameraWidth + cameraX; x++) {
			for (int y = cameraY; y < cameraHeight + cameraY; y++) {
				tiles[x][y].render(g);
			}
		}
	}

	public void tick(double delta) {
		int cameraX = Camera.getX() / SIZE;
		int cameraY = Camera.getY() / SIZE;

		int cameraWidth = MasterCanvas.WIDTH / SIZE + 3;
		int cameraHeight = MasterCanvas.HEIGHT / SIZE + 3;

		if (cameraX < 0)
			cameraX = 0;
		if (cameraY < 0)
			cameraY = 0;

		if (cameraX > lengthX - cameraWidth)
			cameraX = lengthX - cameraWidth;
		if (cameraY > lengthY - cameraHeight)
			cameraY = lengthY - cameraHeight;

		for (int x = cameraX; x < cameraWidth + cameraX; x++) {
			for (int y = cameraY; y < cameraHeight + cameraY; y++) {
				tiles[x][y].tick(delta);
			}
		}
	}

	public MasterTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(MasterTile[][] tiles) {
		this.tiles = tiles;
	}

	public int getLengthX() {
		return lengthX;
	}

	public void setLengthX(int lengthX) {
		this.lengthX = lengthX;
	}

	public int getLengthY() {
		return lengthY;
	}

	public void setLengthY(int lengthY) {
		this.lengthY = lengthY;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}
	

}
