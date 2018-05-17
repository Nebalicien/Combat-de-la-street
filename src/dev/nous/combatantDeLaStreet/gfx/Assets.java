package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

public class Assets {  //contient les assets du jeu = crop la spritesheet et initialise les persos
	private static final int w = 72, h= 72;
	public static BufferedImage barbareDroite, barbareGauche,barbareCrouchRight,barbareCrouchLeft, wizardDroite,wizardGauche, wizardCrouchRight, wizardCrouchLeft, gobelin, dragon, grass, bouleDeFeuDroite,bouleDeFeuGauche;
	public static BufferedImage[] barbareAttackDroite = new BufferedImage[3];
	public static BufferedImage[] barbareAttackGauche = new BufferedImage[3];
	public static BufferedImage[] barbareJumpRight = new BufferedImage[4];
	public static BufferedImage[] barbareJumpLeft = new BufferedImage[4];
	public static BufferedImage[] barbareRunRight = new BufferedImage[8];
	public static BufferedImage[] barbareRunLeft = new BufferedImage[8];
	public static BufferedImage[] wizardAttackDroite = new BufferedImage[4];
	public static BufferedImage[] wizardAttackGauche = new BufferedImage[4];
	public static BufferedImage[] wizardJumpRight = new BufferedImage[4];
	public static BufferedImage[] wizardJumpLeft = new BufferedImage[4];
	public static BufferedImage[] wizardRunRight = new BufferedImage[8];
	public static BufferedImage[] wizardRunLeft = new BufferedImage[8];
	public static BufferedImage[] heal = new BufferedImage[8];
	
	
	public static void init() {
		SpriteSheet sp= new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		//wizard = sp.separate(31, 0, h, w);
		gobelin = sp.separate(0, 31, h, w);
		grass = sp.separate(0, w*13, h, w);
		bouleDeFeuDroite = sp.separate(0, h*8, h, w);
		bouleDeFeuGauche = sp.separate(w, h*8, h, w);
		heal[0] = sp.separate(2*w,h*8,h,w);
		heal[1] = sp.separate(3*w,h*8,h,w);
		heal[2] = sp.separate(2*w,h*8,h,w);
		heal[3] = sp.separate(3*w,h*8,h,w);
		heal[4] = sp.separate(2*w,h*8,h,w);
		heal[5] = sp.separate(3*w,h*8,h,w);
		heal[6] = sp.separate(2*w,h*8,h,w);
		heal[7] = sp.separate(3*w,h*8,h,w);
		initBarbare(sp);
		initWizard(sp);
		
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
	private static void initWizard(SpriteSheet sp) {
		wizardDroite = sp.separate(0, 2*h, h, w);
		wizardGauche = sp.separate(0, 3*h, h, w);
		wizardAttackDroite[0] = sp.separate(w*2, 2*h, w, h);
		wizardAttackDroite[1] = sp.separate(w*3, 2*h, w, h);
		wizardAttackDroite[2] = sp.separate(w*4, 2*h, w, h);
		wizardAttackDroite[3] = sp.separate(w*5, 2*h, w, h);
		wizardAttackGauche[0] = sp.separate(w*2,3*h, w, h);
		wizardAttackGauche[1] = sp.separate(w*3,3*h, w, h);
		wizardAttackGauche[2] = sp.separate(w*4, 3*h, w, h);
		wizardAttackGauche[3] = sp.separate(w*5, 3*h, w, h);
		
		//JUMP
		wizardJumpRight[0] = sp.separate(w*10, 2*h, h, w);
		wizardJumpRight[1] = sp.separate(w*11, 2*h, h, w);
		wizardJumpRight[2] = sp.separate(w*12, 2*h, h, w);
		wizardJumpRight[3] = sp.separate(w*13, 2*h, h, w);
		wizardJumpLeft[0] = sp.separate(w*10, 3*h, h, w);
		wizardJumpLeft[1] = sp.separate(w*11, 3*h, h, w);
		wizardJumpLeft[2] = sp.separate(w*12, 3*h, h, w);
		wizardJumpLeft[3] = sp.separate(w*13, 3*h, h, w);
		
		//RUN
		wizardRunRight[0] = sp.separate(w*13, 2*h, w, h);
		wizardRunRight[1] = sp.separate(w*14, 2*h, w, h);
		wizardRunRight[2] = sp.separate(w*15, 2*h, w, h);
		wizardRunRight[3] = sp.separate(w*16, 2*h, w, h);
		wizardRunRight[4] = sp.separate(w*17, 2*h, w, h);
		wizardRunRight[5] = sp.separate(w*18, 2*h, w, h);
		wizardRunRight[6] = sp.separate(w*19, 2*h, w, h);
		wizardRunRight[7] = sp.separate(w*20, 2*h, w, h);
		
		wizardRunLeft[0] = sp.separate(w*13, h*3, w, h);
		wizardRunLeft[1] = sp.separate(w*14, h*3, w, h);
		wizardRunLeft[2] = sp.separate(w*15, h*3, w, h);
		wizardRunLeft[3] = sp.separate(w*16, h*3, w, h);
		wizardRunLeft[4] = sp.separate(w*17, h*3, w, h);
		wizardRunLeft[5] = sp.separate(w*18, h*3, w, h);
		wizardRunLeft[6] = sp.separate(w*19, h*3, w, h);
		wizardRunLeft[7] = sp.separate(w*20, h*3, w, h);
		
		//CROUCH
		wizardCrouchRight = sp.separate(w*6,h*2, h, w);
		wizardCrouchLeft = sp.separate(w*6, h*3, h, w);
		
	}
}
