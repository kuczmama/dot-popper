package com.TWINcoGames;

import com.TWINcoGames.Screens.SplashScreen;
import com.badlogic.gdx.Game;


public class DotPop extends Game{

	public void create() {
		setScreen(new SplashScreen(this));
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
	}

	

}




