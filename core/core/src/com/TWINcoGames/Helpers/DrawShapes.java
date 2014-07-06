//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Helpers
// 
// File   : DrawShapes.java
//
// Date   : Jun 14, 2014
//
// Purpose:
//*********************************************************
package com.TWINcoGames.Helpers;

import com.TWINcoGames.GameWorld.GameRenderer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Mark
 *
 */
public class DrawShapes {
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	
	public DrawShapes(){
		shapeRenderer = new ShapeRenderer();
		batcher = new SpriteBatch();
	}
	
	/**
	 * Draw a rectangle to the screen
	 * @param rect the rectangle to be drawn
	 */
	public void drawRectangle(Rectangle rect){
				batcher.begin();
				shapeRenderer.begin(ShapeType.Line);
				//draw the inside of the bubble
				shapeRenderer.setColor(new Color(255, 0, 0, 1));
				shapeRenderer.rect(rect.x,rect.y,rect.width,rect.height);
				shapeRenderer.end();
				batcher.end();
	}
}
