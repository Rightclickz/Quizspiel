package GuiManager;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import GameManager.Game;
import GameManager.HighscoreCount;
import GameManager.TextContent;
import ImageManager.ImageManager;
import Interface.Gui;
import Threads.Sound;
import UserAPI.IOManager;

public class MainMenu extends ImageManager {

	public MainMenu() {
		super();
		fillImages();
	}

	@Override
	protected void fillImages() {
		handler.saveImage(0, 0, callSqlByTag("backgroundMainMenu"));
		handler.saveImage(910, 30, callSqlByTag("newGame"));
		handler.saveImage(1020, 130, callSqlByTag("highscore"));
		handler.saveImage(1105, 780, callSqlByTag("exit"));
		handler.addOverlay(1);
		handler.addOverlay(2);
		handler.addOverlay(3);
	}

	@Override
	public void prepareOverlay(MouseEvent e, Gui ui) {
		handler.setOverlay(1, e, callSqlByTag("newGame"), callSqlByTag("newGameOverlay"));
		handler.setOverlay(2, e, callSqlByTag("highscore"), callSqlByTag("highscoreOverlay"));
		handler.setOverlay(3, e, callSqlByTag("exit"), callSqlByTag("exitOverlay"));
		ui.repaint();
		if (handler.getMenuImages().get(1).getOverlay().contains(e.getPoint()) || handler.getMenuImages().get(2).getOverlay().contains(e.getPoint()) ||
			handler.getMenuImages().get(3).getOverlay().contains(e.getPoint())) {
			ui.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} else {
			ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}

	@Override
	public void handleMouseEvents(MouseEvent e, Gui ui) {
		if (handler.getMenuImages().get(1).getOverlay().contains(e.getPoint())) {
			new TextContent();
			new HighscoreCount();
			new Game(ui);
			Sound.getSoundClip().stop();
			ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			ui.repaint();
		}	
		else if (handler.getMenuImages().get(2).getOverlay().contains(e.getPoint())) {
			ImageManager manager = new HighscoreScreen();
			HighscoreScreen.setHighscoreScreen(true);
			Gui.setImageManager(manager);
			IOManager.setImageManager(manager);
			ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			ui.repaint();
		} else if (handler.getMenuImages().get(3).getOverlay().contains(e.getPoint())) {
			System.exit(0);
		}
	}
}