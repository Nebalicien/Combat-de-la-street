package dev.nous.battleGame.Entities;

import java.awt.Color;
import java.awt.Graphics;


import dev.nous.battleGame.Game;
import dev.nous.battleGame.gfx.Assets;

public class Barbare extends Hero{
	public Barbare(Game game, float x, float y, float speed, int h, int w, int owner) {
		super(game, x,y,speed,h,w, owner);
		hitbox.x = 20;
		hitbox.y = 20;
		hitbox.height = 70;
		hitbox.width = 30;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.barbare, (int) x, (int) y,w,h, null);
		g.setColor(Color.CYAN);
		g.drawRect((int)x+hitbox.x,(int) y+hitbox.y, hitbox.width,hitbox.height);
	}
}
