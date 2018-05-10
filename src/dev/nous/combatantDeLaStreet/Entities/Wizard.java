package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class Wizard extends Hero{
	private BouleDeFeu bdf;
	public static boolean isSuperAttacking =false;
	protected static double attackRange = 40;
	
	public Wizard(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(game, x,y,speed,h,w, owner,attackRange);
		hitbox.x = 20;
		hitbox.y = 20;
		hitbox.height = 70;
		hitbox.width = 30;
		basicDamages = 8;
		health = 100;
	}

	@Override
	public void update() {
		//super.update();
		if(isSuperAttacking) {
			bdf.update();
		}else {
			bdf = null;  //clear l'objet bdf si il n'est plus actif (je crois que la JVM le fait automatiquement de toute facon mais on sait jamais...)
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.wizard, (int) x, (int) y,w,h, null);
		g.setColor(Color.RED);
		if(isSuperAttacking)
			bdf.render(g);
		g.drawRect(attackBox.x,attackBox.y, attackBox.width,attackBox.height);		

	}
	
	@Override
	public void superAttack() {
		bdf  = new BouleDeFeu(x, y,6f,30,30,owner,orientation);
		bdf.orientation = orientation;
		isSuperAttacking =true;
	}
	}
