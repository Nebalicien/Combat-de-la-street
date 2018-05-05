package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

//load une image
public class ImageLoader {
	public static BufferedImage loadImage(String path) { //static pour pouvoir y acceder direct
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));  //lit l'image relativement au path de la class
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1); //si image pas load quit
		} 
		return null; // on doit return null
	}
}
