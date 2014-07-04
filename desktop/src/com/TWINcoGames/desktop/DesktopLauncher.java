package com.TWINcoGames.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.TWINcoGames.DotPop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Dot Pop";
		config.width = 900;
		config.height = 600;
		new LwjglApplication(new DotPop(), config);
	}
}
