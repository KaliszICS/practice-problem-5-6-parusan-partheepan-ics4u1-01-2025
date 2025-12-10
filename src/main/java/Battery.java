public class Battery {
    private int capacityMAh;
    private boolean isCharged;
    
    public Battery(int capacityMAh) {
        this.capacityMAh = capacityMAh;
        this.isCharged = false;
    }
    
    public void charge() {
        isCharged = true;
    }
    
    public boolean isCharged() {
        return isCharged;
    }
    
    public int getCapacityMAh() {
        return capacityMAh;
    }
    
    @Override
    public String toString() {
        return "Battery: " + capacityMAh + " mAh, Charged: " + isCharged;
    }
}