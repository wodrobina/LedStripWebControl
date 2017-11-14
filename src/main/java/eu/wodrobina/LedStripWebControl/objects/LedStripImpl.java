package eu.wodrobina.LedStripWebControl.objects;

public class LedStripImpl implements LedStrip{
    private int red;
    private int green;
    private int blue;
    private int white;

    private double brightless;
    private String ipAdress;
    private int port;
    private String description;

    public LedStripImpl() {

    }

    public LedStripImpl(String ipAdress, int port) {
        super();
        this.ipAdress = ipAdress;
        this.port = port;
    }


    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    public double getBrightless() {
        return brightless;
    }

    public void setBrightless(double brightless) {
        this.brightless = brightless;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
