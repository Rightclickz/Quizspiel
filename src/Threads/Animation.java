package Threads;

import java.awt.Cursor;

import DBReader.MySqlConnection;
import GameManager.HighscoreCount;
import GameManager.TextContent;
import ImageManager.ImageManager;
import Interface.Gui;

public class Animation extends Thread {
	
	private Gui ui;
	private ImageManager manager;
	private static int timer;
	private static boolean outOfTime;
	private static boolean enterScreen;
	private static boolean questionScreen;
	private static boolean answerScreen;
	private static boolean timerScreen;
	private static boolean choosenAnswer;
	
	public Animation(Gui ui, ImageManager manager) {
		this.ui = ui;
		this.manager = manager;
		enterScreen = false;
		questionScreen = false;
		answerScreen = false;
		timerScreen = false;
		choosenAnswer = false;
		outOfTime = false;
		timer = 30;
		TextContent.buildAnswerOrder();
	}

	public static boolean isQuestionScreen() {
		return questionScreen;
	}

	public static boolean isAnswerScreen() {
		return answerScreen;
	}

	public static boolean isEnterScreen() {
		return enterScreen;
	}

	public static boolean isTimerScreen() {
		return timerScreen;
	}

	public static boolean isChoosenAnswer() {
		return choosenAnswer;
	}
	
	public static boolean isOutOfTime() {
		return outOfTime;
	}

	public static void setChoosenAnswer(boolean choosenAnswer) {
		Animation.choosenAnswer = choosenAnswer;
	}

	public static int getTimer() {
		return timer;
	}

	public void run() {
		startIntro();
		startQuestionBorderAnimation();
		startTimerBorderAnimation();
		startAnswerBorderAnimation();
	}
	
	private void startIntro() {
		manager.getHandler().saveImage(0, 0, callSqlByTag("transBorder"));
		enterScreen = true;
		ui.repaint();
		long startCount = System.currentTimeMillis();
		do {
			if (startCount + 2500 <= System.currentTimeMillis()) {
				manager.getHandler().getMenuImages().remove(7);
				enterScreen = false;
				ui.repaint();
				break;
			}
		} while (true);
	}
	
	private void startQuestionBorderAnimation() {
		long startCount = System.currentTimeMillis();
		do {
			if (startCount + 12 <= System.currentTimeMillis()) {
				manager.getHandler().getMenuImages().get(1).setY(manager.getHandler().getMenuImages().get(1).getY() + 5);
				startCount = System.currentTimeMillis();
				ui.repaint();
			}
			if (manager.getHandler().getMenuImages().get(1).getY() == 100) {
				questionScreen = true;
				break;
			}
		} while (true);
	}
	
	private void startTimerBorderAnimation() {
		long startCount = System.currentTimeMillis();
		do {
			if (startCount + 12 <= System.currentTimeMillis()) {
				manager.getHandler().getMenuImages().get(6).setY(manager.getHandler().getMenuImages().get(6).getY() - 5);
				startCount = System.currentTimeMillis();
				ui.repaint();
			}
			if (manager.getHandler().getMenuImages().get(6).getY() == 588) {
				timerScreen = true;
				break;
			}
		} while (true);
	}
	
	private void startAnswerBorderAnimation() {
		long startCount = System.currentTimeMillis();
		do {
			if (startCount + 8 <= System.currentTimeMillis()) {
				manager.getHandler().getMenuImages().get(2).setX(manager.getHandler().getMenuImages().get(2).getX() + 5);
				manager.getHandler().getMenuImages().get(3).setX(manager.getHandler().getMenuImages().get(3).getX() - 5);
				manager.getHandler().getMenuImages().get(4).setX(manager.getHandler().getMenuImages().get(4).getX() + 5);
				manager.getHandler().getMenuImages().get(5).setX(manager.getHandler().getMenuImages().get(5).getX() - 5);
				startCount = System.currentTimeMillis();
				ui.repaint();
			}
			if (manager.getHandler().getMenuImages().get(2).getX() == 200) {
				answerScreen = true;
				setChoosenAnswer(false);
				break;
			}
		} while (true);
		startTimer();
	}
	
	private void startTimer() {
		long startCount = System.currentTimeMillis();
		do {
			if (startCount + 1000 <= System.currentTimeMillis()) {
				timer--;
				ui.repaint();
				startCount = System.currentTimeMillis();
			}
			if (timer == 0) {
				outOfTime = true;
				outOfTime();
				break;
			}
		} while (!choosenAnswer);
	}
	
	private void outOfTime() {
		manager.getHandler().getMenuImages().get(TextContent.getRightAnswer()+1).setSprite(callSqlByTag("answerBorderRight"));
		ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		ui.repaint();
		HighscoreCount.saveQuestionStatistics();
		Thread timer = new Thread(new QuestionDelay(ui));
		timer.start();
	}
	
	private String callSqlByTag(String tag) {
		return MySqlConnection.getSingleEntry("link, name", 1, "ImageLinks", " Where name like '" + tag + "'");
	}
	
	public static void returnToMainMenu() {
		enterScreen = false;
		questionScreen = false;
		answerScreen = false;
		timerScreen = false;
		choosenAnswer = false;
		outOfTime = false;
	}
}
