package GameManager;

import GuiManager.Question;
import ImageManager.ImageManager;
import Interface.Gui;
import Threads.Animation;
import UserAPI.IOManager;

public class Game extends Thread {
	
	private static ImageManager manager;
	private static Gui ui;
	private static Thread animation;

	public Game(Gui ui) {
		Game.ui = ui;
		manager = new Question();
		Gui.setImageManager(manager);
		IOManager.setImageManager(manager);
		startThreading();
	}
	
	private static void startThreading() {
		animation = new Thread(new Animation(ui, manager));
		animation.start();
	}
	
	public static void newQuestion() {
		TextContent.setNextQuestion(TextContent.getQuestionCount());
		TextContent.incrementQuestionCount();
		manager = new Question();
		Gui.setImageManager(manager);
		IOManager.setImageManager(manager);
		animation = new Thread(new Animation(ui, manager));
		animation.start();
	}
}
