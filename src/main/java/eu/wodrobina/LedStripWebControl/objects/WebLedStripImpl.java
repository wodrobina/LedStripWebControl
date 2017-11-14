package eu.wodrobina.LedStripWebControl.objects;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;


public class WebLedStripImpl extends LedStripImpl implements WebLedStrip {

    private ColorPicker colorPicker;
    private Slider brightlesSlider;
    private CheckBox isOn;
    private double lastBrightlessState;


    public WebLedStripImpl(String ipAdress, int port) {
        super(ipAdress, port);

        colorPicker = new ColorPicker();
        colorPickerConfig();

        brightlesSlider = new Slider();
        sliderConfig();

        isOn = new CheckBox();
        isOnRadioButtonConfig();
    }

    private void isOnRadioButtonConfig() {
        isOn.setValue(true);
        isOn.addValueChangeListener(event-> {
            if(!event.getValue()){
                lastBrightlessState = brightlesSlider.getValue();
                super.setBrightless(0);
                brightlesSlider.setEnabled(false);
                colorPicker.setEnabled(false);
                Notification.show("Device from: \n" +
                                "IP - " + super.getIpAdress() +
                                "\nPort - " + super.getPort() +
                                "\n Turned OFF",
                        Notification.Type.TRAY_NOTIFICATION);

            } else {
                Notification.show("Device from: \n" +
                                "IP - " + super.getIpAdress() +
                                "\nPort - " + super.getPort() +
                                "\n Turned ON",
                        Notification.Type.TRAY_NOTIFICATION);
                super.setBrightless(lastBrightlessState);
                brightlesSlider.setEnabled(true);
                colorPicker.setEnabled(true);
            }
        });
    }

    private void sliderConfig() {
        brightlesSlider.setSizeFull();
        brightlesSlider.addValueChangeListener(event -> {Notification.show("Brightless changed:",
                String.valueOf(event.getValue() +"%"),
                Notification.Type.TRAY_NOTIFICATION);
                super.setBrightless(event.getValue());
        });
    }

    private void colorPickerConfig(){
        colorPicker.setSwatchesVisibility(false);
        colorPicker.setHistoryVisibility(false);
        colorPicker.setTextfieldVisibility(true);
        colorPicker.setHSVVisibility(false);
        colorPicker.addValueChangeListener(event -> {Notification.show(
                "Color changed: \n"
                        + "Red\t-\t" + event.getValue().getRed() + "\n"
                        + "Green\t-\t" + event.getValue().getGreen() + "\n"
                        + "Blue\t-\t" + event.getValue().getBlue(),
                Notification.Type.TRAY_NOTIFICATION);
            super.setRed(event.getValue().getRed());
            super.setGreen(event.getValue().getGreen());
            super.setBlue(event.getValue().getBlue());
        });
    }

    public Slider getBrightlesSlider() {
        return brightlesSlider;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public CheckBox getIsOn() {
        return isOn;
    }


}
