public class AppleWatch extends AppleProducts{
    private double displaySize;
    private int maxNits;
    private String chipType;
    private boolean bloodOxygen, heartRate, cellular;
    private int waterResistanceMeters;
    private String batteryLife, connectionType;
    private int capacity;
    private double height, width, depth, weight;

    public AppleWatch(double price, String description, String model, double displaySize, int maxNits, String chipType, boolean bloodOxygen,
                      boolean heartRate, boolean cellular, int waterResistanceMeters, String batteryLife, String connectionType, int capacity, double height,
                      double width, double depth, double weight) {
        super(price, description, model);
        this.displaySize = displaySize;
        this.maxNits = maxNits;
        this.chipType = chipType;
        this.bloodOxygen = bloodOxygen;
        this.heartRate = heartRate;
        this.cellular = cellular;
        this.waterResistanceMeters = waterResistanceMeters;
        this.batteryLife = batteryLife;
        this.connectionType = connectionType;
        this.capacity = capacity;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public String displaySpecs() {
        return "Specs{" +
                "displaySize=" + displaySize +
                " mm, maxNits=" + maxNits +
                ", chipType='" + chipType + '\'' +
                ", bloodOxygen=" + bloodOxygen +
                ", heartRate=" + heartRate +
                ", cellular=" + cellular +
                ", waterResistanceMeters=" + waterResistanceMeters +
                "m , batteryLife='" + batteryLife + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", capacity=" + capacity +
                ", height=" + height +
                " mm, width=" + width +
                " mm, depth=" + depth +
                " mm, weight=" + weight +
                "g}";
    }
}
//end apple watch class