//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Screens
// 
// File   : AbstractScreen.java
//
// Date   : Jul 2, 2014
//
// Purpose: Abstract class to avoid reusing screen components
//*********************************************************
package com.TWINcoGames.Screens;

import com.TWINcoGames.ScreenComponents;
import com.TWINcoGames.Helpers.DrawShapes;
import com.TWINcoGames.Helpers.DrawText;
import com.TWINcoGames.Helpers.ScreenHelper;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Mark
 *
 */
public abstract class AbstractScreen  extends ScreenAdapter {
	protected ScreenHelper screenHelper;
	protected DrawText drawer;
	protected ScreenComponents screenComponents;
	protected SpriteBatch batcher;
	protected DrawShapes drawShape;
	
	
	protected AbstractScreen() {
		screenHelper = new ScreenHelper();
		drawer = new DrawText();
		screenComponents = new ScreenComponents();
		batcher = new SpriteBatch();
		drawShape = new DrawShapes();
	}
	
	
	@Override
	public abstract void render(float delta);
	protected abstract void update();
}
