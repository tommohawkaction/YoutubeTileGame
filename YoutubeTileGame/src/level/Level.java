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

	private MasterTile[][] tiles;
	private static final int size = 50;
	private int lengthX, lengthY;
	private static final int scale = 3;
	private Random r = new Random();

	public Level() {
		lengthX = (MasterCanvas.WIDTH / size) * scale;
		lengthY = (MasterCanvas.HEIGHT / size) * scale;

		tiles = new MasterTile[lengthX][lengthY];

		for (int x = 0; x < lengthX; x++) {
			for (int y = 0; y < lengthY; y++) {
				if (r.nextFloat() < 0.2f) {
					tiles[x][y] = new MasterTile(new Grass(), new Tree(), new TileInfo(x*size, y*size, size));
				} else {
					tiles[x][y] = new MasterTile(new Grass(), new TileInfo(x*size, y*size, size));
				}
			}
		}

	}

	public void render(Graphics g) {
		int cameraX = Camera.getX() / size;
		int cameraY = Camera.getY() / size;

		int cameraWidth = MasterCanvas.WIDTH / size + 3;
		int cameraHeight = MasterCanvas.HEIGHT / size + 3;

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
		int cameraX = Camera.getX() / size;
		int cameraY = Camera.getY() / size;

		int cameraWidth = MasterCanvas.WIDTH / size + 3;
		int cameraHeight = MasterCanvas.HEIGHT / size + 3;

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

}
