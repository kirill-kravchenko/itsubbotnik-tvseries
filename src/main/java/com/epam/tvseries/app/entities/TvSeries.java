package com.epam.tvseries.app.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TvSeries {
  private final long id;
  private final String title;
  private final String image;
  private final String description;

  @JsonCreator
  public TvSeries(
    @JsonProperty("id") long id,
    @JsonProperty("title") String title,
    @JsonProperty("image") String image,
    @JsonProperty("description") String description
  ) {
    this.id = id;
    this.title = title;
    this.image = image;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getImage() {
    return image;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return "TvSeries{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", image='" + image + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
}
