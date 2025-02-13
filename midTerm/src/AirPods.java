public class AirPods extends AppleProducts{
    private boolean noiseCancellation;
    private String chipType, batteryLife;
    private double height, width, depth, weight;
    private String connectionType;

    public AirPods(double price, String description, String model, boolean noiseCancellation, String chipType, String batteryLife, double height,
                   double width, double depth, double weight, String connectionType) {
        super(price, description, model);
        this.noiseCancellation = noiseCancellation;
        this.chipType = chipType;
        this.batteryLife = batteryLife;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.connectionType = connectionType;
    }

    @Override
    public String displaySpecs() {
        return "Specs{" +
                "noiseCancellation=" + noiseCancellation +
                ", chipType='" + chipType + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", height=" + height +
                " in, width=" + width +
                " in, depth=" + depth +
                " in, weight=" + weight +
                " ounces, connectionType='" + connectionType + '\'' +
                '}';
    }
}
//end airpods class