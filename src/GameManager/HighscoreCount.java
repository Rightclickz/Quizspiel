package GameManager;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DBReader.MySqlConnection;
import GuiManager.Question;
import Threads.Animation;

public class HighscoreCount {

	private static int points;
	private static int basePoints;
	private static boolean[] rightQuestions;
	private static int[] timeQuestions;
	private static int[] multiplier;
	private static int[] pointCount;
	private static ArrayList<ArrayList<String>> highscore;
	
	public HighscoreCount() {
		rightQuestions = new boolean[10];
		timeQuestions = new int[10];
		multiplier = new int[10];
		pointCount = new int[10];
		points = 0;
		basePoints = 100;
		highscore = MySqlConnection.getEntrys("id, name, punkte", 3, "Highscore");
	}
	
	public static int getPoints() {
		return points;
	}

	public static boolean[] getRightQuestions() {
		return rightQuestions;
	}

	public static int[] getTimeQuestions() {
		return timeQuestions;
	}

	public static int[] getMultiplier() {
		return multiplier;
	}

	public static int[] getPointCount() {
		return pointCount;
	}
	
	public static ArrayList<ArrayList<String>> getHighscore() {
		return highscore;
	}
	
	private static void addPoints(boolean isRight, int difficulty, int timer, int questionCount) {
		int timerPoints = 10;
		if (isRight) {
			pointCount[questionCount-1] = (basePoints * difficulty) + (timer * timerPoints);
			points += (basePoints * difficulty) + (timer * timerPoints);
			basePoints += 50;
		} else {
			pointCount[questionCount-1] = (30 - timer) * difficulty;
			points += (30 - timer) * difficulty;
			basePoints = 100;
		}
	}
	
	private static void addHighscoreEntry(int placement) {
		ArrayList<String> nextEntry = setHighscoreRow(placement);
		ArrayList<String> tempEntry = new ArrayList<String>();
		int countToTen = placement - 1;
		for (int i = countToTen; i < 10; i++) {
			tempEntry = highscore.get(i);
			highscore.set(i, nextEntry);
			nextEntry = tempEntry;
			int newIndex = Integer.parseInt(nextEntry.get(0)) + 1;
			nextEntry.set(0, newIndex + "");
		}
		MySqlConnection.insertNewHighscore();
	}
	
	private static ArrayList<String> setHighscoreRow(int placement) {
		String name;
		ArrayList<String> newHighscore = new ArrayList<String>();
		newHighscore.add(placement + "");
		do {
			name = JOptionPane.showInputDialog(new JFrame(), "Neue Highscore: Platz " + placement + ". Bitte gib deinen Namen ein! (max. 18 Zeichen)"); 
		} while (!(name.length() <= 18 && name.length() > 0));
		newHighscore.add(name);
		newHighscore.add(points + "");
		return newHighscore;
	}
	
	public static void saveQuestionStatistics() {
		int questionCount = TextContent.getQuestionCount();
		int timerState = Animation.getTimer();
		int difficulty = Integer.parseInt(TextContent.getDrawableString().get(6));
		boolean answerRight = Question.isRightChoose();
		rightQuestions[questionCount-1] = answerRight;
		timeQuestions[questionCount-1] = timerState;
		multiplier[questionCount-1] = difficulty;
		addPoints(answerRight, difficulty, timerState, questionCount);
	}
	
	public static void checkHighscore() {
		for (ArrayList<String> placement : highscore) {
			if (points > Integer.parseInt(placement.get(2))) {
				addHighscoreEntry(Integer.parseInt(placement.get(0)));
				break;
			}
		}
	}
}
