package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.Worlds.World1;
import dev.nous.combatantDeLaStreet.blocks.Block;
import dev.nous.combatantDeLaStreet.gfx.Animation;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public abstract class Hero extends Entity{
	public static Hero[] allHeros = new Hero[2];
	protected Game game;
	protected double health;
	protected String name;
	protected int orientation;
	protected double basicDamages;
	protected double armor; 
	protected boolean isOnFloor;
	protected double jumpHeight = 0;
	protected int owner;
	protected boolean isJumping = false;
	protected int superAttackCooldown = 0;
	protected int basicAttackCooldown = 0;
	protected double attackRange;
	protected Rectangle attackBox;
	protected Hero ennemi;
	protected boolean basicAttackingDroite = false;
	protected boolean basicAttackingGauche = false;
	protected boolean isRunningRight = false;
	
	
	public Hero(Game game, float x, float y, float speed, int h, int w, int owner, double attackRange) {
		super(x,y,speed,h,w);
		this.game = game;
		this.owner = owner;
		this.attackRange = attackRange;
		this.attackBox = new Rectangle(w, 0, (int)attackRange,h);
		if(owner == 0)
			allHeros[0] = this;  //permet de garder trace des heros sur le plateau de jeu
		else
			allHeros[1] = this;
	}
	
	protected void getInputJ1() {
		xMove=0;
		yMove=0;
		
		if(game.getKeyManager().up1) {
			if(isOnFloor) {
				jump();
			}
		}
		if(game.getKeyManager().down1) {
			orientation = 0;
			yMove+=speed;
		}
		if(game.getKeyManager().left1) {
			xMove-=speed;
			orientation = 1;
		}
		if(game.getKeyManager().right1) {
			this.orientation = 3;
			isRunningRight = true;
			xMove+=speed;
		}
		if(game.getKeyManager().basicAttack1 && basicAttackCooldown >=30) {
			basicAttack();
			basicAttackCooldown = 0;
		}
		if (game.getKeyManager().superAttack1 && superAttackCooldown >= 100) {
				superAttack();
				superAttackCooldown = 0;
		}
		superAttackCooldown++;
		basicAttackCooldown++;
	}
	
	protected void getInputJ2() {
		xMove=0;
		yMove=0;
		
		if(game.getKeyManager().up2) {
			if(isOnFloor) {
				jump();
			}
		}
		if(game.getKeyManager().down2) {
			orientation = 0;
			yMove+=speed;
		}
		if(game.getKeyManager().left2) {
			xMove-=speed;
			orientation = 1;
		}
		if(game.getKeyManager().right2) {
			this.orientation = 3;
			xMove+=speed;
		}
		if(game.getKeyManager().basicAttack2 && basicAttackCooldown >=30) {
			basicAttack();
			basicAttackCooldown = 0;
		}
		if (superAttackCooldown >= 100) {
			if(game.getKeyManager().superAttack2) {
				superAttack();
				superAttackCooldown = 0;
			}
		}
		superAttackCooldown++;
		basicAttackCooldown++;
	}
	
	
	
	public void update(Animation basicAttackAnimDroite, Animation basicAttackAnimGauche, Animation jumpAnimDroite, Animation jumpAnimGauche, Animation runAnimDroite) {
		if(this.owner == 0)
			getInputJ1();
		else
			getInputJ2();
		
		if(jumpHeight>0) {
			isJumping= true;
			yMove-=10;
			jumpHeight+=yMove;
		}else
			isJumping = false;

		if(!isOnFloor)
			gravity();
		move();
		checkFloor();
		
		//ANIMATION UPDATE
		if(isRunningRight)
			runAnimDroite.tick();
			
		if(basicAttackingDroite) {
			basicAttackAnimDroite.tick();
			if(basicAttackAnimDroite.animationDone) {
				basicAttackingDroite = false;
			}
		}
		if(basicAttackingGauche) {
			basicAttackAnimGauche.tick();
			if(basicAttackAnimGauche.animationDone) {
				basicAttackingGauche = false;
			}
		}
		if(isJumping && orientation == 3)
			jumpAnimDroite.tick();
		if(isJumping && orientation == 1)
			jumpAnimGauche.tick();
		isRunningRight = false;
	}
	
	public void render(Graphics g,BufferedImage stayDroite, BufferedImage stayGauche, Animation basicAttackAnimGauche,Animation basicAttackAnimDroite,Animation jumpAnimGauche,Animation jumpAnimDroite, Animation runAnimDroite) {
		if(isRunningRight)
			runAnimDroite.tick();
		if(isJumping && orientation == 3 && !basicAttackingDroite && !basicAttackingGauche)
			g.drawImage(jumpAnimDroite.getCurrentImage(), (int)x, (int)y,w,h,null);
		if(isJumping && orientation == 1 && !basicAttackingDroite && !basicAttackingGauche) 
			g.drawImage(jumpAnimGauche.getCurrentImage(), (int)x, (int)y,w,h,null);
		if(basicAttackingDroite) { 
			g.drawImage(basicAttackAnimDroite.getCurrentImage(), (int)x, (int)y, w, h, null);
		}
		if(basicAttackingGauche) {
			g.drawImage(basicAttackAnimGauche.getCurrentImage(), (int)x, (int)y, w, h, null);
		}
		if(!basicAttackingGauche && !basicAttackingDroite && orientation == 3 && !isJumping) {
			g.drawImage(stayDroite, (int) x, (int) y,w,h, null);
		}
		if(!basicAttackingGauche && !basicAttackingDroite && orientation == 1 && !isJumping) {
			g.drawImage(stayGauche, (int) x, (int) y,w,h, null);
		}
	}
	
	protected void gravity() {	
		yMove+=5;
	}
	
	protected void jump() {
		jumpHeight = 200;
		isJumping = true;
		isOnFloor =false;
	}
	
	protected void checkFloor() {
		if(World1.getBlock(((int)y+hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,((int)x+hitbox.x)/Block.BLOCK_WIDTH) != null || World1.getBlock(((int)y+hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,((int)x+hitbox.x+hitbox.width)/Block.BLOCK_WIDTH) != null) {
			isOnFloor = true;
		}else {
			isOnFloor =false;
		}
		}
	

	abstract void superAttack();
	
	protected void basicAttack() {
		if(owner == 0)
			ennemi = allHeros[1];  //on attribue ennemi ici et pas dans le constructeur pour être sur que les deux héros sont instanciés
		else
			ennemi = allHeros[0];
		
		switch(orientation) {
			case 1:
				//vers la gauche
				attackBox.setBounds((int)x+hitbox.x-(int)attackRange,(int)y+hitbox.y, (int)attackRange, hitbox.height);
				basicAttackingGauche = true;
				break;
			case 3:
				//vers la droite
				attackBox.setBounds((int)x+hitbox.x+hitbox.width,(int)y+hitbox.y, (int)attackRange, hitbox.height);
				basicAttackingDroite = true;
				break;
			default:
				attackBox.setBounds((int)x+w,(int)y, (int)attackRange, h);
				basicAttackingDroite = true;
				break;
		}
		if(attackBox.intersects(new Rectangle((int)ennemi.x+ennemi.hitbox.x, (int)ennemi.y+ennemi.hitbox.y,ennemi.hitbox.width, ennemi.hitbox.height))) {  //car les hitbox ne sont pas définis par rapport à la position du héro
			ennemi.health-=basicDamages;
			System.out.println(ennemi.health);
		}
	
	}
	
	
	
	protected void defend() {
		
	}
		
}
