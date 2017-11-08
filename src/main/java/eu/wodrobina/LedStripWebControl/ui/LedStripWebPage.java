package eu.wodrobina.LedStripWebControl.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "/")
public class LedStripWebPage extends UI{

    @Autowired
    private LedStripDAO ledStripDAO;
    @Autowired
    private LedStripControlLayout ledStripleyout;

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

        VerticalLayout content = new VerticalLayout();
        content.setSpacing(true);
        content.setMargin(true);
        menuAndContent.addComponents(content);

        menuAndContent.setExpandRatio(menu,2);
        menuAndContent.setExpandRatio(content,8);

        Label header = new Label("Control Panel:");
        header.addStyleName("h2");
        content.addComponent(header);

        ledStripleyout.addLedStrips(ledStripDAO.findAll());
        content.addComponent(ledStripleyout);
    }

}
