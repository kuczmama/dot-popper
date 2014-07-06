//**********************************************************
// Program: Dot Pop-core
//
// Author : Mark Kuczmarski
//
// Package: com.TWINcoGames
// 
// File   : Settings.java
//
// Date   : Jun 19, 2014
//
// Purpose: The settings of the game
//*********************************************************
package com.TWINcoGames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * @author Mark
 *
 */
public class Settings {
	public static boolean soundEnabled = true;
	public  final static String file = "settings.txt";
	public final static int[] highscores = new int[] {0,0,0,0,0};
	
	/**
	 * Toggle sound enabled back and forth
	 */
	public static void toggleSound(){
		soundEnabled = !soundEnabled;
		save();
	}
	
	/**
	 * Load the setting from file
	 */
	public static void load () {
		try {
			FileHandle filehandle = Gdx.files.local(file);
			
			String[] strings = filehandle.readString().split("\n");
			
			soundEnabled = Boolean.parseBoolean(strings[0]);
			for (int i = 0; i < 5; i++) {
				highscores[i] = Integer.parseInt(strings[i+1]);
			}
			
		} catch (Throwable e) {
			// :( It's ok we have defaults
			
		}
	}
	
	
	/**
	 * Write the settings to a file
	 */
	public static void save () {
		try {
			FileHandle filehandle = Gdx.files.local(file);
			
			filehandle.writeString(Boolean.toString(soundEnabled)+"\n", false);
			for (int i = 0; i < 5; i++) {
				filehandle.writeString(Integer.toString(highscores[i])+"\n", true);
			}
			System.out.println("File created");
		} catch (Throwable e) {
			System.err.println("Error creating file ");
			e.printStackTrace();
		}
	}

	/**
	 * Add a highscore to the highscores array
	 * @param score the score to be added
	 */
	public static void addScore (int score) {
		for (int i = 0; i < 5; i++) {
			if (highscores[i] < score) {
				for (int j = 4; j > i; j--)
					highscores[j] = highscores[j - 1];
				highscores[i] = score;
				break;
			}
		}
		save();
	}
}
