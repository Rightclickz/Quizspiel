package Interface;

import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Window extends JFrame {

	/**
	 * abstract Window constructor, sets used window configure
	 * @param windowName
	 * @param windowWidth
	 * @param windowHeight
	 * @throws IOException 
	 */
	public Window(String windowName, int windowWidth, int windowHeight) {
		super(windowName);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(windowWidth, windowHeight);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
	}
}