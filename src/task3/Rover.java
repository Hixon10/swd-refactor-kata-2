package task3;

public class Rover {
  private Coordinates coordinates;

  public Rover(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void receiveSingleCommand(char command) throws Exception {
    if (command == 'F') {
      if (coordinates.getDirection() == Direction.NORTH) {
        int val = coordinates.getY().getLocation();
        if (val == coordinates.getY().getMaxLocation()) {
          val = 0;
        } else {
          val++;
        }

        Point newY = new Point(val, coordinates.getY().getMaxLocation());
        coordinates.setY(newY);
      } else if (coordinates.getDirection() == Direction.EAST) {
        int val = coordinates.getX().getLocation();
        if (val == coordinates.getX().getMaxLocation()) {
          val = 0;
        } else {
          val++;
        }

        Point newX = new Point(val, coordinates.getX().getMaxLocation());
        coordinates.setX(newX);
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        int val = coordinates.getY().getLocation();
        if (val == 0) {
          val = coordinates.getY().getMaxLocation();
        } else {
          val--;
        }

        Point newY = new Point(val, coordinates.getY().getMaxLocation());
        coordinates.setY(newY);
      } else if (coordinates.getDirection() == Direction.WEST) {
        int val = coordinates.getX().getLocation();
        if (val == 0) {
          val = coordinates.getX().getMaxLocation();
        } else {
          val--;
        }

        Point newX = new Point(val, coordinates.getX().getMaxLocation());
        coordinates.setX(newX);
      }
    } else if (command == 'B') {
      if (coordinates.getDirection() == Direction.NORTH) {
        int val = coordinates.getY().getLocation();
        if (val == 0) {
          val = coordinates.getY().getMaxLocation();
        } else {
          val--;
        }

        Point newY = new Point(val, coordinates.getY().getMaxLocation());
        coordinates.setY(newY);
      } else if (coordinates.getDirection() == Direction.EAST) {
        int val = coordinates.getX().getLocation();
        if (val == 0) {
          val = coordinates.getX().getMaxLocation();
        } else {
          val--;
        }

        Point newX = new Point(val, coordinates.getX().getMaxLocation());
        coordinates.setX(newX);
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        int val = coordinates.getY().getLocation();
        if (val == coordinates.getY().getMaxLocation()) {
          val = 0;
        } else {
          val++;
        }

        Point newY = new Point(val, coordinates.getY().getMaxLocation());
        coordinates.setY(newY);
      } else if (coordinates.getDirection() == Direction.WEST) {
        int val = coordinates.getX().getLocation();
        if (val == coordinates.getX().getMaxLocation()) {
          val = 0;
        } else {
          val++;
        }

        Point newX = new Point(val, coordinates.getX().getMaxLocation());
        coordinates.setX(newX);
      }
    } else if (command == 'L') {
      if (coordinates.getDirection() == Direction.NORTH) {
        coordinates.setDirection(Direction.WEST);
      } else if (coordinates.getDirection() == Direction.EAST) {
        coordinates.setDirection(Direction.NORTH);
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        coordinates.setDirection(Direction.EAST);
      } else if (coordinates.getDirection() == Direction.WEST) {
        coordinates.setDirection(Direction.SOUTH);
      }
    } else if (command == 'R' || command == 'r') {
      if (coordinates.getDirection() == Direction.NORTH) {
        coordinates.setDirection(Direction.EAST);
      } else if (coordinates.getDirection() == Direction.EAST) {
        coordinates.setDirection(Direction.SOUTH);
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        coordinates.setDirection(Direction.WEST);
      } else if (coordinates.getDirection() == Direction.WEST) {
        coordinates.setDirection(Direction.NORTH);
      }
    } else {
      throw new Exception("command is unknown");
    }
  }

  public void receiveCommands(String commands) throws Exception {
    for (int i = 0; i < commands.length(); i++) {
      char currentCommand = commands.charAt(i);
      if (hasObstacle(currentCommand)) {
        break;
      }
      receiveSingleCommand(currentCommand);
    }
  }

  public String getPosition() {
    throw new UnsupportedOperationException();
  }

  private Boolean hasObstacle(char command) {
    int currentX = coordinates.getX().getLocation();
    int currentY = coordinates.getX().getLocation();

    if (command == 'F') {
      if (coordinates.getDirection() == Direction.NORTH) {
        if (currentY == coordinates.getY().getMaxLocation()) {
          currentY = 0;
        } else {
          currentY++;
        }
      } else if (coordinates.getDirection() == Direction.EAST) {
        if (currentX == coordinates.getX().getMaxLocation()) {
          currentX = 0;
        } else {
          currentX++;
        }
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        if (currentY == 0) {
          currentY = coordinates.getY().getMaxLocation();
        } else {
          currentY--;
        }
      } else if (coordinates.getDirection() == Direction.WEST) {
        if (currentX == 0) {
          currentX = coordinates.getX().getMaxLocation();
        } else {
          currentX--;
        }
      }
    } else if (command == 'B') {
      if (coordinates.getDirection() == Direction.NORTH) {
        if (currentY == 0) {
          currentY = coordinates.getY().getMaxLocation();
        } else {
          currentY--;
        }
      } else if (coordinates.getDirection() == Direction.EAST) {
        if (currentX == 0) {
          currentX = coordinates.getX().getMaxLocation();
        } else {
          currentX--;
        }
      } else if (coordinates.getDirection() == Direction.SOUTH) {
        if (currentY == coordinates.getY().getMaxLocation()) {
          currentY = 0;
        } else {
          currentY++;
        }
      } else if (coordinates.getDirection() == Direction.WEST) {
        if (currentX == coordinates.getX().getMaxLocation()) {
          currentX = 0;
        } else {
          currentX++;
        }
      }
    }

    if (coordinates.hasObstacle(currentX, currentY)) {
      return true;
    }

    return false;
  }
}
