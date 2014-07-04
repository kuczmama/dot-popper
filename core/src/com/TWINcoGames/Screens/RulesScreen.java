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
import com.TWINcoGames.ScreenComponents;
import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Helpers.DrawShapes;
import com.TWINcoGames.Helpers.DrawText;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

public class RulesScreen extends ScreenAdapter{
	private DotPop game;
	private DrawText drawer;
	private ScreenComponents screenComponents;
	String rules = "rules";
	ScreenHelper screenHelper;
	
	DrawShapes drawShape;
	Texture rulesImage;
	SpriteBatch batcher;
	FrameBuffer frameBuffer = null;
	float width = Gdx.graphics.getWidth();
	float height = Gdx.graphics.getHeight();
	

	public RulesScreen(DotPop game) {
		this.game = game;
		screenComponents = new ScreenComponents();
		drawer = new DrawText();
		screenHelper = new ScreenHelper();
		drawShape = new DrawShapes();
		rulesImage = Assets.rulesImage;
		batcher = game.batcher;
		
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
	private void update(){
			
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
			batcher.draw(rulesImage,0,.25f*width,width,width);
		} else {
			batcher.draw(rulesImage,.25f*height,0,height,height);
			
		}
		batcher.end();
	}

}
