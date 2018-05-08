package com.epam.tvseries.app.components;

import com.epam.tvseries.app.entities.Actor;
import com.epam.tvseries.app.entities.News;
import com.epam.tvseries.app.entities.TvSeriesResponse;
import com.epam.tvseries.app.utils.Loader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Card {
  private final ImageView image;
  private final Text title;
  private final Text rating;
  private final Text description;
  private final VBox titleGroup;
  private final Text cast;
  private final VBox castGroup;
  private final Text news;
  private final VBox newsGroup;

  public Card(TvSeriesResponse tvSeriesResponse) {
    this.image = new ImageView("images/" + tvSeriesResponse.getTvSeries().getImage());

    this.title = new Text(tvSeriesResponse.getTvSeries().getTitle());
    this.title.setFont(Loader.loadFont(24));
    this.title.setFill(Color.WHITE);
    this.titleGroup = new VBox(title);
    this.titleGroup.setPadding(new Insets(16, 0, 24, 0));

    this.rating = new Text(Double.toString(tvSeriesResponse.getRating().getValue()));
    this.description = new Text(tvSeriesResponse.getTvSeries().getDescription());
    this.description.setFont(Loader.loadFont(16));
    this.description.setFill(Color.WHITE);
    this.description.setWrappingWidth(512);

    this.cast = new Text(tvSeriesResponse
                           .getCast()
                           .stream()
                           .map(Actor::getName)
                           .reduce((s1, s2) -> s1 + "; " + s2)
                           .get());
    this.cast.setFont(Loader.loadFont(14));
    this.cast.setFill(Color.WHITE);
    this.castGroup = new VBox(cast);
    this.castGroup.setPadding(new Insets(16, 0, 0, 0));

    this.news = new Text(tvSeriesResponse
                           .getNews()
                           .stream()
                           .map(News::getDescription)
                           .reduce((n1, n2) -> n1 + "\n " + n2)
                           .get());
    this.news.setFont(Loader.loadFont(14));
    this.news.setFill(Color.WHITE);
    this.news.setWrappingWidth(512);
    this.newsGroup = new VBox(news);
    this.newsGroup.setPadding(new Insets(16, 0, 0, 0));
  }

  public Node create() {
    HBox root = new HBox();
    root.setPadding(new Insets(24));

    VBox imageWithRatingLayout = new VBox();
    imageWithRatingLayout.setPadding(new Insets(0, 24, 16, 0));
    VBox titleWithDescWithCastWithNews = new VBox();

    imageWithRatingLayout.getChildren().addAll(image, rating);
    titleWithDescWithCastWithNews.getChildren().addAll(titleGroup, description, castGroup, newsGroup);

    root.getChildren().addAll(imageWithRatingLayout, titleWithDescWithCastWithNews);
    return root;
  }
}
