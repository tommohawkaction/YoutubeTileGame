package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage image = null;
	private HashMap<String, BufferedImage> croppedImages = new HashMap<>();
	
	public SpriteSheet(String link){
		try {
			image = ImageIO.read(SpriteSheet.class.getClassLoader().getResourceAsStream(link));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadCroped(String name,int x,int y,int pixelWidth,int pixelHeight){
		if(image != null){
			croppedImages.put(name, image.getSubimage(x, y, pixelWidth, pixelHeight));
		}
	}
	public BufferedImage getImage(String name){
		return croppedImages.get(name);
	}
}
