package ratpocalypse.display.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 128, height = 128;
	
	public static BufferedImage basicRat, armoredRat, barbarianRat, bomberRat;
	public static BufferedImage cannonRat, magicRat, motherRat, runningRat;
	
	public static Image uziPlant, shotgunPlant, bitingPlant, palmPlant; 
	public static Image bombPlant, shroomPlant, rosePlant, roseShinyPlant, oddishPlant;
	
	public static BufferedImage standardBackground, shopBackground, mainBackground, loseBackground, winBackground, settings;
	
	private static SpriteSheet ratSheet;
	
	public static void init() 
	{
		standardBackground = ImageLoader.loadImage("/textures/background/standardBackground.png");
		shopBackground = ImageLoader.loadImage("/textures/background/shopbackground.png");
		mainBackground = ImageLoader.loadImage("/textures/background/MainMenu.png");
		loseBackground = ImageLoader.loadImage("/textures/background/LoseBaskground.png");
		winBackground = ImageLoader.loadImage("/textures/background/Win.png");
		settings = ImageLoader.loadImage("/textures/background/settings.png");

		
		ratSheet = new SpriteSheet(ImageLoader.loadImage("/textures/grids/rat-grid.png"));
		
		basicRat = ratSheet.crop(0*width, 0*height, width, height);
		armoredRat = ratSheet.crop(1*width, 0*height, width, height);
		barbarianRat = ratSheet.crop(2*width, 1*height, width, height);
		bomberRat = ratSheet.crop(1*width, 1*height, width, height);
		cannonRat = ratSheet.crop(2*width, 0*height, width, height);
		magicRat = ratSheet.crop(3*width, 0*height, width, height);
		motherRat = ratSheet.crop(3*width, 1*height, width, height);
		runningRat = ratSheet.crop(0*width, 2*height, width, height);
		
		
		uziPlant = ImageLoader.loadGif("/textures/plantUnits/uziPlant-scaled.gif");
		shotgunPlant = ImageLoader.loadGif("/textures/plantUnits/shotgunPlant-scale.gif");
		bitingPlant = ImageLoader.loadGif("/textures/plantUnits/piranhaPlant-scaled.gif");
		palmPlant = ImageLoader.loadGif("/textures/plantUnits/Exeggutor-hd.gif");
		bombPlant = ImageLoader.loadGif("/textures/plantUnits/shroomPlant-scaled.gif");
		shroomPlant = ImageLoader.loadGif("/textures/plantUnits/goombaPlant-scaled.gif");
		rosePlant = ImageLoader.loadGif("/textures/plantUnits/roseliaPlant-scaled.gif");
		roseShinyPlant = ImageLoader.loadGif("/textures/plantUnits/roseliaShinyPlant-scaled.gif");
		oddishPlant = ImageLoader.loadGif("/textures/plantUnits/oddishPlant-scaled.gif");
	}

}
