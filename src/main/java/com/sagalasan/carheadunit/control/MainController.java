package com.sagalasan.carheadunit.control;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.text.SimpleDateFormat;

/**
 * Created by christiaan on 6/12/16.
 */
public class MainController extends Controller
{
  @FXML
  private Label clockLabel;

  @FXML
  private StackPane contentHolder;

  public void setContentHolder(Parent parent)
  {
    contentHolder.getChildren().setAll(parent);
  }

  @Override
  public void onCurrentTimeReceived(long time)
  {
    Platform.runLater(() -> clockLabel.setText(new SimpleDateFormat("HH:mm").format(time)));
  }
}
