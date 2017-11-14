package eu.wodrobina.LedStripWebControl.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import eu.wodrobina.LedStripWebControl.objects.WebLedStrip;
import eu.wodrobina.LedStripWebControl.objects.WebLedStripImpl;
import org.springframework.context.annotation.DependsOn;

import java.util.List;


@SpringComponent
@UIScope
public class LedStripSettingLayout extends FormLayout {

    private Grid<WebLedStrip> ledStripsGrid = new Grid<>();

    public LedStripSettingLayout() {
        addComponent(ledStripsGrid);
        ledStripsGridConfig();

    }

    private void ledStripsGridConfig(){
        ledStripsGrid.setSizeFull();
        ledStripsGrid.setRowHeight(42);

        ledStripsGrid.addComponentColumn(WebLedStrip::getIsOn)
                .setCaption("Is On")
                .setMinimumWidth(70)
                .setMaximumWidth(70);

        ledStripsGrid.addColumn(WebLedStrip::getIpAdress)
                .setCaption("IP Adress")
                .setMinimumWidth(150)
                .setMaximumWidth(150);

        ledStripsGrid.addColumn(WebLedStrip::getPort)
                .setCaption("Port")
                .setMinimumWidth(100)
                .setMaximumWidth(100);

        ledStripsGrid.addComponentColumn(WebLedStrip::getColorPicker)
                .setCaption("Colour")
                .setStyleGenerator(item -> "v-align-center")
                .setMinimumWidth(125)
                .setMaximumWidth(125);

        ledStripsGrid.addComponentColumn(WebLedStrip::getBrightlesSlider)
                .setCaption("Brightless")
                .setStyleGenerator(item -> "v-align-center")
                .setMinimumWidth(125);

        ledStripsGrid.addColumn(WebLedStrip::getDescription)
                .setCaption("Description");
    }

    public void addLedStrip(WebLedStrip webLedStrip){
        ledStripsGrid.setItems(webLedStrip);
    }

    public void addLedStrips(List<WebLedStrip> webLedStrips){
        ledStripsGrid.setItems(webLedStrips);
    }

}
