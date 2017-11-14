package eu.wodrobina.LedStripWebControl.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import eu.wodrobina.LedStripWebControl.objects.LedStrip;
import eu.wodrobina.LedStripWebControl.objects.LedStripDAO;
import eu.wodrobina.LedStripWebControl.objects.WebLedStrip;
import eu.wodrobina.LedStripWebControl.objects.WebLedStripImpl;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class LedStripControlGridLayout extends VerticalLayout{


    private LedStripDAO dao;

    private HorizontalLayout buttonsLayout;
    private Label isOnLbl;
    private CheckBox isOn;
    private Label ipAddressLbl;
    private TextField ipAddressTxtFld;
    private Label portLbl;
    private TextField portTxtFld;
    private Label colourLbl;
    private ColorPicker colorPicker;
    private Label brightlessLbl;
    private Slider brightlessSlider;
    private Label descriptionLbl;
    private TextArea description;

    @Autowired
    public LedStripControlGridLayout(LedStripDAO dao) {
        this.dao = dao;
        configButtonLayout();
        configIsOn();
        configIpAddress();
        configPort();
        configColourPicker();
        configBrightless();
        configDescription();
    }

    private void configButtonLayout() {
        buttonsLayout = new HorizontalLayout();
        Button addLedStrip = new Button("Add");
        addLedStrip.addClickListener(click->{
            WebLedStrip webLedStrip = new WebLedStripImpl(
                    ipAddressTxtFld.getValue(),
                    Integer.parseInt(portTxtFld.getValue()
                    ));
            dao.addOne(webLedStrip);
        });
        Button delLedStrip = new Button("Delete");
        buttonsLayout.addComponents(addLedStrip, delLedStrip);
        this.addComponent(buttonsLayout);
    }

    private void configIsOn() {
        isOnLbl = new Label("Is on:");
        this.addComponent(isOnLbl);
        isOn = new CheckBox();
        this.addComponent(isOn);
    }

    private void configIpAddress() {
        ipAddressLbl = new Label("Ip Address");
        this.addComponent(ipAddressLbl);
        ipAddressTxtFld = new TextField();
        this.addComponent(ipAddressTxtFld);
    }

    private void configPort() {
        portLbl = new Label("Port:");
        this.addComponent(portLbl);
        portTxtFld = new TextField();
        this.addComponent(portTxtFld);
    }

    private void configColourPicker() {
        colourLbl = new Label("Colour:");
        this.addComponent(colourLbl);
        colorPicker = new ColorPicker();
        this.addComponent(colorPicker);
    }

    private void configBrightless() {
        brightlessLbl = new Label("Brightless:");
        this.addComponent(brightlessLbl);
        brightlessSlider = new Slider();
        brightlessSlider.setWidth("100%");
        this.addComponent(brightlessSlider);
    }

    private void configDescription() {
        descriptionLbl = new Label("Description:");
        this.addComponent(descriptionLbl);
        description = new TextArea();
        this.addComponent(description);
    }
}
