package GuiManager;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import GameManager.HighscoreCount;
import ImageManager.ImageManager;
import Interface.Gui;
import UserAPI.IOManager;

public class Statistic extends ImageManager {
	
	private static ArrayList<ArrayList<String>> statistic;
	private static int[] statisticCords;
	private static boolean statisticScreen;

	public Statistic() {
		super();
		fillImages();
		statistic = new ArrayList<ArrayList<String>>();
		statisticCords = new int[6];
		insertStatistic();
		setCords();
	}
	
	public static ArrayList<ArrayList<String>> getStatistic() {
		return statistic;
	}

	public static int[] getStatisticCords() {
		return statisticCords;
	}

	public static boolean isStatisticScreen() {
		return statisticScreen;
	}

	public static void setStatisticScreen(boolean statisticScreen) {
		Statistic.statisticScreen = statisticScreen;
	}
	
	private void insertStatistic() {
		for (int count = 0; count < 10; count++) {
			ArrayList<String> newList = new ArrayList<String>();
			newList.add("Frage " + (count + 1));
			newList.add((HighscoreCount.getRightQuestions()[count]) ? "Richtig" : "Falsch");
			newList.add((HighscoreCount.getTimeQuestions()[count]) + " Sekunden Rest");
			newList.add("Schwierigkeit: " + HighscoreCount.getMultiplier()[count]);
			newList.add("+ " + HighscoreCount.getPointCount()[count] + " Punkte");
			statistic.add(newList);
		}
	}
	
	private void setCords() {
		// start Y Value
		statisticCords[0] = 300;
		// Question
		statisticCords[1] = 100;
		// Answer
		statisticCords[2] = 300;
		// Time
		statisticCords[3] = 500;
		// Difficulty
		statisticCords[4] = 850;
		// Points
		statisticCords[5] = 1300;
	}

	@Override
	protected void fillImages() {
		handler.saveImage(0, 0, callSqlByTag("backgroundStatistic"));
	}

	@Override
	public void prepareOverlay(MouseEvent e, Gui ui) {
	}

	@Override
	public void handleMouseEvents(MouseEvent e, Gui ui) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			ImageManager manager = null;
			Statistic.setStatisticScreen(false);
			manager = new MainMenu();
			IOManager.setImageManager(manager);
			Gui.setImageManager(manager);
			ui.repaint();
		}
	}
}
