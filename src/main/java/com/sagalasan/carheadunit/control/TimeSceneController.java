package com.sagalasan.carheadunit.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;

/**
 * Created by christiaan on 6/11/16.
 */
public class TimeSceneController extends Controller
{
  @FXML
  private Text timeText;

  @Override
  public void onCurrentTimeReceived(long time)
  {
    Platform.runLater(() -> timeText.setText(new SimpleDateFormat("HH:mm:ss").format(time)));
  }
}
