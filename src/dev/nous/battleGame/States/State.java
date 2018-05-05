package dev.nous.battleGame.States;

import java.awt.Graphics;

import dev.nous.battleGame.Game;

public abstract class State {  //archetype des States de notre prog (MenuState, game...)
	
	private static State currentState = null;
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}

	
	
	public abstract void update();
	public abstract void render(Graphics g);
}
