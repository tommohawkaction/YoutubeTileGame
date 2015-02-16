package files;

import gfx.SpriteSheet;

public class Assets {

	public static SpriteSheet mainSheet = new SpriteSheet("SpriteSheets/tileSheet.png");
	
	
	public static void loadAll(){
		loadCroppedImages();
	}
	public static void loadCroppedImages(){
		mainSheet.loadCroped("grass", 0, 0, 16,16);
		mainSheet.loadCroped("tree", 16, 0, 16,16);
	}
}
