package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.nous.combatantDeLaStreet.Worlds.World1;
import dev.nous.combatantDeLaStreet.blocks.Block;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class BouleDeFeu extends Entity {
	protected int owner;
	protected int orientation;
	protected Hero ennemi;
	protected double superAttackDamage;
//	protected Rectangle attackBox;
	
	public BouleDeFeu (float x, float y, float speed, int h, int w, int owner, int orientation) {
		super (x, y, speed, h, w);
		this.orientation = orientation;
		this.owner = owner;
		this.superAttackDamage = 70;
		
		hitbox.x = 30;
		hitbox.y = 30;
		hitbox.height = 20;
		hitbox.width = 20;
		
		
	}
	public void update () {
		xMove = 0;
		yMove = 0;
		switch (orientation) {
		case 1 :
			xMove-=speed;
			break;
		case 2 :
			yMove-=speed;
			break;
		case 3 :
			xMove+=speed;
			break;
		}
		move();
		hitbox.x = (int)x+30;
		hitbox.y = (int)y+30;
		Wizard.isSuperAttacking = checkObstacle();
	}

	public boolean checkObstacle(){
		if(owner == 0)
			ennemi = Hero.allHeros[1];  //on attribue ennemi ici et pas dans le constructeur pour être sur que les deux héros sont instanciés
		else
			ennemi = Hero.allHeros[0];
		//attackBox.setBounds (hitbox.x,hitbox.y, hitbox.width , hitbox.height);
		if(World1.getBlock((hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,(hitbox.x)/Block.BLOCK_WIDTH) != null || World1.getBlock((hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,(hitbox.x+hitbox.width)/Block.BLOCK_WIDTH) != null || World1.getBlock((hitbox.y)/Block.BLOCK_HEIGHT,(hitbox.x)/Block.BLOCK_WIDTH) != null || World1.getBlock((hitbox.y)/Block.BLOCK_HEIGHT,(hitbox.x+hitbox.width)/Block.BLOCK_WIDTH) != null) {
			return false;
		}else {
			if(hitbox.intersects(new Rectangle((int)ennemi.x+ennemi.hitbox.x, (int)ennemi.y+ennemi.hitbox.y,ennemi.hitbox.width, ennemi.hitbox.height))) {  //car les hitbox ne sont pas définis par rapport à la position du héro
				ennemi.health-=superAttackDamage;
				System.out.println(ennemi.health);
				return false;
			}else {return true;}
		}
		
			
	}
	
	public void render(Graphics g) {
		switch (orientation) {
			case 1:
				g.drawImage(Assets.bouleDeFeuGauche, (int) x, (int) y,w,h, null);
				break;
			case 3:
				g.drawImage(Assets.bouleDeFeuDroite, (int) x, (int) y,w,h, null);
				break;
			default :
				break;
		}
		g.setColor(Color.CYAN);
		g.drawRect(hitbox.x,hitbox.y, hitbox.width,hitbox.height);
		//g.setColor(Color.BLACK);
		//g.drawRect(attackBox.x,attackBox.y, attackBox.width,attackBox.height);
	}
	
}