package dev.nous.battleGame;


public class Launcher {
	public final static int WINDOW_HEIGHT = 750;
	public final static int WINDOW_WIDTH = 1390;
	public static void main(String[] args) {
		Game game = new Game("BattleGame", WINDOW_WIDTH, WINDOW_HEIGHT);
		game.start();
	}
}
