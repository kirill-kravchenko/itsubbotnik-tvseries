package com.epam.tvseries.app.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class News {
  private final long id;
  private final String description;

  @JsonCreator
  public News(
    @JsonProperty("id") long id,
    @JsonProperty("description") String description
  ) {
    this.id = id;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "News{" +
      "id=" + id +
      ", description='" + description + '\'' +
      '}';
  }
}
