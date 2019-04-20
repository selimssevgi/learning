import java.util.Arrays;

public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;

  public RemoteControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();
    Arrays.fill(onCommands, noCommand);
    Arrays.fill(offCommands, noCommand);
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    // range check
    // null checks
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonPushed(int slot) {
    onCommands[slot].execute();
  }

  public void offButtonPush(int slot) {
    offCommands[slot].execute();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n------ Remote Control -------\n");
    for (int i = 0; i < onCommands.length; i++) {
      sb.append("[slot " + i + "] " +
          onCommands[i].getClass().getName() + " " +
          offCommands[i].getClass().getName() + "\n");
    }
    return sb.toString();
  }
}
