package dev.nous.combatantDeLaStreet.Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected float x, y;  //float pour avoir un rendu plus smooth
	protected float speed;
	protected int h,w;
	protected float xMove, yMove;
	Rectangle hitbox;
	
	public Entity(float x, float y, float speed, int h, int w) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.h= h;
		this.w=w;
		this.hitbox = new Rectangle(0, 0, w,h);
	}
	
	public void move() {
		x+=xMove;
		y+=yMove;
	}
	
	public abstract void update();
		
	public abstract void render(Graphics g);
}
