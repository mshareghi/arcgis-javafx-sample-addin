package com.esri.arcgis.samples.javafx;

import com.esri.arcgis.addins.desktop.Button;
import com.esri.arcgis.framework.IApplication;
import com.esri.arcgis.framework.IDockableWindow;
import com.esri.arcgis.framework.IDockableWindowManager;
import com.esri.arcgis.framework.IDockableWindowManagerProxy;
import com.esri.arcgis.system.UID;

/**
 * The class for a JavaFX Dockable Window Button, which can toggle the Dockable Window on and off.
 */
public class JavaFXShowDockableWindowButton extends Button {

  private IDockableWindow win;
  private IApplication application;

  // Returns whether this button is checked
  public boolean isChecked() {
    return false;
  }

  // Returns whether this button is enabled
  public boolean isEnabled() {
    return true;
  }

  // This is called when the button is clicked
  public void onClick() {
    try {

      if (win == null) {
        //  Get the window id
        UID uid = new UID();

        // id attribute specified in the <DockableWindow> tag
        uid.setValue(JavaFXDockableWindow.ID);

        IDockableWindowManager dwm =
            new IDockableWindowManagerProxy(application);

        // IDockableWindowManager app1 = (IDockableWindowManager) app;
        win = dwm.getDockableWindow(uid);
      }

      win.show(!win.isVisible());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* This initializes the button.In this method you set the value of the dockable window id that you have
  *  provided in the config.xml
  */
  public void init(IApplication app) {
    this.application = app;
  }

}
