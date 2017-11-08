package eu.wodrobina.LedStripWebControl.server;

import eu.wodrobina.LedStripWebControl.objects.LedStrip;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
public class LedStripServer implements LedStripObserver{

    List<LedStrip> LedStrips = new ArrayList<>();

    @Override
    public void update() {

    }
}
