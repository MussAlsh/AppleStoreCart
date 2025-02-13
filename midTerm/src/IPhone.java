public class IPhone extends AppleProducts{

    private double displaySize;
    private boolean dynamicIsland;
    private String chipType, connectionType, batteryLife;
    private int capacity;//storage
    private double height, width, depth, weight;
    private String camDescription, camResolution, ultraWideResolution, telephoto;
    private boolean portraitFocus, portraitDepth;
    private String zoomRange;

    public IPhone(double price, String description, String model, double displaySize, boolean dynamicIsland, String chipType, String connectionType,
                  String batteryLife, int capacity, double height, double width, double depth, double weight, String camDescription, String camResolution,
                  String ultraWideResolution, String telephoto, boolean portraitFocus, boolean portraitDepth, String zoomRange) {
        super(price, description, model);
        this.displaySize = displaySize;
        this.dynamicIsland = dynamicIsland;
        this.chipType = chipType;
        this.connectionType = connectionType;
        this.batteryLife = batteryLife;
        this.capacity = capacity;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.camDescription = camDescription;
        this.camResolution = camResolution;
        this.ultraWideResolution = ultraWideResolution;
        this.telephoto = telephoto;
        this.portraitFocus = portraitFocus;
        this.portraitDepth = portraitDepth;
        this.zoomRange = zoomRange;
    }

    @Override
    public String displaySpecs() {
        return "Specs{" +
                "displaySize=" + displaySize +
                " in, dynamicIsland=" + dynamicIsland +
                ", chipType='" + chipType + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", capacity=" + capacity +
                " GB, height=" + height +
                " in, width=" + width +
                " in, depth=" + depth +
                " in, weight=" + weight +
                " ounces, camDescription='" + camDescription + '\'' +
                ", camResolution='" + camResolution + '\'' +
                ", ultraWideResolution='" + ultraWideResolution + '\'' +
                ", telephoto='" + telephoto + '\'' +
                ", portraitFocus=" + portraitFocus +
                ", portraitDepth=" + portraitDepth +
                ", zoomRange='" + zoomRange + '\'' +
                '}';
    }
}
//end iphone class
