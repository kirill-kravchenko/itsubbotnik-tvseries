package com.epam.tvseries.app.services;

import com.epam.tvseries.app.entities.Actor;
import com.epam.tvseries.app.entities.News;
import com.epam.tvseries.app.entities.Rating;
import com.epam.tvseries.app.entities.TvSeries;
import com.epam.tvseries.app.utils.Loader;
import io.reactivex.Observable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TvSeriesService {

  public Observable<TvSeries> searchTVSeries(String query) {
    List<TvSeries> seriesList = Loader.loadTvSeriesJson();
    return Observable.fromIterable(seriesList
                                     .stream()
                                     .filter(tvSeries -> tvSeries.getTitle().toLowerCase()
                                       .contains(query.toLowerCase()))
                                     .collect(Collectors.toList()));
  }

  public Observable<News> getTVSeriesNews(long id) {
    Map<Long, List<News>> news = Loader.loadTvSeriesNewsJson();
    return Observable.fromIterable(news.get(id)).delay(300, TimeUnit.MILLISECONDS);
  }

  public Observable<Actor> getTVSeriesCast(long id) {
    Map<Long, List<Actor>> cast = Loader.loadTvSeriesCastJson();
    return Observable.fromIterable(cast.get(id)).delay(200, TimeUnit.MILLISECONDS);
  }

  public Observable<Rating> getTVSeriesRating(long id) {
    Map<Long, Rating> ratings = Loader.loadTvSeriesRatingJson();
    return Observable.just(ratings.get(id)).delay(100, TimeUnit.MILLISECONDS);
  }
}
