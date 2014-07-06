package com.TWINcoGames.Screens;

import java.util.ArrayList;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.Settings;
import com.TWINcoGames.GameWorld.GameWorld;
import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class MainScreen extends AbstractScreen {

	public static ArrayList<String> welcomeArray = new ArrayList<String>();
	//a rectangle to go the the rules screen
	private Rectangle rulesBounds;
	protected DotPop game;
	private Texture highScoreButton;
	private Texture playButton;
	private Texture rulesButton;
	private Texture soundOffButton;
	private Texture soundOnButton;
	private final int BUTTON_DIAMETER = (Gdx.graphics.getWidth() < Gdx.graphics.getHeight())? (int)(Gdx.graphics.getWidth()/2): (int)(Gdx.graphics.getHeight()/2);
	private Rectangle playBounds;
	private Rectangle soundBounds;
	private Rectangle highScoreBounds;

	public MainScreen(DotPop game) {
		this.game = game;
		initialize();
	}

	/**
	 * initialize the game
	 * by setting the game state to GAME_READY
	 * Create a new GameWorld Object
	 * and create a GameRenderer object
	 * Then setup a listener
	 */
	private void initialize(){ 
		getWelcomeMessage();
		rulesBounds = new Rectangle(Gdx.graphics.getWidth()/2f  - BUTTON_DIAMETER/2f -  BUTTON_DIAMETER/2f,Gdx.graphics.getHeight()/2f - BUTTON_DIAMETER/2f - BUTTON_DIAMETER/2f,BUTTON_DIAMETER, BUTTON_DIAMETER);
		playBounds = new Rectangle(Gdx.graphics.getWidth()/2f  - BUTTON_DIAMETER/2f  -  BUTTON_DIAMETER/2f,Gdx.graphics.getHeight()/2f-BUTTON_DIAMETER/2.0f+BUTTON_DIAMETER/2f,BUTTON_DIAMETER,BUTTON_DIAMETER);
		soundBounds = new Rectangle(Gdx.graphics.getWidth()/2f - BUTTON_DIAMETER/2 + BUTTON_DIAMETER/2f, Gdx.graphics.getHeight()/2f-BUTTON_DIAMETER/2.0f-BUTTON_DIAMETER/2f, BUTTON_DIAMETER,BUTTON_DIAMETER);
		highScoreBounds = new Rectangle(Gdx.graphics.getWidth()/2f  - BUTTON_DIAMETER/2 + BUTTON_DIAMETER/2f,Gdx.graphics.getHeight()/2f-BUTTON_DIAMETER/2.0f+BUTTON_DIAMETER/2f,BUTTON_DIAMETER,BUTTON_DIAMETER);
		
		//initialize buttons
		highScoreButton = Assets.highScoreButton;
		playButton = Assets.playButton;
		rulesButton = Assets.rulesButton;
		soundOffButton = Assets.soundOffButton;
		soundOnButton = Assets.soundOnButton;
		screenHelper = new ScreenHelper();
		System.out.println("GameScreen Attached");
	}

	/**
	 * Create the welcome message being displayed on the splash page
	 */
	private void getWelcomeMessage(){
		welcomeArray.clear();
		welcomeArray.add("Tap anywhere to begin");
		welcomeArray.add("Your HighScore " + Integer.toString(GameWorld.highScore)); 
		welcomeArray.add("Welcome to Dot Pop!!");
	}

	/**
	 * Update method to control what the current screen is
	 */
	public void update(){		
			//render the rules screen if the touch is within the ruleBounds
			if(screenHelper.isTouching(rulesBounds)){
				game.setScreen(new RulesScreen(game));
			}else if(screenHelper.isTouching(playBounds)){
				game.setScreen(new GameScreen(game));
			}else if(screenHelper.isTouching(soundBounds)){
				Settings.toggleSound();
			}else if(screenHelper.isTouching(highScoreBounds)){
				game.setScreen(new HighScoreScreen(game));
			}
	}

	@Override
	public void render(float delta) {
		screenHelper.setBackgroundColor(Assets.backgroundColor2);
		update();
		draw();
	}

	/**
	 * Draw the respective links and text onto the screen
	 */
	private void draw(){
		drawButtons();
	}
	
	/**
	 * Draw
	 * 	- play button
	 *  - sound on button
	 *  - sound off button
	 *  - high score button
	 *  - rules button
	 */
	private void drawButtons(){
		drawShape.drawImageWithBounds(rulesButton, rulesBounds);
		drawShape.drawImageWithBounds(playButton, playBounds);
		drawShape.drawImageWithBounds(highScoreButton, highScoreBounds);
		drawShape.drawImageWithBounds((Settings.soundEnabled?soundOnButton: soundOffButton),soundBounds);
	}


}
