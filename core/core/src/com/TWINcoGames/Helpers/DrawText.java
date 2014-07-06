//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.Helpers
// 
// File   : DrawText.java
//
// Date   : Jun 14, 2014
//
// Purpose: Draw text to the screen
//*********************************************************
package com.TWINcoGames.Helpers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * @author Mark
 *
 */
public class DrawText {
	public SpriteBatch batcher;

	public DrawText(){
		batcher = new SpriteBatch();
	}

	/**
	 * Method needed to start drawing text using default values
	 */
	private void beginDefaultDrawing(){
		batcher.begin();
		Assets.font.setColor(Assets.fontColor);
		Assets.font.setScale(1.5f);
	}
	
	public void drawCenteredTextFromTopDown(BitmapFont font,String[] messages,Color color){
		if(messages.length <= 0){
			System.err.println("String[] must be a positive length");
		}
		float spacing = font.getBounds("test").height*2;
		//the size of all of the messages
		float space = spacing*1.5f;
		batcher.begin();
		font.setColor(color);
		font.setScale(1.5f);
		for(String str : messages){
			font.draw(batcher,
					str,
					Gdx.graphics.getWidth()/2 - font.getBounds((String)str).width/2,
					space);
			space += spacing;
		}
		batcher.end();
	}

	/**
	 * Draw the string arr centered on the string
	 * @param objects the array of strings to be drawn centered
	 * @param font the type of font to be used
	 */
	public void drawCenteredText(BitmapFont font,Object[] objects,Color color) {
		float spacing = font.getBounds("test").height*2;
		float space = -objects.length*spacing;
		//center the text
		batcher.begin();
		font.setColor(color);
		font.setScale(1.5f);
		for(Object message: objects){
			font.draw(batcher,
					(String)message,
					Gdx.graphics.getWidth()/2 - font.getBounds((String)message).width/2,
					Gdx.graphics.getWidth()/2 + 2*font.getBounds((String)message).height/2+ space);
			space += spacing;
		}
		batcher.end();
	}//end drawCenteredText

	/**
	 * Draw the string str with the default game font and the default color
	 * found in the assets file
	 * @param str the string to be drawn centered
	 */
	public Rectangle drawCenteredText(String str){
		beginDefaultDrawing();
		Assets.font.draw(batcher,
				str,
				Gdx.graphics.getWidth()/2 - Assets.font.getBounds(str).width/2,
				Gdx.graphics.getHeight()/2 + Assets.font.getBounds(str).height/2);
		batcher.end();
		return new Rectangle(
				Gdx.graphics.getWidth()/2 - Assets.font.getBounds(str).width/2,
				Gdx.graphics.getHeight()/2 + Assets.font.getBounds(str).height/2,
				Assets.font.getBounds(str).width,
				Assets.font.getBounds(str).height);
	}
	
	/**
	 * Draw centered text with a default font and a custom color
	 * @param str the string to be drawn
	 * @param color the custom color
	 * @param scale the scale of the font
	 * @return The bounds of the centered text
	 */
	public Rectangle drawCenteredText(String str, Color color,float scale){
		batcher.begin();
		Assets.font.setColor(color);
		Assets.font.setScale(scale);
		Assets.font.draw(batcher,
				str,
				Gdx.graphics.getWidth()/2 - Assets.font.getBounds(str).width/2,
				Gdx.graphics.getHeight()/2 + Assets.font.getBounds(str).height/2);
		batcher.end();
		return new Rectangle(
				Gdx.graphics.getWidth()/2 - Assets.font.getBounds(str).width/2,
				Gdx.graphics.getHeight()/2 + Assets.font.getBounds(str).height/2,
				Assets.font.getBounds(str).width,
				Assets.font.getBounds(str).height);
	}
	
	/**
	 * Draw text to the screen in the position x,y using the default text values
	 * @param str the string to be drawn
	 * @param x the x position
	 * @param y the y position
	 * @return the Rectangle containing the bounds of the text
	 */
	public Rectangle drawText(String str,float x,float y){
		beginDefaultDrawing();
		Assets.font.draw(batcher,
				str,
				x,
				y);
		batcher.end();
		return new Rectangle(x,y - Assets.font.getBounds(str).height,
				Assets.font.getBounds(str).width,
				Assets.font.getBounds(str).height);
	}

	/**
	 * Draw string str to the screen 
	 * @param str the string to be drawn
	 * @return A rectangle with the bounds of the text
	 */
	public Rectangle drawTextUpperLeft(String str){
		beginDefaultDrawing();
		float x = Assets.font.getBounds(str).height;
		float space = Assets.font.getSpaceWidth();
		float y = Gdx.graphics.getHeight() - space;

		Assets.font.draw(batcher,str, x,y);

		batcher.end();
		return new Rectangle(x, y - Assets.font.getBounds(str).height,Assets.font.getBounds(str).width, Assets.font.getBounds(str).height);

	}


	/**
	 * Draw text in the upper left hand corner
	 * @param arr the array of text strings to be drawn
	 * @param font the font to use
	 */
	public void drawTextUpperLeft( BitmapFont font, ArrayList<String> arr, Color color){
		batcher.begin();
		font.setColor(color);
		float spacing = font.getSpaceWidth() + font.getBounds("test").height;
		float space = font.getSpaceWidth();
		for(String message: arr){
			font.draw(batcher, message,font.getBounds("test").height,Gdx.graphics.getHeight() - space);
			space += spacing;
		}
		batcher.end();
	}
}
