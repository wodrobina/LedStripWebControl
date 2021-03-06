package eu.wodrobina.LedStripWebControl.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import eu.wodrobina.LedStripWebControl.objects.LedStripDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SpringUI(path = "/")
public class LedStripWebPageUI extends UI{

    @Autowired
    private LedStripDAO ledStripDAO;
    @Autowired
    private LedStripAddFormLayout ledStripControlLayout;
    @Autowired
    private LedStripTableLayout ledStripSettingLayout;

    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout layout = new VerticalLayout();
        setContent(layout);

        CssLayout topbar = new CssLayout();
        Label title = new Label("Web LED Control");
        title.addStyleName("h1");
        topbar.addComponent(title);
        topbar.addStyleName("top");
        layout.addComponent(topbar);

        HorizontalLayout menuAndContent = new HorizontalLayout();
        menuAndContent.setSizeFull();
        layout.addComponent(menuAndContent);

        CssLayout menu = new CssLayout();
        menu.setWidth("100%");
        menu.addStyleName("menu");
        menuAndContent.addComponent(menu);
//        ledStripControlLayout = new LedStripAddFormLayout();
        menu.addComponent(ledStripControlLayout);

        VerticalLayout content = new VerticalLayout();
        content.setSpacing(true);
        content.setMargin(true);
        menuAndContent.addComponents(content);

        menuAndContent.setExpandRatio(menu,2);
        menuAndContent.setExpandRatio(content,8);

        Label header = new Label("Control Panel:");
        header.addStyleName("h2");
        content.addComponent(header);

        ledStripSettingLayout.addLedStrips(ledStripDAO.findAll());
        content.addComponent(ledStripSettingLayout);
    }

}
