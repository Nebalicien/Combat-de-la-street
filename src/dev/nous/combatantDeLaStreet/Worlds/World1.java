package dev.nous.combatantDeLaStreet.Worlds;

import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Launcher;
import dev.nous.combatantDeLaStreet.blocks.Block;

public class World1 {
	private static int worldMap[][] = {
			{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
	

	
	public World1() {
		
	}
	
	public void render(Graphics g) {
		for(int i=0; i<worldMap.length; i++) {
			for(int j=0; j<worldMap[i].length; j++) {
				if(getBlock(i,j) == null) {
					
				}else {
					getBlock(i,j).render(g, j*Block.BLOCK_WIDTH, i*Block.BLOCK_HEIGHT);  //render les blocks
				}
			}
		}
	}
	
	
	public static Block getBlock(int x,int y) {
		if(x<0 || y<0 || x>worldMap[10].length|| y >worldMap.length)
			return null;
		Block b = Block.blocks[worldMap[x][y]];
		if(b == null)
			return null;
		return b;
	}
	
	public void update() {
		
	}
}
