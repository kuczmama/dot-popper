package com.TWINcoGames;

import com.TWINcoGames.Helpers.Assets;
import com.TWINcoGames.Screens.MainScreen;
import com.TWINcoGames.Screens.RulesScreen;
import com.TWINcoGames.Screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class DotPop extends Game{
	public SpriteBatch batcher;
	

	public void create() {
		batcher = new SpriteBatch();
		
		setScreen(new SplashScreen(this));
		System.out.println("Bubble Popper Created!!");
		
	}

	public void render() {
		super.render(); //important!
	}

	public void dispose() {
		batcher.dispose();
	}

	

}




