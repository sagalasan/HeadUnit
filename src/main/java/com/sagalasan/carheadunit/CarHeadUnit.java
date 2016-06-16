package com.sagalasan.carheadunit;

import com.sagalasan.carheadunit.service.CurrentTimeService;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by christiaan on 6/15/16.
 */
public class CarHeadUnit extends Application
{
  private Vertx vertx;
  private GuiVerticle guiVerticle;

  @Override
  public void init()
  {
    vertx = Vertx.vertx();
    System.out.println("HI");
    guiVerticle = new GuiVerticle();
    vertx.deployVerticle(guiVerticle, res ->
    {
      if(res.succeeded()) System.out.println("hello");
    });
    System.out.println("After dec");

    vertx.deployVerticle(new CurrentTimeService(), new DeploymentOptions().setWorker(true));
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    StackPane root = new StackPane();
    Scene scene = new Scene(root, 800, 600);

    primaryStage.setTitle("Hello");
    primaryStage.setScene(scene);
    primaryStage.setOnCloseRequest(value ->
    {
      Platform.exit();
      System.exit(0);
    });
    primaryStage.show();
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
