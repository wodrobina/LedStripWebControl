package eu.wodrobina.LedStripWebControl.objects;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.Slider;

public interface WebLedStrip {

    CheckBox getIsOn();
    String getIpAdress();
    int getPort();
    ColorPicker getColorPicker();
    Slider getBrightlesSlider();
    String getDescription();

}
