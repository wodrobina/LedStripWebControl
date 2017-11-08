package eu.wodrobina.LedStripWebControl.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import eu.wodrobina.LedStripWebControl.objects.WebLedStrip;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI(path = "/")
public class LedStripControlPage extends UI{

    @Autowired
    private LedStripDAO ledStripDAO;
    private Grid<WebLedStrip> ledStripsGrid = new Grid<>();

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout vlayout = new VerticalLayout();
        setContent(vlayout);

        vlayout.addComponent(ledStripsGrid);
        vlayout.setExpandRatio(ledStripsGrid,1);
        ledStripsGridConfig();

        ledStripsGrid.setItems(ledStripDAO.findAll());
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
}
