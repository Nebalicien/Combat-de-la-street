package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.Launcher;
import dev.nous.combatantDeLaStreet.Worlds.World1;
import dev.nous.combatantDeLaStreet.blocks.Block;

public abstract class Hero extends Entity{
	protected Game game;
	protected double vie;
	protected String nom;
	protected double vitesse;
	protected int[] position;
	protected int orientation;
	protected double attaqueDegat;
	protected double armor; 
	protected boolean isOnFloor;
	protected double jumpHeight = 0;
	protected int owner;
	protected boolean isJumping = false;
	protected int superAttackCooldown = 0;
	
	public Hero(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(x,y,speed,h,w);
		this.game = game;
		this.owner = owner;
	}
	
	protected void getInputJ1() {
		xMove=0;
		yMove=0;
		
		if(game.getKeyManager().up1) {
			orientation = 2;
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
			xMove+=speed;
		}
		if (superAttackCooldown >= 100f) {
			if(game.getKeyManager().superAttack1) {
				superAttack();
				superAttackCooldown = 0;
			}
		}
		superAttackCooldown++;
	}
	
	protected void getInputJ2() {
		xMove=0;
		yMove=0;
		
		if(game.getKeyManager().up2) {
			orientation = 2;
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
		if (superAttackCooldown >= 100f) {
			if(game.getKeyManager().superAttack2) {
				superAttack();
				superAttackCooldown = 0;
			}
		}
		superAttackCooldown++;
	}
	
	
	
	public void update() {
		if(this.owner == 0)
			getInputJ1();
		else
			getInputJ2();
		
		if(isJumping && jumpHeight>0) {
			yMove-=10;
			jumpHeight+=yMove;
		}

		if(!isOnFloor)
			gravity();
		move();
		checkFloor();
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
	
	protected void attack() {
		
	}
	
	protected void defend() {
		
	}
}
