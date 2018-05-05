package dev.nous.battleGame.States;

import java.awt.Graphics;

import dev.nous.battleGame.Game;
import dev.nous.battleGame.Entities.Barbare;
import dev.nous.battleGame.Entities.Wizard;
import dev.nous.battleGame.Worlds.World1;
import dev.nous.battleGame.blocks.Block;
import dev.nous.battleGame.gfx.Assets;

public class GameState extends State{
	private Barbare barbare;
	private World1 world1;
	private Wizard wizard;
	
	public GameState(Game game) {
		super(game);
		world1 = new World1();
		barbare= new Barbare(game, 400, 200 ,3f, 90, 70, 0);
		wizard= new Wizard(game, 400, 200 ,6f, 90, 70, 1);
	}
	
	@Override
	public void update() {
		barbare.update();
		wizard.update();
	}

	@Override
	public void render(Graphics g) {
		wizard.render(g);
		barbare.render(g);
		world1.render(g);

	}
	
}
