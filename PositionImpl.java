package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public Position getNeighbor(Direction direction) {
    int new_x = this.x;
    int new_y = this.y;
    if (direction == Direction.EAST) {
      new_x += 1;
    } else if (direction == Direction.NORTH) {
      new_y += 1;
    } else if (direction == Direction.SOUTH) {
      new_y -= 1;
    } else {
      new_x -= 1;
    }
    return new PositionImpl(new_x, new_y);
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Position) {
      return (this.toString().equals(other.toString()));
    }
    return false;
  }
}
