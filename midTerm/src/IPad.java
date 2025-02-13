public class IPad extends AppleProducts {

    private double displaySize;
    private String chipType, connectionType, batteryLife;
    private int capacity;//storage
    private double height, width, depth, weight;
    private boolean magicKeyboardSupport;
    private String camDescription, camResolution, ultraWideResolution, telephoto;
    private boolean portraitFocus, portraitDepth;
    private String zoomRange;

    public IPad(double price, String description, String model, double displaySize, String chipType, String connectionType, String batteryLife,
                int capacity, double height, double width, double depth, double weight, boolean magicKeyboardSupport, String camDescription, String camResolution,
                String ultraWideResolution, String telephoto, boolean portraitFocus, boolean portraitDepth, String zoomRange) {
        super(price, description, model);
        this.displaySize = displaySize;
        this.chipType = chipType;
        this.connectionType = connectionType;
        this.batteryLife = batteryLife;
        this.capacity = capacity;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.magicKeyboardSupport = magicKeyboardSupport;
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
                " in, chipType='" + chipType + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", capacity=" + capacity +
                " GB, height=" + height +
                " in, width=" + width +
                " in, depth=" + depth +
                " in, weight=" + weight +
                " pounds, magicKeyboardSupport=" + magicKeyboardSupport +
                ", camDescription='" + camDescription + '\'' +
                ", camResolution='" + camResolution + '\'' +
                ", ultraWideResolution='" + ultraWideResolution + '\'' +
                ", telephoto='" + telephoto + '\'' +
                ", portraitFocus=" + portraitFocus +
                ", portraitDepth=" + portraitDepth +
                ", zoomRange='" + zoomRange + '\'' +
                '}';
    }
}
//end ipad class

