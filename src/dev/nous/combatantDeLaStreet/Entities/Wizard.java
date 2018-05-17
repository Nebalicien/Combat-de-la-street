package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.gfx.Animation;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class Wizard extends Hero{
	private BouleDeFeu bdf;
	public static boolean isSuperAttacking =false;
	protected static double attackRange = 40;
	private Animation basicAttackAnimDroite;
	private Animation basicAttackAnimGauche;
	private Animation jumpAnimDroite;
	private Animation jumpAnimGauche;
	private Animation runAnimDroite;
	private Animation runAnimGauche;
	
	public Wizard(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(game, x,y,speed,h,w, owner,attackRange);
		hitbox.x = 55;
		hitbox.y = 60;
		hitbox.height = 70;
		hitbox.width = 30;
		basicDamages = 8;
		health = 100;
		//ANIM
		basicAttackAnimDroite = new Animation(Assets.wizardAttackDroite,90);
		basicAttackAnimGauche = new Animation(Assets.wizardAttackGauche,90);
		jumpAnimDroite = new Animation(Assets.wizardJumpRight, 100);
		jumpAnimGauche = new Animation(Assets.wizardJumpLeft, 100);
		runAnimDroite = new Animation(Assets.wizardRunRight,80);
		runAnimGauche = new Animation(Assets.wizardRunLeft,80);
	}

	@Override
	public void update() {
		super.update(basicAttackAnimDroite, basicAttackAnimGauche, jumpAnimDroite, jumpAnimGauche, runAnimDroite, runAnimGauche);
		if(isSuperAttacking) {
			bdf.update();
		}else {
			bdf = null;  //clear l'objet bdf si il n'est plus actif (je crois que la JVM le fait automatiquement de toute facon mais on sait jamais...)
		}
	}

	@Override
	public void render(Graphics g) {
		super.render(g, Assets.wizardDroite,Assets.wizardGauche, basicAttackAnimGauche,basicAttackAnimDroite,jumpAnimGauche,jumpAnimDroite,runAnimDroite, runAnimGauche,Assets.wizardCrouchLeft, Assets.wizardCrouchRight);
		g.setColor(Color.RED);
		if(isSuperAttacking)
			bdf.render(g);
		g.drawRect(attackBox.x,attackBox.y, attackBox.width,attackBox.height);		

	}
	
	@Override
	public void superAttack() {
		bdf  = new BouleDeFeu(x+30, y+30,6f,80,80,owner,orientation);
		bdf.orientation = orientation;
		isSuperAttacking =true;
		switch(orientation) {
		case 1:
			//vers la gauche
			basicAttackingGauche = true;
			break;
		case 3:
			//vers la droite
			basicAttackingDroite = true;
			break;
		default:
			basicAttackingDroite = true;
			break;
	}

	}
	}
