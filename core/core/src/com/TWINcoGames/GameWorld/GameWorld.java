package com.TWINcoGames.GameWorld;

import java.util.ArrayList;

import com.TWINcoGames.DotPop;
import com.TWINcoGames.Settings;
import com.TWINcoGames.Helpers.Assets;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

public class GameWorld{

	public static final int PLAYING = 0;
	public static final int PAUSED = 1;
	public static final int READY = 2;
	public static final int GAME_OVER = 3;
	public static int STATE;
	static ArrayList<Bubble> bubbles;
	static ArrayList<Bubble> hit;
	//a green bubble
	static Color GOOD_BUBBLE = new Color(0,255,0,1);
	//a red bubble
	static Color BAD_BUBBLE = new Color(255,0,0,1);
	static int score;
	public static String scoreString;
	//the constructor
	long start;
	final int START_TIME = 10;
	public static int time;
	static DotPop dotPop;
	//public static boolean isPlaying;
	public static int highScore;

	public static ArrayList<String> gameArray = new ArrayList<String>();
	int state;

	/**
	 * Create a new game world
	 * @param dotPop
	 */
	public GameWorld(DotPop dotPop){
		//check if the game is paused
		//if it isn't start a new game
		System.out.println("State " + STATE);
		if(STATE != PAUSED ){
			newGame();
		} else {
			STATE = READY;
			start = TimeUtils.millis();
		}
	}

	/**
	 * Sets up a new game
	 */
	private void newGame(){
		start = TimeUtils.millis();
		STATE = READY;
		time = START_TIME;
		score = 0;
		bubbles = new ArrayList<Bubble>();
		hit = new ArrayList<Bubble>();
		bubbles.add(new Bubble(GOOD_BUBBLE));
	}

	//update the game world
	public void update(float delta) {
		switch(STATE){
		case PLAYING:
			System.out.println("playin");
			updateTime();
			updateScoreString(); 
			drawScoreAndTimeArray();
			for(Bubble bubble : bubbles){
				bubble.update();
			}
			checkGameOver();
			break;
		}

	}

	/**
	 * update the score array which displays the score : <score>
	 * and it displays the current time          time  : <time>
	 */
	private static void drawScoreAndTimeArray(){
		gameArray.clear();
		gameArray.add("Score " + Integer.toString(score));
		gameArray.add("Time " + String.format("%d", time));
	}

	private void updateScoreString() {
		scoreString = Integer.toString(score);
	}

	/**
	 * Displays different screens depending whether or not the player is playing
	 */
	private void checkGameOver() {
		if(time <= 0 && STATE == PLAYING){
			endGame();
		}
	}

	/**
	 * Method that is called when the game ends
	 * resets a lot of things
	 */
	private void endGame() {
		STATE = GAME_OVER;
		Settings.addScore(score);
		drawScoreAndTimeArray();

	}

	/**
	 * Set the highscore
	 */
	private void setHighScore(){
		
		if(score >= highScore)
			highScore = score;
	}

	/**
	 * Change the game state to ready
	 */
	public void resetGame(){
		time = START_TIME;
		bubbles.clear();
		hit.clear();
		Color green = new Color(0,255,0,1);
		bubbles.add(new Bubble(green));
		//if the score beats the highscore change it
		System.out.println("score " + score);
		setHighScore();
		//reset the score
		score = 0;
		STATE = READY;
	}

	/**
	 * Update the countdown timer if the game is playing
	 */
	private void updateTime() {
		if( (int)((TimeUtils.millis() - start)) >= 1000 && STATE == PLAYING){
			start = TimeUtils.millis();
			time --;
		}
	}

	/**
	 * Add a bubble to the bubbles array 
	 * @param c the color of the bubble to be added
	 */
	public static void addBubble(Color c){
		bubbles.add(new Bubble(c));
	}

	/**
	 * Process the hit of the bubble b
	 * If the bubble is hit the score + 1
	 * else the score is decremented by 2
	 * @param b the bubble to be processed
	 */
	static void processHit(Bubble b){
		if(b.getBubbleColor().equals(GOOD_BUBBLE)){
			score++;
			if(score >= highScore){
				highScore = score;
				System.out.println("highscore " + highScore);
			}
			time++;
			playBubbleHitSound(Assets.greenDotPop);
		} else {
			score -= 2;
			time -= 2;
			playBubbleHitSound(Assets.redDotPop);
		}
		System.out.println(score);
	}

	/**
	 * Play a sound for each bubble hit if the sound is enabled
	 * @param sound the sound to be played
	 */
	private static void playBubbleHitSound(Sound sound){
		if(Settings.soundEnabled){
			sound.play(1.0f);
		}
	}

	/**
	 * Checks the mouse events to see whether or not a bubble has been hit
	 * 
	 */
	public static void mousePressed(int x, int y) {
		if(STATE != PAUSED && STATE != GAME_OVER){
			hit.clear();
			System.out.println("Bubbles size " + bubbles.size());
			for(int i = bubbles.size() -1; i >= 0; i--){
				Bubble b = bubbles.get(i);
				if(b.didHit(x, y)){
					System.out.println("hit");
					processHit(b);
					hit.add(b);
				}else {
					System.out.println("No hit");
				}
			}
			for(Bubble b: hit){
				System.out.println("process hits");
				if(b.getBubbleColor().equals(GOOD_BUBBLE)){
					System.out.println("Bubble hit");
					addBubble(GOOD_BUBBLE);
					b.setBubbleColor(BAD_BUBBLE);
				}
			}
		}
	}

}