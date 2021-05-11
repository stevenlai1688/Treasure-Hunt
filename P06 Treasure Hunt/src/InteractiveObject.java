import processing.core.PApplet;

/**
 * Class that organize the capabilities that are common to all interactive
 * objects in our game
 * 
 * @author Steven Lai
 */
public class InteractiveObject {
  private final String NAME; // the constant name identifying this interactive object
  private boolean isActive; // active means this interactive object is visible and
  // can be interacted with
  private static PApplet processing = null;

  /**
   * initializes the name of this object, and sets isActive to true
   * 
   * @param name
   */
  public InteractiveObject(String name) {
    this.NAME = name;
    this.isActive = true;
  }

  /**
   * returns true only when contents of name equal NAME
   * 
   * @param name String name
   * @return true when name equals NAME
   */
  public boolean hasName(String name) {
    return (name.equals(NAME));
  }

  /**
   * returns true only when isActive is true
   * 
   * @return isActive
   */
  public boolean isActive() {
    if (isActive)
      return true;
    else
      return false;

  }

  /**
   * changes isActive to true
   */
  public void activate() {
    isActive = true;
  }

  /**
   * changes isActive to false
   */
  public void deactivate() {
    isActive = false;
  }

  /**
   * this method returns null subclass types will override this update() method to
   * do more interesting things
   * 
   * @return null;
   */
  public Action update() {
    return null;
  }

  /**
   * initializes processing field
   * 
   * @param processing
   */
  public static void setProcessing(PApplet processing) {
    InteractiveObject.processing = processing;
  }

  /**
   * accessor method to retrieve this static field
   */
  protected static PApplet getProcessing() {
    return processing;
  }
}
