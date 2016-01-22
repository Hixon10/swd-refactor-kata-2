package task3;

import java.util.List;

public class Coordinates {
  private Point x;
  private Point y;
  private Direction directionValue;
  private List<Obstacle> obstaclesValue;

  public Point getX() {
    return x;
  }

  public Point getY() {
    return y;
  }

  public void setDirection(Direction value) {
    directionValue = value;
  }

  public Direction getDirection() {
    return directionValue;
  }

  public void setObstacles(List<Obstacle> value) {
    obstaclesValue = value;
  }

  public Boolean hasObstacle(int x, int y) {
    for (Obstacle obstacle : obstaclesValue) {
      if (obstacle.getX() == x && obstacle.getY() == y) {
        return true;
      }
    }

    return false;
  }

  public boolean hasObstacleInFront() {
    if (move(1)) {
      move(-1);
      return false;
    }

    return true;
  }

  public Boolean canMove(int x, int y) {
    return !hasObstacle(this.x.getLocation() + x, this.y.getLocation() + y);
  }

  public Coordinates(Point xValue,
                     Point yValue,
                     Direction directionValue,
                     List<Obstacle> obstaclesValue) {
    x = xValue;
    y = yValue;
    this.directionValue = directionValue;
    this.obstaclesValue = obstaclesValue;
  }

  @Override
  public String toString() {
    return String.format("%d X %d %s", getX().getLocation(), getY().getLocation(),
            getDirection().toString().charAt(0));
  }

  public void setY(Point y) {
    this.y = y;
  }

  public void setX(Point x) {
    this.x = x;
  }

  public boolean move(int delta) {
    if (directionValue == Direction.EAST) {
      return move(delta, 0);
    } else if (directionValue == Direction.NORTH) {
      return move(0, delta);
    } else if (directionValue == Direction.SOUTH) {
      return move(0, -delta);
    } else if (directionValue == Direction.WEST) {
      return move(-delta, 0);
    }

    return false;
  }

  public void turnLeft() {
    if (directionValue == Direction.EAST) {
      directionValue = Direction.NORTH;
    } else if (directionValue == Direction.NORTH) {
      directionValue = Direction.WEST;
    } else if (directionValue == Direction.SOUTH) {
      directionValue = Direction.EAST;
    } else if (directionValue == Direction.WEST) {
      directionValue = Direction.SOUTH;
    }
  }

  public void turnRight() {
    if (directionValue == Direction.EAST) {
      directionValue = Direction.SOUTH;
    } else if (directionValue == Direction.NORTH) {
      directionValue = Direction.EAST;
    } else if (directionValue == Direction.SOUTH) {
      directionValue = Direction.WEST;
    } else if (directionValue == Direction.WEST) {
      directionValue = Direction.NORTH;
    }
  }

  private boolean move(int xValue, int yValue) {
    if (!hasObstacle(this.x.getLocation() + xValue, this.y.getLocation() + yValue)) {
      x.setLocation(x.getLocation() + xValue);
      y.setLocation(y.getLocation() + yValue);
      return true;
    }
    return false;
  }
}