package dev.nous.combatantDeLaStreet.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private long lastTime;
	private double speed;
	private double timer =0;
	private int index=0;
	private BufferedImage[] imageBuffer;
	
	public Animation(BufferedImage[] imageBuffer, double speed) {
		lastTime = System.currentTimeMillis();
		this.speed = speed;
		this.imageBuffer = imageBuffer;
	}
	
	public void tick() {
		timer+=System.currentTimeMillis()-lastTime; //ajoute chaque ms à timer
		lastTime = System.currentTimeMillis();
		if(timer>=speed) {
			index++;
			timer =0;
			if(index>=imageBuffer.length)
				index =0;
		}
	}
	
	
	public BufferedImage getCurrentImage() {
		return imageBuffer[index];
	}
	
}
