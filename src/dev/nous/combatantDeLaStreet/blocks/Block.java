package dev.nous.combatantDeLaStreet.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Block {
	public static Block[] blocks = new Block[200];  //contient tous le blocks utilisés rangés par id comme ca on instancie une fois
	public static Block grass = new GrassBlock(1);
	
	public static final int BLOCK_WIDTH = 64, BLOCK_HEIGHT = 64;
	protected int id;
	protected BufferedImage texture;
	
	public Block(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		blocks[id] = this;  //on ajoute le block au tab
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, BLOCK_WIDTH, BLOCK_HEIGHT, null);
	}
	
	public int getId() {
		return id;
	}
}
