package dev.nous.combatantDeLaStreet;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.nous.combatantDeLaStreet.States.GameState;
import dev.nous.combatantDeLaStreet.States.MenuState;
import dev.nous.combatantDeLaStreet.States.State;
import dev.nous.combatantDeLaStreet.display.Display;
import dev.nous.combatantDeLaStreet.gfx.Assets;
import dev.nous.combatantDeLaStreet.input.KeyManager;


public class Game implements Runnable{
	private int width, height;
	private Display display;
	private String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	
	
	

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.keyManager = new KeyManager();
	}
	
	private void init() {  //initialise le jeu
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(keyManager);  //ajoute notre KeyManager au JFrame 
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this); 
		State.setState(gameState);  //focus sur le game
	}

	private void update() { //update le jeu: ex position
		keyManager.update();
		
		if(State.getState() != null)
			State.getState().update(); //call update de notre state
	}
	
	private void render() { //render le jeu
		bs = display.getCanvas().getBufferStrategy();  //evite le flickering load des buffers dans lesquels on draw
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3); // si le BS n'existe pas on le crée
			return;
		}
		g=bs.getDrawGraphics();  //cree un context graphic
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(g); //call render de notre state
		
		bs.show();		//passe le bs au premier plan (screen)
		g.dispose();    //clear le graphic
	}
		
	public void run() {  //methode qui game
		init();
		
		int fps = 60;
		double timePerFrame = 1_000_000_000/fps;  //1 seconde divise par fps pour avoir le temps d'une frame
		long now ;
		long lastTime = System.nanoTime();
		double delta = 0;
		int timer = 0;
		int frame=0;
				
		while(running) {
			now = System.nanoTime();
			delta+=(now-lastTime)/timePerFrame;  //temps ecoulé entre deux t divisé par le temps pour une frame
			timer+=(now-lastTime);
			lastTime = now;
			
			if(delta>=1) { // si temps ecoulé >= temps de la frame on render 
				render();
				update();
				
				delta=0;
				frame++;
			}
			
			if(timer>=1_000_000_000) {  //si 1 seconde on affiche les fps
				//System.out.println("fps : "+ frame);
				timer =0;
				frame=0;
			}
			timer++;
		}
		
		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
		//THREAD
	public synchronized void start() {
		if(running) //empeche de lancer 2 thread
			return;
		running =true;
		thread = new Thread(this); //cree un thread sur Game
		thread.start(); //call run
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();  //attend la fin de thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
