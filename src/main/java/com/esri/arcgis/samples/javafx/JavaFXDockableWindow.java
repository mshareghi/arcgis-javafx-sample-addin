package com.esri.arcgis.samples.javafx;

import com.esri.arcgis.addins.desktop.DockableWindow;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.awt.*;

/**
 * The class for a simple JavaFX Dockable Window.
 */
public class JavaFXDockableWindow extends DockableWindow {

  public static final String ID = "com.esri.arcgis.samples.javafx.jfxdockablewindow";

  public JavaFXDockableWindow() {

  }

  @Override
  public Component createUI() {
    final JFXPanel fxPanel = new JFXPanel();
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        initFX(fxPanel);
      }
    });
    return fxPanel;
  }


  private void initFX(JFXPanel fxPanel) {
    final Scene scene = createScene();

    // This method is invoked on JavaFX thread
    fxPanel.setScene(scene);
  }


  private static Scene createScene() {
    Group root = new Group();
    Scene scene = new Scene(root, javafx.scene.paint.Color.ALICEBLUE);
    Text text = new Text();

    text.setX(40);
    text.setY(100);
    text.setFont(new javafx.scene.text.Font(25));
    text.setText("JavaFX Window!");

    root.getChildren().add(text);

    return (scene);
  }

}
