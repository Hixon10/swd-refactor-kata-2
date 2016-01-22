package task3;

public class Rover {
  private Coordinates coordinates;

  public Rover(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Boolean receiveSingleCommand(char command) throws Exception {
    command = Character.toUpperCase(command);
    if (command == 'F') {
      return coordinates.move(1);
    } else if (command == 'B') {
      return coordinates.move(-1);
    } else if (command == 'L') {
      coordinates.turnLeft();
      return true;
    } else if (command == 'R') {
      coordinates.turnRight();
      return true;
    } else {
      throw new UnsupportedOperationException();
    }
  }

  public void receiveCommands(String commands) throws Exception {
    for (int i = 0; i < commands.length(); i++) {
      char currentCommand = commands.charAt(i);
      if (!receiveSingleCommand(currentCommand)) {
        break;
      }
    }
  }

  public String getPosition() {
    if (coordinates.hasObstacleInFront()) {
      return " NOK";
    }

    return coordinates.toString();
  }
}
