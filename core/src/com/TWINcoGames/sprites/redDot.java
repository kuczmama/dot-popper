//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames.sprites
// 
// File   : redDot.java
//
// Date   : Jul 2, 2014
//
// Purpose: The red dot which is the bad dot
//*********************************************************
package com.TWINcoGames.sprites;

import com.TWINcoGames.Helpers.Assets;
import com.badlogic.gdx.graphics.Color;


/**
* @author Mark
*
*/
public class redDot extends Dot {
	
	public redDot(int x, int y){
		super.x = x;
		super.y = y;
		color  = new Color(255,0,0,1);
		pointValue = -2;
		timeBonus = -2;
		sound = Assets.redDotPop;
	}
	
	public redDot(){
		color  = new Color(255,0,0,1);
		pointValue = -2;
		timeBonus = -2;
		sound = Assets.redDotPop;
	}
	

	/* (non-Javadoc)
	 * @see com.TWINcoGames.sprites.Dot#turnsInTo()
	 */
	@Override
	public Dot turnsInTo() {
		///doesn't turn into anything
		return null;
	}
}
