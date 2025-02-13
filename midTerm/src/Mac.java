public class Mac extends AppleProducts{
    private double displaySize;
    private int maxNits;
    private String chipType, connectionType, batteryLife;
    private int capacity,usbPorts, memory;
    private double height, width, depth, weight;
    private String camDescription, camResolution, ultraWideCam, telephoto;
    private boolean portraitFocus, portraitDepth;

    public Mac(double price, String description, String model, double displaySize, int maxNits, String chipType, String connectionType,
               String batteryLife, int capacity, int usbPorts, int memory, double height, double width, double depth, double weight, String camDescription,
               String camResolution, String ultraWideCam, String telephoto, boolean portraitFocus, boolean portraitDepth) {
        super(price, description, model);
        this.displaySize = displaySize;
        this.maxNits = maxNits;
        this.chipType = chipType;
        this.connectionType = connectionType;
        this.batteryLife = batteryLife;
        this.capacity = capacity;
        this.usbPorts = usbPorts;
        this.memory = memory;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.camDescription = camDescription;
        this.camResolution = camResolution;
        this.ultraWideCam = ultraWideCam;
        this.telephoto = telephoto;
        this.portraitFocus = portraitFocus;
        this.portraitDepth = portraitDepth;
    }

    public String displaySpecs() {
        return "Specs{" +
                "displaySize=" + displaySize +
                " in, maxNits=" + maxNits +
                ", chipType='" + chipType + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", batteryLife='" + batteryLife + '\'' +
                ", capacity=" + capacity +
                " GB, usbPorts=" + usbPorts +
                ", memory=" + memory +
                " GB, height=" + height +
                " in, width=" + width +
                " in, depth=" + depth +
                " in, weight=" + weight +
                " pounds, camDescription='" + camDescription + '\'' +
                ", camResolution='" + camResolution + '\'' +
                ", ultraWideCam='" + ultraWideCam + '\'' +
                ", telephoto='" + telephoto + '\'' +
                ", portraitFocus=" + portraitFocus +
                ", portraitDepth=" + portraitDepth +
                '}';
    }
}
//end mac class