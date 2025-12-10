public class Display {
    private double sizeInches;
    private String resolution;
    private boolean isOn;
    
    public Display(double sizeInches, String resolution) {
        this.sizeInches = sizeInches;
        this.resolution = resolution;
        this.isOn = false;
    }
    
    public String turnOn() {
        isOn = true;
        return "Display turned on. " + sizeInches + "-inch, " + resolution;
    }
    
    public String turnOff() {
        isOn = false;
        return "Display turned off.";
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public double getSizeInches() {
        return sizeInches;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    @Override
    public String toString() {
        return "Display: " + sizeInches + " inches, " + resolution;
    }
}