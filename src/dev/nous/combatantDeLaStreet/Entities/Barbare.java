package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.gfx.Animation;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class Barbare extends Hero{
	private Animation basicAttackAnim;
	private static double attackRange = 30;
	public Barbare(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(game, x,y,speed,h,w, owner, attackRange);
		hitbox.x = 20;
		hitbox.y = 20;
		hitbox.height = 70;
		hitbox.width = 30;
		basicDamages = 20;
		health = 300;
		
		//ANIM
		basicAttackAnim = new Animation(Assets.barbareAttack,150);
	}

	@Override
	public void update() {
		super.update();
		if(basicAttacking)
			basicAttackAnim.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.barbare, (int) x, (int) y,w,h, null);
		g.setColor(Color.CYAN);
		g.drawRect((int)x+hitbox.x,(int) y+hitbox.y, hitbox.width,hitbox.height);
		g.setColor(Color.BLACK);
		g.drawRect(attackBox.x,attackBox.y, attackBox.width,attackBox.height);	
		if(basicAttacking)
			g.drawImage(basicAttackAnim.getCurrentImage(), (int)x, (int)y, w, h, null);

	}

	@Override
	void superAttack() {
		// TODO Auto-generated method stub
		
	}
}
