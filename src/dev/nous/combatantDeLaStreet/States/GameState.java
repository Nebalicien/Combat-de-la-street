package dev.nous.combatantDeLaStreet.States;

import java.awt.Graphics;

import dev.nous.combatantDeLaStreet.Game;
import dev.nous.combatantDeLaStreet.Entities.Barbare;
import dev.nous.combatantDeLaStreet.Entities.Wizard;
import dev.nous.combatantDeLaStreet.Worlds.World1;


public class GameState extends State{
	private Barbare joueur1;
	private World1 world1;
	private Wizard joueur2;

	
	public GameState(Game game) {
		super(game);
		world1 = new World1();
		joueur1= new Barbare(game, 400, 200 ,3f, 180, 140, 0);
		joueur2= new Wizard(game, 400, 200 ,6f, 90, 70, 1);
	}
	
	@Override
	public void update() {
		joueur1.update();
		joueur2.update();
	}

	@Override
	public void render(Graphics g) {
		joueur1.render(g);
		joueur2.render(g);
		world1.render(g);
	}
	
}
