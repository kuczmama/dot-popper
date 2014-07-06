package com.TWINcoGames.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;


public class Bubble{
	
	//the location of the ball which is random
	public int x,y;

	//the speed of the ball
	private int dx = -1; 
	private int dy = 3;
	public Color bubbleColor;
	
//	private Color bubbleColor = Color.GREEN;
	//the size of the bubble
	int radius = Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Gdx.graphics.getWidth()/20 : Gdx.graphics.getHeight() /20;
	/**
	 * The bubble constructor
	 * @param bubbleColor the color of the bubble, will be either
	 * red or green depending on the bubble
	 */
	public Bubble(Color bubbleColor) {
		x = (int)(Math.random()*Gdx.graphics.getWidth()) - radius;
		y = (int)(Math.random()*Gdx.graphics.getHeight()) - radius;
		this.bubbleColor = bubbleColor;

	}

	public Color getBubbleColor() {
		return bubbleColor;
	}

	public void setBubbleColor(Color bubbleColor) {
		this.bubbleColor = bubbleColor;
	}
	
	/**
	 * Handle the logic for drawing the bubble
	 */
	public void update(){
		x += dx;
		y += dy;
		if(x + radius > Gdx.graphics.getWidth()){
			x = Gdx.graphics.getWidth() - radius;
			dx = - dx;
		}

		if(x<radius){
			x = radius;
			dx = -dx;
		}

		if(y + radius > Gdx.graphics.getHeight()){
			y = Gdx.graphics.getHeight() - radius;
			dy = -dy;

		}

		if(y<radius){
			y = radius;
			dy = -dy;

		}
	}

	/**
	 *  Checks if the mouse did click the bubble
	 * @param px the x position
	 * @param py the y position
	 * @return true if the bubble was hit
	 */
	public boolean didHit(int px, int py){
		int r = radius;
		int y2 = Gdx.graphics.getHeight() - y;
		double dx = px - x;
		double dy = py - y2;		
		return (dx*dx+dy*dy) <= r*r;
	}
}