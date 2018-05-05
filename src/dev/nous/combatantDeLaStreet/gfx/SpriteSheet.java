package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

//Notre Image de Sprites
public class SpriteSheet {
	private BufferedImage imageFull;
	
	public SpriteSheet(BufferedImage imageFull) {
		this.imageFull = imageFull;
	}
	
	//separe les Sprites
	public BufferedImage separate(int x, int y, int h, int w) {
		return imageFull.getSubimage(x, y, w, h);
	}
	
}
