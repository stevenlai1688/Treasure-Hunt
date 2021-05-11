/**
 * 
 *
 * Class that include code that allows the user to drag the object around the
 * screen. It extends VisibleObject
 *
 * @author Steven Lai
 */
public class DraggableObject extends VisibleObject {
  private boolean mouseWasPressed; // similar to use in ClickableObject
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /**
   * initializes new draggable object
   * 
   * @param name, String name
   * @param x,    int x position
   * @param y,    int y position
   */
  public DraggableObject(String name, int x, int y) {
    super(name, x, y);
  }

  /**
   * calls VisibleObject update() first, then moves according to mouse drag each
   * time isDragging changes from true to false, the drop() method below will be
   * called once and any action objects returned from that method should then be
   * returned from update()
   */
  @Override
  public Action update() {
    super.update();
    
    Action drop = null;
    int mouseX = getProcessing().mouseX;
    int mouseY = getProcessing().mouseY;
    boolean mousePressed = getProcessing().mousePressed;
    
    if (isDragging) {
      // while being dragged, object moves by the same amount that the mouse has moved
      // between this and the previous call of the update() method
      move(mouseX - oldMouseX, mouseY - oldMouseY);

    }
    if (mousePressed && this.isOver(mouseX, mouseY)) {
      if (!this.mouseWasPressed) {
        // set mouse was press to true before returning action
        mouseWasPressed = true;
        isDragging = true;
      }
    }
    if (!mousePressed) {
      isDragging = false;
      drop = drop();
    } else {
      mouseWasPressed = false;
    }
    // set old mouse X and mouse Y to current x and y of mouse
    oldMouseX = mouseX;
    oldMouseY = mouseY;
    return drop;
  }

  /**
   * this method returns null. subclass types will override this drop() method to
   * perform more interesting behavior
   * 
   */
  protected Action drop() {
    return null;
  }
}
