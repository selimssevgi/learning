public class GarageDoorOpenCommand implements Command {
  GarageDoor gdoor;

  public GarageDoorOpenCommand(GarageDoor garageDoor) {
    gdoor = garageDoor;
  }

  @Override
  public void execute() {
    gdoor.up();
  }
}
