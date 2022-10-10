package com.comp301.a02adventure;

import java.util.*;

public class InventoryImpl implements Inventory {
  private List<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<>();
  }

  public boolean isEmpty() {
    return (items.size() == 0);
  }

  public int getNumItems() {
    return items.size();
  }

  public List<Item> getItems() {
    List<Item> new_list = new ArrayList<>(this.items);
    return new_list;
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public void clear() {
    this.items.clear();
  }

  public void transferFrom(Inventory other) {
    for (Item item : other.getItems()) {
      this.items.add(item);
      other.removeItem(item);
    }
  }
}
