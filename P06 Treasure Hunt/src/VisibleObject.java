import java.io.File;
import processing.core.PImage;

/**
 * Class that represents a visible object with a graphical representation in the
 * game. It extends InteractiveObject class
 *
 * @author Steven Lai
 */
public class VisibleObject extends InteractiveObject {
  private PImage image; // the graphical representation of this object
  private int x; // the horizontal position (in pixels of this object's left side)
  private int y; // the vertical position (in pixels of this object's top side)

  /**
   * initialize this new VisibleObject the image for this visible object should be
   * loaded from : "images"+File.separator+ name +".png"
   * 
   * @param name String file name
   * @param x    int x;
   * @param y    int y;
   */
  public VisibleObject(String name, int x, int y) {
    super(name);
    this.image = InteractiveObject.getProcessing().loadImage("images" + File.separator + name + ".png");
    this.x = x;
    this.y = y;
  }

  /**
   * draws image at its position before returning null
   */
  @Override
  public Action update() {
    InteractiveObject.getProcessing().image(image, x, y);
    return null;
  }

  /**
   * changes x by adding dx to it (and y by dy)
   * 
   * @param dx int changes in x
   * @param dy int changes in y
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /**
   * return true only when point x,y is over image
   * 
   * @param x, int x position of point
   * @param y, int y position of point
   * @return true if point x y is over image
   */
  public boolean isOver(int x, int y) {
    int width = (image.width);
    int height = (image.height);

    int currentPosX = (this.x);
    int currentPosY = (this.y);
    // if x is bounded by smallest x value, and bounded by largest x value of image
    // and if y is bounded by smallest y value, and bounded by largest y value of
    // image
    if ((x >= currentPosX && x <= currentPosX + (width)) && (y >= currentPosY && y <= currentPosY + (height))) {
      return true;
    }
    return false;
  }

  /**
   * return true only when other's image overlaps this one's
   * 
   * @param other
   * @return true when other's image overlaps this one
   */
  public boolean isOver(VisibleObject other) {
    if (other.isOver(this.x, this.y)) {
      return true;
    } else
      return false;
  }

}
