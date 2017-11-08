package eu.wodrobina.LedStripWebControl.ui;

import eu.wodrobina.LedStripWebControl.objects.WebLedStrip;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class LedStripDAO {

    public List<WebLedStrip> findAll(){
        return Arrays.asList(
                new WebLedStrip("192.168.1.2", 8090),
                new WebLedStrip("192.168.1.3", 8090),
                new WebLedStrip("192.168.1.4", 8092),
                new WebLedStrip("192.168.1.5", 8090),
                new WebLedStrip("192.168.1.6", 8090),
                new WebLedStrip("192.168.1.7", 8092),
                new WebLedStrip("192.168.1.8", 8090),
                new WebLedStrip("192.168.1.9", 8090),
                new WebLedStrip("192.168.1.10", 8092),
                new WebLedStrip("192.168.1.11", 8090),
                new WebLedStrip("192.168.1.12", 8090),
                new WebLedStrip("192.168.1.13", 8092),
                new WebLedStrip("192.168.1.14", 8090),
                new WebLedStrip("192.168.1.15", 8090),
                new WebLedStrip("192.168.1.16", 8092)
        );
    }
}
