package com.comp301.a02adventure;

public class MapImpl implements Map {
  private int height;
  private int width;
  private int numItems;
  private Cell[][] cells;

  public MapImpl(int width, int height, int numItems) {
    if (height < 1 || width < 1) {
      throw new IllegalArgumentException("Some value is invalid.");
    }
    this.height = height;
    this.width = width;
    this.numItems = numItems;
    this.cells = new CellImpl[width][height];
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public void initCell(int x, int y) {
    if (x > width || y > height) {
      throw new IndexOutOfBoundsException();
    }
    cells[x][y] = new CellImpl(x, y);
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x > width || y > height) {
      throw new IndexOutOfBoundsException();
    }
    return cells[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    int x = position.getX();
    int y = position.getY();
    if (x > width || y > height) {
      throw new IndexOutOfBoundsException();
    }
    return cells[x][y];
  }
}
