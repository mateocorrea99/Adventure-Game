package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private Map map;
  private Player player;

  public GameImpl(Map map, Player player) {
    if (player == null || map == null) {
      throw new IllegalArgumentException("Some input is null.");
    }
    this.player = player;
    this.map = map;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    // check for cloned.
    return player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return (map.getNumItems() == player.getInventory().getNumItems());
  }

  @Override
  public void printCellInfo() {
    Cell current_cell = map.getCell(player.getPosition());
    String cell_name = current_cell.getName();
    String cell_description = current_cell.getDescription();
    boolean cell_visited = current_cell.getIsVisited();
    boolean cell_has_chest = current_cell.hasChest();

    System.out.printf("Location: %s\n", cell_name);
    System.out.println(cell_description);
    if (cell_visited) {
      System.out.println("You have already visited this location.");
    }
    if (cell_has_chest) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }

    current_cell.visit();
  }

  @Override
  public void openChest() {
    Cell current_cell = map.getCell(player.getPosition());
    boolean cell_has_chest = current_cell.hasChest();

    if (!cell_has_chest) {
      System.out.println("No chest to open, sorry!");
    } else {
      Inventory chest = current_cell.getChest();
      if (chest.isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println("You collected these items: " + chest.getItems());
        player.getInventory().transferFrom(chest);
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    int max_x = map.getWidth() - 1;
    int max_y = map.getHeight() - 1;
    Position new_position = this.getPlayerPosition().getNeighbor(direction);

    return (0 <= new_position.getX()
        && 0 <= new_position.getY()
        && new_position.getX() <= max_x
        && new_position.getY() <= max_y
        && map.getCell(new_position) != null);
  }

  @Override
  public void move(Direction direction) {
    if (this.canMove(direction)) {
      player.move(direction);
      this.printCellInfo();
    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
