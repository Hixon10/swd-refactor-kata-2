package task3;

public class Point {
  private int location;
  public void setLocation(int value) {
    location = (value + maxLocation) % maxLocation;
  }
  public int getLocation() { return location; }

  private int maxLocation;
  public void setMaxLocation(int value) {
    maxLocation = value + 1;
    location = location % maxLocation;
  }
  public int getMaxLocation() { return maxLocation - 1; }

  public Point(int locationValue, int maxLocationValue) {
    maxLocation = maxLocationValue + 1;
    location = locationValue % maxLocation;
  }
}