package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null...");
    }
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object item) {
    if (item instanceof Item) {
      return (this.name.equals(item.toString()));
    }
    return false;
  }

  @Override
  public String getName() {
    return name;
  }
}
