//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.sprites
// 
// File   : greenDot.java
//
// Date   : Jul 2, 2014
//
// Purpose: The green dot to be implemented in the game
//*********************************************************
package com.TWINcoGames.sprites;

import com.TWINcoGames.Helpers.Assets;
import com.badlogic.gdx.graphics.Color;

/**
 * @author Mark
 *
 */
public class greenDot extends Dot {
	
	
	public greenDot(){
		color = new Color(0,255,0,1);
		pointValue = 1;
		timeBonus = 1;
		sound = Assets.greenDotPop;
	}
	
	public greenDot(int x, int y){
		super.x = x;
		super.y = y;
		color = new Color(0,255,0,1);
		pointValue = 1;
		timeBonus = 1;
		sound = Assets.greenDotPop;
	}

	/* (non-Javadoc)
	 * @see com.TWINcoGames.sprites.Dot#turnsInTo()
	 */
	@Override
	public Dot turnsInTo() {
		return new redDot(super.x,super.y);
		
	}
}
