public class RemoteControlTest {
  public static void main(String[] args) {
    SimpleRemoteControl remote = new SimpleRemoteControl();

    Light light = new Light();
    LightOnCommand lightOn = new LightOnCommand(light);

    GarageDoor gd = new GarageDoor();
    GarageDoorOpenCommand gdOpen = new GarageDoorOpenCommand(gd);

    remote.setCommand(lightOn);
    remote.buttonWasPressed();
    remote.setCommand(gdOpen);
    remote.buttonWasPressed();
  }
}
