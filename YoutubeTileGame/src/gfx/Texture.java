package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	private BufferedImage image = null;
	
	public Texture(String link) {
		try {
			setImage(ImageIO.read(Texture.class.getClassLoader().getResourceAsStream(link)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
