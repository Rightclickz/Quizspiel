package Threads;

import GameManager.Game;
import GameManager.HighscoreCount;
import GuiManager.Statistic;
import ImageManager.ImageManager;
import Interface.Gui;
import UserAPI.IOManager;

public class QuestionDelay extends Thread {

	private int delay;
	private static Gui ui;
	private static int questionCount = 1;
	private ImageManager manager;
	
	public QuestionDelay(Gui ui) {
		QuestionDelay.ui = ui;
		questionCount++;
		delay = 2500;
	}
	
	public void run() {
		long startTime = System.currentTimeMillis();
		do {
			if (startTime + delay <= System.currentTimeMillis()) {
				if (questionCount <= 10) {
					Game.newQuestion();
				} else {
					questionCount = 1;
					Animation.returnToMainMenu();
					manager = new Statistic();
					Gui.setImageManager(manager);
					IOManager.setImageManager(manager);
					HighscoreCount.checkHighscore();
					Statistic.setStatisticScreen(true);
					IOManager.getSoundClass().updateSound("mainTheme");
					IOManager.getSoundClass().startSound(-20f, MAX_PRIORITY);
					ui.repaint();
				}
				break;
			}
		} while (true);
	}
}
