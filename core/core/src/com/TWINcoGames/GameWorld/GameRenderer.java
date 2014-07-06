package com.TWINcoGames.GameWorld;


import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Helpers.DrawShapes;
import com.TWINcoGames.Helpers.DrawText;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class GameRenderer{

	private ShapeRenderer shapeRenderer;
	private DrawText drawer;
	private ScreenHelper screenHelper;
	private Texture pauseButton;
	private SpriteBatch batcher;
	private DrawShapes shapeDrawer;
	public  Rectangle pauseButtonBounds;
	public Rectangle mainMenuButtonBounds;
	public Rectangle resetButtonBounds;
	public  Rectangle gameOverStringBounds;

	public GameRenderer(GameWorld world) {
		shapeRenderer = new ShapeRenderer();
		drawer = new DrawText();
		screenHelper = new ScreenHelper();
		pauseButton = Assets.pauseButton;
		batcher = new SpriteBatch();
		shapeDrawer = new DrawShapes();
	}


	/**
	 * Handles the screen view when the game is ready
	 */
	public void readyState(){
		drawer.drawTextUpperLeft(Assets.font,GameWorld.gameArray,Assets.fontColor);
		drawer.drawCenteredText("Touch anywhere to start game!");
		if(Gdx.input.justTouched()){
			GameWorld.STATE = GameWorld.PLAYING;
		}
	}

	/**
	 * Handles the screen view when the game is playing
	 */
	public void playingState(){
		drawScreenComponents();
		drawBubbles();
	}

	/**
	 * Handles the screen view when the game is over...
	 * keeps all of the bubbles and text on the screen, however
	 * it handles the gameover message
	 */
	public void gameOverState(){
		drawer.drawTextUpperLeft(Assets.font,GameWorld.gameArray,Assets.fontColor);

		//draw red game over with a black outline
		gameOverStringBounds = drawer.drawCenteredText("Game Over",new Color(0, 0, 0, 1),2.05f);
		drawer.drawCenteredText("Game Over",new Color(255, 0, 0, 1),2);

		drawMainMenuAndResetButton();

	}

	/**
	 * Draw the main menu and the reset button, 
	 * for when the game is paused, and over
	 */
	private void drawMainMenuAndResetButton() {
		float space = Assets.font.getLineHeight();
		resetButtonBounds = drawer.drawText("Play Again",gameOverStringBounds.x - 2*space, gameOverStringBounds.y - space);
		mainMenuButtonBounds = drawer.drawText("Main Menu",  resetButtonBounds.width + resetButtonBounds.x + space, gameOverStringBounds.y - space);
	}
	
	public void pausedState(){
		drawScreenComponents();
		//draw red game over with a black outline
		gameOverStringBounds = drawer.drawCenteredText("Paused",new Color(0, 0, 0, 1),2.05f);
		drawer.drawCenteredText("Paused",new Color(0, 0, 255, 1),2);

		drawMainMenuAndResetButton();
	}


	/**
	 * Draw all the components of the screen
	 * The pause buttons
	 * The score
	 * The bubbles
	 */
	private void drawScreenComponents(){
		drawer.drawTextUpperLeft(Assets.font,GameWorld.gameArray,Assets.fontColor);
		pauseButtonBounds = drawPauseButton();
	}
	/**
	 * Draws a pause button on the upper left side of the screen or a play button
	 * if the game is paused
	 * @return the bounds of the pause button
	 */
	private Rectangle drawPauseButton(){
		final int space = 10;
		batcher.begin();
		batcher.draw((GameWorld.STATE == GameWorld.PAUSED?Assets.resumeButton:pauseButton), Gdx.graphics.getWidth() - pauseButton.getWidth()/2 - space,Gdx.graphics.getHeight() - pauseButton.getHeight()/2 - space,pauseButton.getWidth()/2, pauseButton.getHeight()/2);
		batcher.end();
		return new Rectangle(Gdx.graphics.getWidth() - pauseButton.getWidth()/2 - space,Gdx.graphics.getHeight() - pauseButton.getHeight()/2 - space,pauseButton.getWidth()/2, pauseButton.getHeight()/2);
	}



	/**
	 * Draw the bubbles to the screen so that the red bubbles overlap the green bubbles
	 */
	private void drawBubbles() {
		for(int i = GameWorld.bubbles.size() - 1; i >= 0; i--){
			
			//draw the outside of the bubble
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(Color.WHITE);
			shapeRenderer.circle(GameWorld.bubbles.get(i).x, GameWorld.bubbles.get(i).y,GameWorld.bubbles.get(i).radius);
			shapeRenderer.end();
			
			//draw the inside of the bubble
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(GameWorld.bubbles.get(i).bubbleColor);
			shapeRenderer.circle(GameWorld.bubbles.get(i).x, GameWorld.bubbles.get(i).y,GameWorld.bubbles.get(i).radius*.9f);
			shapeRenderer.end();

			
		}

	}

}
