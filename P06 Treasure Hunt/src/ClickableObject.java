/**
 * Class that represent objects that we want to interact with by clicking. It
 * extends Visible Object
 *
 * @author Steven Lai
 */
public class ClickableObject extends VisibleObject {
  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed
  // during the last update()
  // initializes this new object

  public ClickableObject(String name, int x, int y, Action action) {
    super(name, x, y);
    this.action = action;
  }

  /**
   * calls VisibleObject update, then returns action only when mouse is first
   * clicked on this object
   * 
   */
  @Override
  public Action update() {
    // call update in VisibleObject class to draw object
    super.update();
    int mouseX = InteractiveObject.getProcessing().mouseX;
    int mouseY = InteractiveObject.getProcessing().mouseY;
    // if mouse is pressed, and mouse is over the image
    if (InteractiveObject.getProcessing().mousePressed && this.isOver(mouseX, mouseY)) {
      // if it wasn't pressed before
      if (!this.mouseWasPressed) {
        // set mouse was press to true before returning action
        mouseWasPressed = true;
        return action;
      }
    } else {
      // if mouse was not pressed or mouse is not over the image, set mouse was
      // pressed to false
      mouseWasPressed = false;
    }
    return null;

  }
}
