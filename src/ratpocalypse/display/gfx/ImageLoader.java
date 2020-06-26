package ratpocalypse.display.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path)
	{
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public static Image loadGif(String path) {
		
		Image gif = new ImageIcon(ImageLoader.class.getResource(path)).getImage();
		
		return gif;
	}

}
