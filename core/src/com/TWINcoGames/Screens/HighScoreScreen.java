//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Screens
// 
// File   : HighScoreScreen.java
//
// Date   : Jun 21, 2014
//
// Purpose: Displays the top 5 highscores to the screen
//*********************************************************
package com.TWINcoGames.Screens;

import sun.java2d.loops.DrawGlyphListAA;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.ScreenComponents;
import com.TWINcoGames.Settings;
import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Helpers.DrawText;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Mark
 *
 */
public class HighScoreScreen extends ScreenAdapter{
	private DotPop game;
	private SpriteBatch batcher;
	private ScreenHelper screenHelper;
	private DrawText drawer;
	private ScreenComponents screenComponents;
	private Color fontColor;
	
	HighScoreScreen(DotPop game){
		this.game = game;
		this.batcher = game.batcher;
		screenHelper = new ScreenHelper();
		drawer = new DrawText();
		screenComponents = new ScreenComponents();
		fontColor = new Color(1f,1f,1f,1f);
	}
	
	@Override
	public void render(float delta){
		// Draws the RGB color 10, 15, 230, at 100% opacity
		screenHelper.setBackgroundColor( new Color(0.145098039f,0.717647059f,0.917647059f,1f));
		screenComponents.drawBackButton();
		update();
	}
	
	private void update(){
		drawHighScores();
		if(screenHelper.isTouching(screenComponents.backButtonBounds)){
			game.setScreen(new MainScreen(game));
		}
	}
	
	

	/**
	 * Draw the array of strings known as the highscores to the screen
	 */
	private void drawHighScores() {
		Settings.load();
		String[] highScores = new String[Settings.highscores.length + 1];
		//convert string[] to object array
		for(int i = highScores.length - 2 ; i >= 0; i--){
			highScores[i] = Integer.toString(highScores.length - i - 1) + " .   "  + Integer.toString(Settings.highscores[Settings.highscores.length - 1 - i]);
		}
		highScores[Settings.highscores.length] = "High Scores";
		//draw the highscores
		drawer.drawCenteredTextFromTopDown(Assets.font,highScores,fontColor);
	}
}
