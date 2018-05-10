package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private long lastTime;
	private double speed;
	private double timer =0;
	private int index=0;
	private BufferedImage[] imageBuffer;
	public boolean animationDone;
	
	public Animation(BufferedImage[] imageBuffer, double speed) {
		lastTime = System.currentTimeMillis();
		this.speed = speed;
		this.imageBuffer = imageBuffer;
	}
	
	public void tick() {
		animationDone = false;
		timer+=System.currentTimeMillis()-lastTime; //ajoute chaque ms à timer
		lastTime = System.currentTimeMillis();
		if(timer>=speed) {
			index++;
			if(index>=imageBuffer.length) {
				index =0;

				animationDone = true;
			}
			timer =0;
		}
	}
	
	
	public BufferedImage getCurrentImage() {
		return imageBuffer[index];
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
