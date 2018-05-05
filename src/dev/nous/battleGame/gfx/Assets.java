package dev.nous.battleGame.gfx;

import java.awt.image.BufferedImage;

public class Assets {  //contient les assets du jeu = crop la spritesheet et initialise les persos
	private static final int w = 31, h= 31;
	public static BufferedImage barbare, wizard, gobelin, dragon, grass;
	
	
	public static void init() {
		SpriteSheet sp= new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		barbare = sp.separate(0, 0, h, w);
		wizard = sp.separate(31, 0, h, w);
		gobelin = sp.separate(0, 31, h, w);
		grass = sp.separate(62, 0, h, w);
	}
}
