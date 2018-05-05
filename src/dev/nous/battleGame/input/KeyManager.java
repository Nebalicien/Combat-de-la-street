package dev.nous.battleGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	private boolean[] keys;
	public boolean up1, up2, down1, down2, right1, right2, left1, left2;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void update() {
		up1 = keys[KeyEvent.VK_Z];   //la case associée à z est mis dans up1
		down1 = keys[KeyEvent.VK_S];
		left1 = keys[KeyEvent.VK_Q];
		right1 = keys[KeyEvent.VK_D];
		up2 = keys[KeyEvent.VK_I];
		down2 = keys[KeyEvent.VK_K];
		left2 = keys[KeyEvent.VK_J];
		right2 = keys[KeyEvent.VK_L];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {  //run automatiquement met true la case de la touche pressé
		keys[e.getKeyCode()] = true;	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
