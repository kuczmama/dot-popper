//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Screens
// 
// File   : RulesScreen.java
//
// Date   : Jun 14, 2014
//
// Purpose: To display the rules of DotPop
//*********************************************************

package com.TWINcoGames.Screens;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.Helpers.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RulesScreen extends AbstractScreen{
	private DotPop game;
	String rules = "rules";
	
	Texture rulesImage;
	float width = Gdx.graphics.getWidth();
	float height = Gdx.graphics.getHeight();
	

	public RulesScreen(DotPop game) {
		this.game = game;
		rulesImage = Assets.rulesImage;
	}

	@Override
	public void render(float delta){
		// Draws the RGB color 10, 15, 230, at 100% opacity
		screenHelper.clearScreen();
		drawRules();
		screenComponents.drawBackButton();
		update();
	}

	/**
	 * Update method to control what the current screen is
	 */
	public void update(){
			//render the rules screen if the touch is within the ruleBounds
			if(screenHelper.isTouching(screenComponents.backButtonBounds)){
				game.setScreen(new MainScreen(game));
			}
	}
	
	

	/**
	 * draw the rules change the perspective based on lanscape or portrait mode
	 */
	private void drawRules() {
		//batcher.disableBlending();
		batcher.begin();
		//change the perspective based on lanscape or portrait mode
		if(width < height){
			batcher.draw(rulesImage,0,height/2f - width/2f,width,width);
		} else {
			batcher.draw(rulesImage,width/2f - height/2f,0,height,height);
		}
		batcher.end();
	}

}
