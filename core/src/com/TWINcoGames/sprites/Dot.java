//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: sprite
// 
// File   : Dot.java
//
// Date   : Jul 2, 2014
//
// Purpose: An abstract class to hold properties of the dots
//*********************************************************
package com.TWINcoGames.sprites;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;

/**
 * @author Mark
 *
 */
public abstract class Dot {
	/**
	 * @return the sound
	 */
	public Sound getSound() {
		return sound;
	}


	//the location of the ball which is random
	public int x,y;
	//the speed of the ball
	private int dx = -1; 
	private int dy = 3;
	public Color color;
	protected int pointValue;
	protected int timeBonus;
	protected Sound sound;
	public boolean isNewDot = false;
	//the size of the bubble
	int radius = Gdx.graphics.getWidth() > Gdx.graphics.getHeight() ? Gdx.graphics.getWidth()/20 : Gdx.graphics.getHeight() /20;

	/*
	 * What the dot will turn into after it is hit
	 */
	public abstract Dot turnsInTo();


	/**
	 * @return the pointValue
	 */
	public int getPointValue() {
		return pointValue;
	}


	/**
	 * @return the timeBonus
	 */
	public int getTimeBonus() {
		return timeBonus;
	}
	
	/**
	 * The bubble constructor
	 * @param color the color of the bubble, will be either
	 * red or green depending on the bubble
	 */
	public Dot(){
		x = (int)(Math.random()*Gdx.graphics.getWidth()) - radius;
		y = (int)(Math.random()*Gdx.graphics.getHeight()) - radius;
	}
	
	/**
	 * If the dot already exists
	 * @param x
	 * @param y
	 */
	public Dot(int x, int y){}


	public Color getDotColor() {
		return getColor();
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
	 *  Checks if the mouse did click the dot
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


	/**
	 * @return
	 */
	public float getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

}
