/**
 * Class that allows us to specify a target for this kind of interactive object
 * to be dropped on along with an action that is produced when this happens. It
 * extends DraggableObject
 *
 * @author Steven Lai
 */
public class DroppableObject extends DraggableObject {
  private VisibleObject target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object
  // over target
  // initialize new object

  public DroppableObject(String name, int x, int y, VisibleObject target, Action action) {
    super(name, x, y);
    this.target = target;
    this.action = action;
  }

  /**
   * returns action and deactivates objects in response to successful drop When
   * this object is over its target and its target is active: deactivate both this
   * object and the target object, and return action, otherwise return null
   */
  @Override
  protected Action drop() {
    if (this.isOver(target) && target.isActive()) {
      this.deactivate();
      target.deactivate();
      return action;
    }
    return null;
  }

}
