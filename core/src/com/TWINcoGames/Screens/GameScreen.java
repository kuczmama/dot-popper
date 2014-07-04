//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Screens
// 
// File   : GameScreen.java
//
// Date   : Jun 14, 2014
//
// Purpose: Screen to display Dot Pop Game
//*********************************************************
package com.TWINcoGames.Screens;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.GameWorld.GameRenderer;
import com.TWINcoGames.GameWorld.GameWorld;
import com.TWINcoGames.Helpers.InputHandler;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * @author Mark
 *
 */
public class GameScreen extends ScreenAdapter{
	ScreenHelper screenHelper;
	private GameWorld world;
	private GameRenderer gameRenderer;
	private DotPop game;
	
	
	public GameScreen(DotPop game){
		this.game = game;
		screenHelper = new ScreenHelper();
		world = new GameWorld(game);
		gameRenderer = new GameRenderer(world);
		Gdx.input.setInputProcessor(new InputHandler());
	}
	
	@Override
	public void render(float delta){
		screenHelper.clearScreen();
		world.update(delta/3);
		update();
		
	}

	/**
	 * updates the current game screen state
	 */
	private void update() {
		updateScreenState();
		
	}
	
	/**
	 * Change the text on the screen based on the current state of the screen
	 */
	private void updateScreenState(){
		if(GameWorld.STATE == GameWorld.PLAYING){
			gameRenderer.playingState();
			listenForPauseButton();
		} else if(GameWorld.STATE == GameWorld.READY){
			gameRenderer.readyState();
		} else if(GameWorld.STATE == GameWorld.PAUSED){
			gameRenderer.pausedState();
			listenForPauseButton();
			listenForMainButtonAndResetButton();
		} else if(GameWorld.STATE == GameWorld.GAME_OVER){
			gameRenderer.gameOverState();
			listenForMainButtonAndResetButton();
	
		}
	}
	
	/**
	 * Listen for the user clicking the main button
	 * or the reset button
	 */
	private void listenForMainButtonAndResetButton(){
		if(Gdx.input.justTouched() && screenHelper.isTouching(gameRenderer.mainMenuButtonBounds)){
			game.setScreen(new MainScreen(game));
		}else if(Gdx.input.justTouched() && screenHelper.isTouching(gameRenderer.resetButtonBounds)){
			world.resetGame();
		}
	}
	
	/**
	 * Listen for the user to click the pause button
	 */
	private void listenForPauseButton(){
		if(Gdx.input.justTouched() && screenHelper.isTouching(gameRenderer.pauseButtonBounds) && GameWorld.STATE == GameWorld.PLAYING){
			GameWorld.STATE = GameWorld.PAUSED;
		}else if(Gdx.input.justTouched() && screenHelper.isTouching(gameRenderer.pauseButtonBounds) && GameWorld.STATE == GameWorld.PAUSED){
			GameWorld.STATE = GameWorld.PLAYING;
		}
	}

}
