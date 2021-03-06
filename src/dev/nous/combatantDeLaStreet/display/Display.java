package dev.nous.combatantDeLaStreet.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width, height;
	
	public Display(String Title, int width, int height) {
		this.width = width;
		this.height = height;
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);  //sinon le KeyListener ne marche pas
		frame.add(canvas);
		frame.pack();
	}
	
	//Getteur
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getJFrame() {
		return frame;
	}
}
