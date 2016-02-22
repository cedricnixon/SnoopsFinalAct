import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Enemy 
{
	public static final int ASSUMED_DRAWING_WIDTH = 800;
	public static final int ASSUMED_DRAWING_HEIGHT = 600;
	private static double ratioX, ratioY;
	public Image img;
	private boolean isVisible;
	private int xCoord, yCoord;
	private int width, height;

	// CONSTRUCTOR
	/*
	 All coordinates are in assumed coordinates and represent data for the
	 image, not the window.
	 */
	public Enemy(String filename, int x, int y, int w, int h) {
		img = (new ImageIcon(filename)).getImage();
		isVisible = true;
		xCoord = x;
		yCoord = y;
		width = w;
		height = h;
	}
	public void moveToLocation(int x, int y) {
		xCoord = x;
		yCoord = y;
	}

	/*
	 * MovingImage moves left/right or up/down by the amount passed
	 * in as arguments. Pass a negative number to move the other direction.
	 */
	public void moveByAmount(double x, double y) {
		xCoord += x;
		yCoord += y;
		if (xCoord < 0)
			xCoord = 0;
		if (yCoord < 0)
			yCoord = 0;
	}
	
	/*
	 * Returns the image's x coordinate.
	 */
	public double getX() {
		return xCoord;
	}
	
	/*
	 * Returns the image's y coordinate.
	 */
	public double getY() {
		return yCoord;
	}
	
	/*
	 * If the MovingImage should be visible, draws the MovingImage to the
	 * screen in the way specified by the resizable field.
	 */
	public void draw(Graphics g, ImageObserver io) {
		if (isVisible) {
			//g.drawImage(img, (int)(xCoord*ratioX), (int)(yCoord*ratioY), (int)(width*ratioX), (int)(height*ratioY), io);
			g.drawImage(img, xCoord, yCoord, width, height, io);
		}
	}

	/*
	 * Switches the MovingImage visibility to the opposite of what it is
	 * currently.
	 */
	public void swapVisibility() {
		isVisible = !isVisible;
	}

	/*
	 * Returns the visibility of the MovingImage.
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/*
	 * Returns true if the x,y point passed in is inside of this image.
	 * (For example, to check and see if this image was clicked on)
	 */
	public boolean isPointInsideImage(double x, double y) {
		if (x >= xCoord && x <= xCoord + width && y >= yCoord && y <= yCoord + height)
			return true;
		return false;
	}
	
	
}


