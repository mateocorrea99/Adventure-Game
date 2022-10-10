package com.comp301.a02adventure;

public class PlayerImpl implements Player {
  private String name;
  private Position position;
  private Inventory inventory;

  public PlayerImpl(String name, int start_x, int start_y) {
    if (name == null) {
      throw new IllegalArgumentException("Name is null.");
    }
    this.name = name;
    this.position = new PositionImpl(start_x, start_y);
    this.inventory = new InventoryImpl();
  }

  public Position getPosition() {
    return position;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public String getName() {
    return name;
  }

  public void move(Direction direction) {
    this.position = position.getNeighbor(direction);
  }
}
