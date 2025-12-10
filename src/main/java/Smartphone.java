public class Smartphone {
    private Battery battery;
    private Display display;
    private Processor processor;
    private String brand;
    private String model;
    
    // Constructor with existing components
    public Smartphone(String brand, String model, Battery battery, Display display, Processor processor) {
        this.brand = brand;
        this.model = model;
        this.battery = battery;
        this.display = display;
        this.processor = processor;
    }
    
    // Constructor with component specifications
    public Smartphone(String brand, String model, int batteryCapacity, double displaySize, 
                     String resolution, String processorModel, double processorSpeed) {
        this.brand = brand;
        this.model = model;
        this.battery = new Battery(batteryCapacity);
        this.display = new Display(displaySize, resolution);
        this.processor = new Processor(processorModel, processorSpeed);
    }
    
    public String powerOn() {
        if (battery.isCharged()) {
            display.turnOn();
            return "Powering on " + brand + " " + model;
        } else {
            return "Cannot power on: Battery depleted";
        }
    }
    
    public String powerOff() {
        display.turnOff();
        return "Powering off " + brand + " " + model;
    }
    
    public void chargeBattery() {
        battery.charge();
    }
    
    public String runApp(String appName) {
        // Check if display is on (phone is powered on)
        java.lang.reflect.Field[] fields = display.getClass().getDeclaredFields();
        boolean displayOn = false;
        try {
            for (java.lang.reflect.Field field : fields) {
                if (field.getName().equals("isOn")) {
                    field.setAccessible(true);
                    displayOn = (boolean) field.get(display);
                    break;
                }
            }
        } catch (Exception e) {
            displayOn = false;
        }
        
        if (displayOn) {
            processor.processTask(appName);
            return appName + " running.";
        } else {
            return "Phone is off. Cannot run " + appName;
        }
    }
    
    // Overloaded upgradeComponent methods
    public void upgradeComponent(Battery newBattery) {
        this.battery = newBattery;
    }
    
    public void upgradeComponent(Display newDisplay) {
        this.display = newDisplay;
    }
    
    public void upgradeComponent(Processor newProcessor) {
        this.processor = newProcessor;
    }
    
    @Override
    public String toString() {
        return brand + " " + model + " Smartphone\n" +
               battery.toString() + "\n" +
               display.toString() + "\n" +
               processor.toString();
    }
}