package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

import GameManager.HighscoreCount;
import GameManager.TextContent;
import GuiManager.HighscoreScreen;
import GuiManager.Statistic;
import ImageManager.ImageManager;
import Pictures.Picture;
import Threads.Animation;

@SuppressWarnings("serial")
public class Gui extends Window {
	
	private static Image dbImage;
	private static Graphics dbg;
	private static ImageManager imageManager;

	public Gui() {
		super("QuizWorld", 1600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void setImageManager(ImageManager imageManager) {
		Gui.imageManager = imageManager;
	}
	
	private void paintComponent(Graphics g) {
		if (imageManager.getHandler().getMenuImages() != null) {
			for (Picture image : imageManager.getHandler().getMenuImages()) {
				g.drawImage(image.getSprite(), image.getX(), image.getY(), this);
			}
		}
		paintAnimations(g);
		paintStatistics(g);
		paintHighscore(g);
	}
	
	private void paintAnimations(Graphics g) {
		if (Animation.isEnterScreen()) {
			setEnterScreenFont(g);
			g.drawString(TextContent.getQuestionString(), TextContent.getTextCords()[0], TextContent.getTextCords()[1]);
			g.setFont(new Font("Georgia", Font.PLAIN, 40));
			g.drawString("Thema: " + TextContent.getDrawableString().get(5) + "  Stufe: " + TextContent.getDrawableString().get(6), TextContent.getTextCords()[2], TextContent.getTextCords()[3]);
		}
		if (Animation.isQuestionScreen()) {
			setQuestionScreenFont(g);
			if (TextContent.getDrawableString().get(0).length() > 70) {
				int rowCount = TextContent.getTextCords()[5];
				ArrayList<String> allStrings = TextContent.handleLongStrings(TextContent.getDrawableString().get(0), 70);
				for (String singleString : allStrings) {
					g.drawString(singleString, TextContent.getTextCords()[4], rowCount);
					rowCount += 35;
				}
			} else {
				g.drawString(TextContent.getDrawableString().get(0), TextContent.getTextCords()[4], TextContent.getTextCords()[5]);
			}
		}
		if (Animation.isAnswerScreen()) {
			int count = 8;
			for (String singleString : TextContent.formatAnswerText()) {
				if (singleString.length() > 25 && (TextContent.handleLongStrings(singleString, 25).size() > 1)) {
					int rowCount = TextContent.getTextCords()[count+1] - 30;
					ArrayList<String> allStrings = TextContent.handleLongStrings(singleString, 25);
					for (String splitAnswer : allStrings) {
						g.drawString(splitAnswer, (TextContent.getTextCords()[count] - 40), rowCount);
						rowCount += 35;
					}
				} else {
					g.drawString(singleString, TextContent.getTextCords()[count] - 40, TextContent.getTextCords()[count+1] - 30);
				}
				count += 2;
			}
		}
		if (Animation.isTimerScreen()) {
			g.setFont(new Font("Times New Roman", Font.PLAIN, 50));
			if (Animation.getTimer() >= 10) {
				g.drawString("" + Animation.getTimer(), TextContent.getTextCords()[6], TextContent.getTextCords()[7]);
			} else {
				g.drawString(" " + Animation.getTimer(), TextContent.getTextCords()[6], TextContent.getTextCords()[7]);
			}
		}
	}
	
	private void paintStatistics(Graphics g) {
		if (Statistic.isStatisticScreen()) {
			setStatisticScreenFont(g);
			g.drawString("Statistik", 600, 150);
			g.setFont(new Font("Comic Sans", Font.PLAIN, 30));
			int yCount = 0;
			for (ArrayList<String> question : Statistic.getStatistic()) {
				int xCount = 1;
				for (String entry : question) {
					g.drawString(entry, Statistic.getStatisticCords()[xCount], Statistic.getStatisticCords()[0] + yCount);
					xCount++;
				}
				yCount += 50;
			}
			g.setFont(new Font("Comic Sans", Font.PLAIN, 40));
			g.drawString("Gesamt:   " + HighscoreCount.getPoints() + " Punkte", 1100, 850);
			g.setFont(new Font("Comic Sans", Font.PLAIN, 20));
			g.drawString("zurück zum Hauptmenu ... linke Maustaste", 600, 880);
		}
	}
	
	private void paintHighscore(Graphics g) {
		if (HighscoreScreen.isHighscoreScreen()) {
			setHighscoreScreenFont(g);
			int yCount = 0;
			for (ArrayList<String> entry : HighscoreScreen.getHighscore()) {
				int xCount = 1;
				for (String single : entry) {
					g.drawString(single, HighscoreScreen.getHighscoreCords()[xCount], HighscoreScreen.getHighscoreCords()[0] + yCount);
					xCount++;
				}
				yCount += 50;
			}
		}
	}
	
	private void setEnterScreenFont(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Georgia", Font.PLAIN, 100));
	}
	
	private void setQuestionScreenFont(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	}
	
	private void setStatisticScreenFont(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", Font.PLAIN, 100));
	}
	
	private void setHighscoreScreenFont(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", Font.PLAIN, 40));
	}
	
	@Override
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
}
