package ImageManager;

import java.awt.event.MouseEvent;

import DBReader.MySqlConnection;
import Interface.Gui;

public abstract class ImageManager {

	protected ImageHandler handler;
	
	public ImageManager() {
		handler = new ImageHandler();
	}

	public ImageHandler getHandler() {
		return handler;
	}
	
	protected String callSqlByTag(String tag) {
		return MySqlConnection.getSingleEntry("link, name", 1, "ImageLinks", " Where name like '" + tag + "'");
	};
	
	protected abstract void fillImages();
	
	public abstract void prepareOverlay(MouseEvent e, Gui ui);
	
	public abstract void handleMouseEvents(MouseEvent e, Gui ui);
}
