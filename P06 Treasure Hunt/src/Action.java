import java.util.ArrayList;

/**
 * Action class that represent the response to an object being clicked or
 * dragged onto another.
 *
 * @author Steven Lai
 */
public class Action {
  private String message; // message printed by this action (or null to do nothing)
  private InteractiveObject object;

  /**
   * create and initialize this new action
   */
  public Action(String message) {
    this.message = message;
  }

  public Action(InteractiveObject object) {
    this.object = object;
  }

  public Action(String message, InteractiveObject object) {
    this.message = message;
    this.object = object;
  }

  /**
   * when message is not null, message is printed to System.out
   * 
   * @param ArrayList of InteractiveObjects
   */
  public void act(ArrayList<InteractiveObject> objects) {
    if (message != null) {
      System.out.println(message);
    }
    if (this.object != null) {
      this.object.activate();
      objects.add(object);
      this.object = null;
    }
  }
}
