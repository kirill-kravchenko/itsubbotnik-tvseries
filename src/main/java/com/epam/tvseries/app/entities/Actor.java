package com.epam.tvseries.app.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {
  private final long id;
  private final String name;

  @JsonCreator
  public Actor(
    @JsonProperty("id") long id,
    @JsonProperty("name") String name
  ) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Actor{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
