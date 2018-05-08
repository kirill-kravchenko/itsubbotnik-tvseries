package com.epam.tvseries.app.utils;

import com.epam.tvseries.app.entities.Actor;
import com.epam.tvseries.app.entities.News;
import com.epam.tvseries.app.entities.Rating;
import com.epam.tvseries.app.entities.TvSeries;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.text.Font;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Loader {
  private final static ObjectMapper mapper = new ObjectMapper();

  public static List<TvSeries> loadTvSeriesJson() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    List<TvSeries> seriesList = new ArrayList<>();
    try (InputStream is = classloader.getResourceAsStream("json/tvseries.json")) {
      seriesList = Arrays.asList(mapper.readValue(is, TvSeries[].class));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return seriesList;
  }

  public static Map<Long, List<Actor>> loadTvSeriesCastJson() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    Map<Long, List<Actor>> cast = new HashMap<>();
    try (InputStream is = classloader.getResourceAsStream("json/cast.json")) {
      JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, Actor.class);
      JavaType longType = mapper.getTypeFactory().constructType(Long.class);
      JavaType mapType = mapper.getTypeFactory().constructMapType(Map.class, longType, listType);

      cast = mapper.readValue(is, mapType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return cast;
  }

  public static Map<Long, List<News>> loadTvSeriesNewsJson() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    Map<Long, List<News>> news = new HashMap<>();
    try (InputStream is = classloader.getResourceAsStream("json/news.json")) {
      JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, News.class);
      JavaType longType = mapper.getTypeFactory().constructType(Long.class);
      JavaType mapType = mapper.getTypeFactory().constructMapType(Map.class, longType, listType);

      news = mapper.readValue(is, mapType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return news;
  }

  public static Map<Long, Rating> loadTvSeriesRatingJson() {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    Map<Long, Rating> ratings = new HashMap<>();
    try (InputStream is = classloader.getResourceAsStream("json/ratings.json")) {
      JavaType mapType = mapper.getTypeFactory().constructMapType(Map.class, Long.class, Rating.class);

      ratings = mapper.readValue(is, mapType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ratings;
  }

  public static Font loadFont(double value) {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    return Font.loadFont(classloader.getResourceAsStream("fonts/Roboto-Medium.ttf"), value);
  }
}
