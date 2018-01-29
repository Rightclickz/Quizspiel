package GuiManager;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import DBReader.MySqlConnection;
import ImageManager.ImageManager;
import Interface.Gui;
import UserAPI.IOManager;

public class HighscoreScreen extends ImageManager {
	
	private static ArrayList<ArrayList<String>> highscore;
	private static int[] highscoreCords;
	private static boolean highscoreScreen;
	private static Rectangle backfield;
	
	public HighscoreScreen() {
		super();
		fillImages();
		highscoreCords = new int[4];
		setCords();
		highscore = MySqlConnection.getEntrys("id, name, punkte", 3, "Highscore");
		backfield = new Rectangle(25, 730, 360, 100);
	}
	
	public static int[] getHighscoreCords() {
		return highscoreCords;
	}

	public static ArrayList<ArrayList<String>> getHighscore() {
		return highscore;
	}

	public static void setHighscoreScreen(boolean highscoreScreen) {
		HighscoreScreen.highscoreScreen = highscoreScreen;
	}

	public static boolean isHighscoreScreen() {
		return highscoreScreen;
	}

	private void setCords() {
		// start Y Value
		highscoreCords[0] = 300;
		// placement
		highscoreCords[1] = 500;
		// name
		highscoreCords[2] = 570;
		// points
		highscoreCords[3] = 1000;
	}

	@Override
	protected void fillImages() {
		handler.saveImage(0, 0, callSqlByTag("backgroundHighscore"));
	}

	@Override
	public void prepareOverlay(MouseEvent e, Gui ui) {
		if (backfield.contains(e.getPoint())) {
			ui.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} else {
			ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}

	@Override
	public void handleMouseEvents(MouseEvent e, Gui ui) {
		if (e.getButton() == MouseEvent.BUTTON1 && backfield.contains(e.getPoint())) {
			ImageManager manager = null;
			HighscoreScreen.setHighscoreScreen(false);
			manager = new MainMenu();
			IOManager.setImageManager(manager);
			Gui.setImageManager(manager);
			ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			ui.repaint();
		}
	}

}
