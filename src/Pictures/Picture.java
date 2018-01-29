package Pictures;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {

	private BufferedImage sprite;
	private int x;
	private int y;
	private Rectangle overlay;
	
	public Picture(BufferedImage sprite, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		this.overlay = null;
	}
	
	public BufferedImage getSprite() {
		return sprite;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getOverlay() {
		return overlay;
	}
	
	public void setSprite(String link) {
		try {
			this.sprite = ImageIO.read(getClass().getResource(link));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setOverlay(Rectangle overlay) {
		this.overlay = overlay;
	}
}
