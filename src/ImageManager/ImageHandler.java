package ImageManager;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Pictures.Picture;

public class ImageHandler {

	private ArrayList<Picture> images = new ArrayList<Picture>();
	
	public ImageHandler() {
	}

	public ArrayList<Picture> getMenuImages() {
		return images;
	}

	public void saveImage(int x, int y, String link) {
		try {
			images.add(new Picture(ImageIO.read(getClass().getResource(link)), x, y));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addOverlay(int index) {
		images.get(index).setOverlay(new Rectangle(images.get(index).getX(), images.get(index).getY(),
		images.get(index).getSprite().getWidth(), images.get(index).getSprite().getHeight()));
	}
	
	public void setNewImage(int index, String link) {
		images.get(index).setSprite(link);
	}
	
	public void setOverlay(int index, MouseEvent e, String tag, String tagOverlay) {
		if (images.get(index).getOverlay().contains(e.getPoint())) {
			setNewImage(index, tagOverlay);
		} else {
			setNewImage(index, tag);
		}
	}
}
