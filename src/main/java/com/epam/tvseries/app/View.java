package com.epam.tvseries.app;

import com.epam.tvseries.app.components.Card;
import com.epam.tvseries.app.entities.TvSeriesResponse;
import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.schedulers.Schedulers;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;

public class View {
  private GridPane grid = new GridPane();
  private TextField search = new TextField();
  private int xIndex = 0;
  private int yIndex = 0;
  private final Presenter presenter;

  public View() {
    this.presenter = new Presenter(this);
  }

  public Node textfield() {
    return search;
  }

  public Node init() {
    grid.setPadding(new Insets(16));
    grid.setVgap(8);
    grid.setHgap(8);

    presenter.load();

    return grid;
  }

  public void render(List<TvSeriesResponse> tvSeriesResponse) {
    grid.getChildren().clear();
    xIndex = 0;
    yIndex = 0;
    for (TvSeriesResponse response : tvSeriesResponse) {
      Card card = new Card(response);
      Node node = card.create();

      if (xIndex > 1) {
        xIndex = 0;
      }

      if (xIndex == 0) {
        yIndex++;
      }

      GridPane.setConstraints(node, xIndex++, yIndex);
      grid.getChildren().add(node);
    }
  }

  public Observable<String> getSearchQuery() {
    return JavaFxObservable.valuesOf(search.textProperty())
      .observeOn(Schedulers.computation());
  }
}