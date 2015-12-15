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
    throw new UnsupportedOperationException();
  }

  public void setY(Point y) {
    this.y = y;
  }

  public void setX(Point x) {
    this.x = x;
  }
}