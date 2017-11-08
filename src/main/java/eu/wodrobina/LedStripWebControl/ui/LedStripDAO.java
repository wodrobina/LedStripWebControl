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
                new WebLedStrip("192.168.1.4", 8092)
        );
    }
}
