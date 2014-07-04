package com.TWINcoGames.Screens;

import java.util.ArrayList;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.Settings;
import com.TWINcoGames.GameWorld.GameWorld;
import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Helpers.DrawShapes;
import com.TWINcoGames.Helpers.DrawText;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MainScreen extends ScreenAdapter {

	public static ArrayList<String> welcomeArray = new ArrayList<String>();
	//a rectangle to go the the rules screen
	private Rectangle rulesBounds;
	private DrawText drawer;
	protected MainScreen mainScreen;
	protected DotPop game;
	private ScreenHelper screenHelper;
	//to keep track of where the user touches'
	DrawText textDrawer = new DrawText();
	DrawShapes shapeDrawer;
	private Texture highScoreButton;
	private Texture playButton;
	private Texture rulesButton;
	private Texture soundOffButton;
	private Texture soundOnButton;
	
	private final int BUTTON_DIAMETER = (Gdx.graphics.getWidth() < Gdx.graphics.getHeight())? (int)(Gdx.graphics.getWidth()/2): (int)(Gdx.graphics.getHeight()/2);
	private SpriteBatch batcher;
	private Rectangle playBounds;
	private Rectangle soundBounds;
	private Rectangle highScoreBounds;

	public MainScreen(DotPop game) {
		this.game = game;
		batcher = game.batcher;
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
		rulesBounds = new Rectangle(0,0,BUTTON_DIAMETER, BUTTON_DIAMETER);
		playBounds = new Rectangle(0,BUTTON_DIAMETER,BUTTON_DIAMETER,BUTTON_DIAMETER);
		soundBounds = new Rectangle(BUTTON_DIAMETER, 0, BUTTON_DIAMETER,BUTTON_DIAMETER);
		highScoreBounds = new Rectangle(BUTTON_DIAMETER,BUTTON_DIAMETER,BUTTON_DIAMETER,BUTTON_DIAMETER);
		
		//initialize buttons
		highScoreButton = Assets.highScoreButton;
		playButton = Assets.playButton;
		rulesButton = Assets.rulesButton;
		soundOffButton = Assets.soundOffButton;
		soundOnButton = Assets.soundOnButton;
		
		drawer = new DrawText();
		screenHelper = new ScreenHelper();
		shapeDrawer = new DrawShapes();
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
	private void update(){		
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
		batcher.begin();
		batcher.draw(rulesButton,rulesBounds.x,rulesBounds.y,rulesBounds.width,rulesBounds.height);
		batcher.draw(playButton,playBounds.x,playBounds.y,playBounds.width,playBounds.height);
		batcher.draw(highScoreButton,highScoreBounds.x,highScoreBounds.y,highScoreBounds.width,highScoreBounds.height);
		
		//draw the sound on button if the sound is on, the sound off button if the sound is off
		batcher.draw((Settings.soundEnabled?soundOnButton: soundOffButton),soundBounds.x,soundBounds.y,soundBounds.width,soundBounds.height);
		batcher.end();
	}


}
