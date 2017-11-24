package eu.wodrobina.LedStripWebControl.objects;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LedStripDAO {

    private List<WebLedStrip> ledStrips;

    @PostConstruct
    private void init(){
        ledStrips = new ArrayList<>();
        ledStrips.add(new WebLedStripImpl("192.168.1.2", 8092));
        ledStrips.add(new WebLedStripImpl("192.168.1.3", 8093));
        ledStrips.add(new WebLedStripImpl("192.168.1.4", 8094));
    }

    public List<WebLedStrip> findAll(){
        return ledStrips;
    }

    public void addOne(WebLedStrip webLedStrip){
        ledStrips.add(webLedStrip);
    }
}
