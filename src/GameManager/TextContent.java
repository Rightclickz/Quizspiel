package GameManager;

import java.util.ArrayList;

import DBReader.MySqlConnection;

public class TextContent {

	private static int questionCount;
	private static int rightAnswer;
	private static int[] questionOrder = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	private static String questionString;
	private static ArrayList<ArrayList<String>> questionContent;
	private static ArrayList<String> drawableString;
	private static int[] textCords;
	private static int[] answerOrder;
	
	public TextContent() {
		questionCount = 1;
		questionString = "Frage " + questionCount;
		questionContent = MySqlConnection.getEntrys("Frage, RichtigeAntwort, Antwort2, Antwort3, Antwort4, Thema, S_Stufe", 7, "quizcontent");
		initializeTextCords();
		randomizeOrder();
		answerOrder = new int[4];
		drawableString = questionContent.get(questionOrder[0]);
	}
	
	public static int[] getTextCords() {
		return textCords;
	}

	public static String getQuestionString() {
		return questionString;
	}

	public static ArrayList<String> getDrawableString() {
		return drawableString;
	}
	
	public static int getRightAnswer() {
		return rightAnswer;
	}

	public static int getQuestionCount() {
		return questionCount;
	}

	public static void setNextQuestion(int next) {
		drawableString = questionContent.get(questionOrder[next]);
	}
	
	private static ArrayList<Integer> readBreaks(String text, int max) {
		ArrayList<Integer> spaceList = new ArrayList<Integer>();
		ArrayList<Integer> breakList = new ArrayList<Integer>();
		int index = 0;
		for (char letter : text.toCharArray()) {
			if (letter == ' ') {
				spaceList.add(index);
			}
			index++;
		}
		spaceList.add(index+1);
		int tempMax = max;
		for (int i=0; i<spaceList.size(); i++) {
			if (spaceList.get(i) > max) {
				if (!(i == 0)) {
					breakList.add(spaceList.get(i - 1));
					max = tempMax + spaceList.get(i - 1);
				}
			}
		}
		return breakList;
	}

	private void randomizeOrder() {
		for (int i = 0; i < questionOrder.length; i++) {
			int random;
			do {
				random = (int)(Math.random() * (questionContent.size() - 1));
			} while (checkRandomNumber(random, questionOrder));
			questionOrder[i] = random;
		}
	}
	
	private static boolean checkRandomNumber(int random, int[] questionOrder) {
		for (int i : questionOrder) {
			if (i == random) {
				return true;
			}
		}
		return false;
	}
	
	private void initializeTextCords() {
		textCords = new int[16];
		// Question Counter
		textCords[0] = 400;
		textCords[1] = 400;
		// Question Theme
		textCords[2] = 400;
		textCords[3] = 500;
		// Question
		textCords[4] = 350;
		textCords[5] = 170;
		// Timer
		textCords[6] = 775;
		textCords[7] = 677;
		// Answer 1
		textCords[8] = 300;
		textCords[9] = 550;
		// Answer 2
		textCords[10] = 1000;
		textCords[11] = 550;
		// Answer 3
		textCords[12] = 300;
		textCords[13] = 780;
		// Answer 4
		textCords[14] = 1000;
		textCords[15] = 780;
	}
	
	public static void incrementQuestionCount() {
		questionCount++;
		questionString = "Frage " + questionCount;
	}
	
	public static ArrayList<String> handleLongStrings(String longText, int max) {
		ArrayList<String> formatStrings = new ArrayList<String>();
		ArrayList<Integer> breakList = readBreaks(longText, max);
		String singleString = "";
		for (int i=0; i<longText.length(); i++) {
			singleString += longText.charAt(i);
			for (int breaks : breakList) {
				if (i == breaks) {
					formatStrings.add(singleString);
					singleString = "";
				}
			}
		}
		formatStrings.add(singleString);
		return formatStrings;
	}
	
	public static ArrayList<String> formatAnswerText() {
		ArrayList<String> formatStrings = new ArrayList<String>();
		int rightCount = 1;
		for (int i : answerOrder) {
			formatStrings.add(drawableString.get(i));
			if (i == 1) {
				rightAnswer = rightCount;
			}
			rightCount++;
		}
		return formatStrings;
	}
	
	public static void buildAnswerOrder() {
		for (int i = 0; i < answerOrder.length; i++) {
			answerOrder[i] = -1;
		}
		for (int i = 0; i < answerOrder.length; i++) {
			int random;
			do {
				random = (int)((Math.random() * 4) + 1);
			} while (checkRandomNumber(random, answerOrder));
			answerOrder[i] = random;
		}
	}
}
