package UserAPI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import DBReader.MySqlConnection;
import GuiManager.MainMenu;
import ImageManager.ImageManager;
import Interface.Gui;
import Sounds.AudioStorage;
import Threads.Sound;

public class IOManager implements MouseMotionListener, MouseListener {
	
	private static Gui ui;
	private static ImageManager manager;
	private static Sound soundClass;
	private static Thread sound;
	
	public IOManager() {
		new MySqlConnection();
		manager = new MainMenu();
		ui = new Gui();
		Gui.setImageManager(manager);
		new AudioStorage();
		soundClass = new Sound();
		sound = soundClass;
		sound.start();
		ui.addMouseListener(this);
		ui.addMouseMotionListener(this);
	}

	public static Sound getSoundClass() {
		return soundClass;
	}

	public static Thread getSound() {
		return sound;
	}

	public static void setImageManager(ImageManager manager) {
		IOManager.manager = manager;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		manager.prepareOverlay(e, ui);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		manager.handleMouseEvents(e, ui);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public static void main(String[] args) {
		new IOManager();
	}
}
