public class AppleProducts {
    private  double price;
    private String description;
    private String model;

    public AppleProducts(double price, String description, String model) {
        this.price = price;
        this.description = description;
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model + " $" + price + "\n" + description;
    }

    public String displaySpecs()
    {
        return " ";
    }
}
//end appleProducts class
