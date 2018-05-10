package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.gfx.Animation;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class Barbare extends Hero{
	private Animation basicAttackAnimDroite;
	private Animation basicAttackAnimGauche;
	private Animation jumpAnimDroite;
	private Animation jumpAnimGauche;
	private Animation runAnimDroite;
	private Animation runAnimGauche;
	private static double attackRange = 60;
	
	public Barbare(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(game, x,y,speed,h,w, owner, attackRange);
		hitbox.x = 55;
		hitbox.y = 60;
		hitbox.height = 70;
		hitbox.width = 30;
		basicDamages = 20;
		health = 300;
		
		//ANIM
		basicAttackAnimDroite = new Animation(Assets.barbareAttackDroite,90);
		basicAttackAnimGauche = new Animation(Assets.barbareAttackGauche,90);
		jumpAnimDroite = new Animation(Assets.barbareJumpRight, 100);
		jumpAnimGauche = new Animation(Assets.barbareJumpLeft, 100);
		runAnimDroite = new Animation(Assets.barbareRunRight,80);
		runAnimGauche = new Animation(Assets.barbareRunLeft,80);
		
	}

	@Override
	public void update() {
		super.update(basicAttackAnimDroite, basicAttackAnimGauche, jumpAnimDroite, jumpAnimGauche, runAnimDroite, runAnimGauche);
		
	}

	@Override
	public void render(Graphics g) {
		super.render(g, Assets.barbareDroite,Assets.barbareGauche, basicAttackAnimGauche,basicAttackAnimDroite,jumpAnimGauche,jumpAnimDroite,runAnimDroite, runAnimGauche);
		g.setColor(Color.CYAN);
		g.drawRect((int)x+hitbox.x,(int) y+hitbox.y, hitbox.width,hitbox.height);
		g.setColor(Color.BLACK);
		g.drawRect(attackBox.x,attackBox.y, attackBox.width,attackBox.height);	
	}

	@Override
	void superAttack() {
		// TODO Auto-generated method stub
		
	}
}
