//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames
// 
// File   : ScreenComponents.java
//
// Date   : Jun 21, 2014
//
// Purpose: Generic objects that can be included on all of the screens
//			this class both creates and draws the components to the screen
//*********************************************************
package com.TWINcoGames;

import com.TWINcoGames.Helpers.DrawText;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Mark
 *
 */
public class ScreenComponents {
	public Rectangle backButtonBounds;
	private DrawText drawer;
	private SpriteBatch batcher;
	
	public ScreenComponents(){
		drawer = new DrawText();
		batcher = new SpriteBatch();
		initialize();
	}
	
	/**
	 * Initialize all of the screen components
	 */
	private void initialize() {
		
		
	}

	/**
	 * draw the backbutton
	 */
	public void drawBackButton() {
		backButtonBounds = drawer.drawTextUpperLeft("Back");		
	}
	
}
