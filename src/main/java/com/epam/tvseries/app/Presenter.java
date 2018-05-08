package com.epam.tvseries.app;

import com.epam.tvseries.app.entities.Actor;
import com.epam.tvseries.app.entities.News;
import com.epam.tvseries.app.entities.Rating;
import com.epam.tvseries.app.entities.TvSeriesResponse;
import com.epam.tvseries.app.services.TvSeriesService;
import io.reactivex.Observable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Presenter {
  private final View view;
  private final TvSeriesService tvSeriesService = new TvSeriesService();

  public Presenter(View view) {
    this.view = view;
  }

  public void load() {
    view.getSearchQuery()
      .debounce(1, TimeUnit.SECONDS)
      .doOnNext(System.out::println)
      .flatMap(query -> tvSeriesService.searchTVSeries(query)
        .flatMap(tvSeries -> {
          Observable<Rating> ratingObservable = tvSeriesService.getTVSeriesRating(tvSeries.getId());
          Observable<List<News>> newsObservable = tvSeriesService.getTVSeriesNews(tvSeries.getId())
            .toList()
            .toObservable();
          Observable<List<Actor>> castObservable = tvSeriesService.getTVSeriesCast(tvSeries.getId())
            .toList()
            .toObservable();

          return Observable.zip(ratingObservable, newsObservable, castObservable, ((rating, newses, actors) -> new TvSeriesResponse(tvSeries, newses, actors, rating)));
        })
        .toList()
        .toObservable())
      .observeOn(JavaFxScheduler.platform())
      .subscribe(view::render);
  }
}
