package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

public class Assets {  //contient les assets du jeu = crop la spritesheet et initialise les persos
	private static final int w = 31, h= 31;
	public static BufferedImage barbare, wizard, gobelin, dragon, grass, bouleDeFeu;
	public static BufferedImage[] barbareAttack = new BufferedImage[3];
	
	
	public static void init() {
		SpriteSheet sp= new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		barbare = sp.separate(0, 0, h, w);
		wizard = sp.separate(31, 0, h, w);
		gobelin = sp.separate(0, 31, h, w);
		grass = sp.separate(62, 0, h, w);
		bouleDeFeu = sp.separate(0, 31, h, w);
		barbareAttack[0] = sp.separate(0, 31*2, w, h);
		barbareAttack[1] = sp.separate(31, 31*2, w, h);
		barbareAttack[2] = sp.separate(31*2, 31*2, w, h);
	}
}
