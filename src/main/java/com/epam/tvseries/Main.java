package com.epam.tvseries;

import com.epam.tvseries.app.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    View view = new View();

    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 300, 275);
    primaryStage.setTitle("Hello World");
    root.setTop(view.textfield());
    root.setCenter(view.init());

    root.setStyle("-fx-background-color: #3f51b5;");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setMaximized(true);
  }


  public static void main(String[] args) {
    launch(args);
  }
}
