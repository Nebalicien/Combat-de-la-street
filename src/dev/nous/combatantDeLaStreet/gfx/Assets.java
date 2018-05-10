package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

public class Assets {  //contient les assets du jeu = crop la spritesheet et initialise les persos
	private static final int w = 72, h= 72;
	public static BufferedImage barbareDroite, barbareGauche,barbareCrouchRight,barbareCrouchLeft, wizard, gobelin, dragon, grass, bouleDeFeu;
	public static BufferedImage[] barbareAttackDroite = new BufferedImage[3];
	public static BufferedImage[] barbareAttackGauche = new BufferedImage[3];
	public static BufferedImage[] barbareJumpRight = new BufferedImage[4];
	public static BufferedImage[] barbareJumpLeft = new BufferedImage[4];
	public static BufferedImage[] barbareRunRight = new BufferedImage[8];
	public static BufferedImage[] barbareRunLeft = new BufferedImage[8];

	
	
	public static void init() {
		SpriteSheet sp= new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		wizard = sp.separate(31, 0, h, w);
		gobelin = sp.separate(0, 31, h, w);
		grass = sp.separate(0, w*13, h, w);
		bouleDeFeu = sp.separate(0, h*9, h, w);
		
		initBarbare(sp);
		
	}
	
	private static void initBarbare(SpriteSheet sp) {
		barbareDroite = sp.separate(0, 0, h, w);
		barbareGauche = sp.separate(0, h, h, w);
		barbareAttackDroite[0] = sp.separate(w*17, 0, w, h);
		barbareAttackDroite[1] = sp.separate(w*18, 0, w, h);
		barbareAttackDroite[2] = sp.separate(w*19, 0, w, h);
		barbareAttackGauche[0] = sp.separate(w*17, h, w, h);
		barbareAttackGauche[1] = sp.separate(w*18, h, w, h);
		barbareAttackGauche[2] = sp.separate(w*19, h, w, h);
		
		//JUMP
		barbareJumpRight[0] = sp.separate(w*5, 0, h, w);
		barbareJumpRight[1] = sp.separate(w*6, 0, h, w);
		barbareJumpRight[2] = sp.separate(w*7, 0, h, w);
		barbareJumpRight[3] = sp.separate(w*8, 0, h, w);
		barbareJumpLeft[0] = sp.separate(w*5, w, h, w);
		barbareJumpLeft[1] = sp.separate(w*6, w, h, w);
		barbareJumpLeft[2] = sp.separate(w*7, w, h, w);
		barbareJumpLeft[3] = sp.separate(w*8, w, h, w);
		
		//RUN
		barbareRunRight[0] = sp.separate(w*9, 0, w, h);
		barbareRunRight[1] = sp.separate(w*10, 0, w, h);
		barbareRunRight[2] = sp.separate(w*11, 0, w, h);
		barbareRunRight[3] = sp.separate(w*12, 0, w, h);
		barbareRunRight[4] = sp.separate(w*13, 0, w, h);
		barbareRunRight[5] = sp.separate(w*14, 0, w, h);
		barbareRunRight[6] = sp.separate(w*15, 0, w, h);
		barbareRunRight[7] = sp.separate(w*16, 0, w, h);
		
		barbareRunLeft[0] = sp.separate(w*9, h*1, w, h);
		barbareRunLeft[1] = sp.separate(w*10, h*1, w, h);
		barbareRunLeft[2] = sp.separate(w*11, h*1, w, h);
		barbareRunLeft[3] = sp.separate(w*12, h*1, w, h);
		barbareRunLeft[4] = sp.separate(w*13, h*1, w, h);
		barbareRunLeft[5] = sp.separate(w*14, h*1, w, h);
		barbareRunLeft[6] = sp.separate(w*15, h*1, w, h);
		barbareRunLeft[7] = sp.separate(w*16, h*1, w, h);
		
		//CROUCH
		barbareCrouchRight = sp.separate(w*2, 0, h, w);
		barbareCrouchLeft = sp.separate(w*2, h*1, h, w);
	}
}
