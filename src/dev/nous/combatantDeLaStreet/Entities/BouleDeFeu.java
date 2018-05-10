package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Worlds.World1;
import dev.nous.combatantDeLaStreet.blocks.Block;
import dev.nous.combatantDeLaStreet.gfx.Assets;

public class BouleDeFeu extends Entity {
	protected int owner;
	protected int orientation;
	
	public BouleDeFeu (float x, float y, float speed, int h, int w, int owner, int orientation) {
		super (x, y, speed, h, w);
		this.orientation = orientation;
		this.owner = owner;
		hitbox.x = 0;
		hitbox.y = 0;
		hitbox.height = 40;
		hitbox.width = 40;
		
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
		Wizard.isSuperAttacking = checkObstacle();
	}

	public boolean checkObstacle(){
		if(World1.getBlock(((int)y+hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,((int)x+hitbox.x)/Block.BLOCK_WIDTH) != null || World1.getBlock(((int)y+hitbox.y+hitbox.height)/Block.BLOCK_HEIGHT,((int)x+hitbox.x+hitbox.width)/Block.BLOCK_WIDTH) != null || World1.getBlock(((int)y+hitbox.y)/Block.BLOCK_HEIGHT,((int)x+hitbox.x)/Block.BLOCK_WIDTH) != null || World1.getBlock(((int)y+hitbox.y)/Block.BLOCK_HEIGHT,((int)x+hitbox.x+hitbox.width)/Block.BLOCK_WIDTH) != null) {
			return false;
		}else {return true;}
	 
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.bouleDeFeu, (int) x, (int) y,w,h, null);
		g.setColor(Color.CYAN);
		g.drawRect((int)x+hitbox.x,(int) y+hitbox.y, hitbox.width,hitbox.height);
	}
	
}