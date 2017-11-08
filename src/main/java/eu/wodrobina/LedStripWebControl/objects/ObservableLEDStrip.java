package eu.wodrobina.LedStripWebControl.objects;

public interface ObservableLEDStrip {
    void subscribe();
    void unsubscribe();
    void notifyObserver();
}
