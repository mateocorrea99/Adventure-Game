package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private String name;
  private final Position position;
  private boolean visited;
  private String description;
  private Inventory chest;

  public CellImpl(int x, int y, String name, String description) {
    if (name == null || description == null) {
      throw new IllegalArgumentException("Null name or description.");
    }
    this.name = name;
    this.description = description;
    this.position = new PositionImpl(x, y);
    this.visited = false;
    this.chest = null;
  }

  public CellImpl(int x, int y) {
    this(x, y, "", "");
  }

  public Inventory getChest() {
    return chest;
  }

  public void setChest(Inventory other) {
    if (other == null) {
      throw new IllegalArgumentException("Null value.");
    }
    this.chest = other;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public Position getPosition() {
    return this.position;
  }

  public boolean getIsVisited() {
    return this.visited;
  }

  public boolean hasChest() {
    return (chest != null);
  }

  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Null value.");
    }
    this.name = name;
  }

  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Null value.");
    }
    this.description = description;
  }

  public void visit() {
    this.visited = true;
  }

  @Override
  public String toString() {
    return this.position.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Cell) {
      return (this.position.equals(((Cell) other).getPosition()));
    }
    return false;
  }
}
