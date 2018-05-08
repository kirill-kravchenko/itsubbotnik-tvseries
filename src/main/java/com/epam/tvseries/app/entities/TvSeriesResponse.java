package com.epam.tvseries.app.entities;

import java.util.List;

public class TvSeriesResponse {
  private final TvSeries tvSeries;
  private final List<News> news;
  private final List<Actor> cast;
  private final Rating rating;

  public TvSeriesResponse(
    TvSeries tvSeries, List<News> news, List<Actor> cast, Rating rating
  ) {
    this.tvSeries = tvSeries;
    this.news = news;
    this.cast = cast;
    this.rating = rating;
  }

  public TvSeries getTvSeries() {
    return tvSeries;
  }

  public List<Actor> getCast() {
    return cast;
  }

  public List<News> getNews() {
    return news;
  }

  public Rating getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return "TvSeriesResponse{" +
      "tvSeries=" + tvSeries +
      ", news=" + news +
      ", cast=" + cast +
      ", rating=" + rating +
      '}';
  }
}
