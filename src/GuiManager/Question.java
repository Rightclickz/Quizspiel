package GuiManager;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import GameManager.HighscoreCount;
import GameManager.TextContent;
import ImageManager.ImageManager;
import Interface.Gui;
import Threads.Animation;
import Threads.QuestionDelay;
import UserAPI.IOManager;

public class Question extends ImageManager {
	
	private static boolean rightChoose;
	
	public Question() {
		super();
		rightChoose = false;
		fillImages();
		updateOverlay();
	}
	
	public static boolean isRightChoose() {
		return rightChoose;
	}
	
	private void updateOverlay() {
		handler.addOverlay(2);
		handler.addOverlay(3);
		handler.addOverlay(4);
		handler.addOverlay(5);
	}
	
	private boolean handleAnswer(int rightAnswer, int borderNumber, int index) {
		Animation.setChoosenAnswer(true);
		if (rightAnswer == borderNumber) {
			rightChoose = true;
			handler.getMenuImages().get(index).setSprite(callSqlByTag("answerBorderRight"));
			IOManager.getSoundClass().updateSound("right");
			IOManager.getSoundClass().startSound(-10f, 0);
		} else {
			handler.getMenuImages().get(index).setSprite(callSqlByTag("answerBorderFalse"));
			IOManager.getSoundClass().updateSound("false");
			IOManager.getSoundClass().startSound(-15f, 0);
		}
		return rightChoose;
	}

	@Override
	protected void fillImages() {
		handler.saveImage(0, 0, callSqlByTag("backgroundQuestion"));
		handler.saveImage(300, -500, callSqlByTag("questionBorder"));
		handler.saveImage(-600, 450, callSqlByTag("answerBorder"));
		handler.saveImage(1700, 450, callSqlByTag("answerBorder"));
		handler.saveImage(-600, 675, callSqlByTag("answerBorder"));
		handler.saveImage(1700, 675, callSqlByTag("answerBorder"));
		handler.saveImage(725, 1088, callSqlByTag("timerBorder"));
	}

	@Override
	public void prepareOverlay(MouseEvent e, Gui ui) {
		if (Animation.isAnswerScreen() && !Animation.isChoosenAnswer() && !Animation.isOutOfTime()) {
			updateOverlay();
			handler.setOverlay(2, e, callSqlByTag("answerBorder"), callSqlByTag("answerBorderChoosen"));
			handler.setOverlay(3, e, callSqlByTag("answerBorder"), callSqlByTag("answerBorderChoosen"));
			handler.setOverlay(4, e, callSqlByTag("answerBorder"), callSqlByTag("answerBorderChoosen"));
			handler.setOverlay(5, e, callSqlByTag("answerBorder"), callSqlByTag("answerBorderChoosen"));
			ui.repaint();
			if (handler.getMenuImages().get(2).getOverlay().contains(e.getPoint()) || handler.getMenuImages().get(3).getOverlay().contains(e.getPoint()) ||
				handler.getMenuImages().get(4).getOverlay().contains(e.getPoint()) || handler.getMenuImages().get(5).getOverlay().contains(e.getPoint())) {
				ui.setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}

	@Override
	public void handleMouseEvents(MouseEvent e, Gui ui) {
		if (handler.getMenuImages().get(2).getOverlay().contains(e.getPoint()) || handler.getMenuImages().get(3).getOverlay().contains(e.getPoint()) ||
			handler.getMenuImages().get(4).getOverlay().contains(e.getPoint()) || handler.getMenuImages().get(5).getOverlay().contains(e.getPoint())) {
			if (!Animation.isChoosenAnswer() && !Animation.isOutOfTime() && Animation.isAnswerScreen()) {
				int rightAnswer = TextContent.getRightAnswer();
				boolean chooseRight = false;
				if (handler.getMenuImages().get(2).getOverlay().contains(e.getPoint())) {
					chooseRight = handleAnswer(rightAnswer, 1, 2);
				}
				if (handler.getMenuImages().get(3).getOverlay().contains(e.getPoint())) {
					chooseRight = handleAnswer(rightAnswer, 2, 3);
				}
				if (handler.getMenuImages().get(4).getOverlay().contains(e.getPoint())) {
					chooseRight = handleAnswer(rightAnswer, 3, 4);
				}
				if (handler.getMenuImages().get(5).getOverlay().contains(e.getPoint())) {
					chooseRight = handleAnswer(rightAnswer, 4, 5);
				}
				if (!chooseRight && Animation.isChoosenAnswer()) {
					handler.getMenuImages().get(rightAnswer+1).setSprite(callSqlByTag("answerBorderRight"));
				}
				ui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				ui.repaint();
				HighscoreCount.saveQuestionStatistics();
				Thread timer = new Thread(new QuestionDelay(ui));
				timer.start();
			}
		}
	}
}
