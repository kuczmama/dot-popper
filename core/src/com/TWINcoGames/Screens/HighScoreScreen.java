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

import com.TWINcoGames.DotPop;
import com.TWINcoGames.Settings;
import com.TWINcoGames.Helpers.Assets;
import com.badlogic.gdx.graphics.Color;

/**
 * @author Mark
 *
 */
public class HighScoreScreen extends AbstractScreen{
	private DotPop game;
	private Color fontColor;
	
	HighScoreScreen(DotPop game){
		this.game = game;
		fontColor = new Color(1f,1f,1f,1f);
	}
	
	@Override
	public void render(float delta){
		// Draws the RGB color 10, 15, 230, at 100% opacity
		screenHelper.setBackgroundColor( new Color(0.145098039f,0.717647059f,0.917647059f,1f));
		screenComponents.drawBackButton();
		update();
	}
	
	public void update(){
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
