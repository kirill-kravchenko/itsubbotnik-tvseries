package com.epam.tvseries.app.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
  private final long id;
  private final double value;

  @JsonCreator
  public Rating(
    @JsonProperty("id") long id,
    @JsonProperty("value") double value
  ) {
    this.id = id;
    this.value = value;
  }

  public long getId() {
    return id;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Rating{" +
      "id=" + id +
      ", value=" + value +
      '}';
  }
}
