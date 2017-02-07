public interface Command {
  public void execute();

  /**
   * Undos whatever executes does
   **/
  public void undo();
}
