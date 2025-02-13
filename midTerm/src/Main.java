import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char addMore;
        int selectedProduct;
        ArrayList<AppleProducts> myProducts = new ArrayList<>();

        loadInventory(myProducts);

        ArrayList<AppleProducts> appleBasket = new ArrayList<>();
        do {

            System.out.println("""
                    What type of product would you like to look into?
                    1. iPhone
                    2. iPad
                    3. Mac
                    4. Apple Watch
                    5. AirPods
                    6. AirTag""");
            int productChoice = input.nextInt();

            while(productChoice < 1 || productChoice > 6)
            {
                System.out.println("Invalid option please select 1-6");
                productChoice = input.nextInt();
            }

            switch (productChoice) {
                case 1 -> {
                    selectedProduct = menuOptions(myProducts, "iPhone");
                    appleBasket.add(myProducts.get(selectedProduct - 1));
                    System.out.println();
                }
                case 2 -> {
                    selectedProduct = menuOptions(myProducts, "iPad");
                    appleBasket.add(myProducts.get(selectedProduct + 2));
                    System.out.println();
                }
                case 3 -> {
                    selectedProduct = menuOptions(myProducts, "Mac");
                    appleBasket.add(myProducts.get(selectedProduct + 5));
                    System.out.println();
                }
                case 4 -> {
                    selectedProduct = menuOptions(myProducts, "Watch");
                    appleBasket.add(myProducts.get(selectedProduct + 8));
                    System.out.println();
                }
                case 5 -> {
                    selectedProduct = menuOptions(myProducts, "AirPod");
                    appleBasket.add(myProducts.get(selectedProduct + 11));
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("Would you like to purchase an AirTag for $29.99? y/n");
                    char confirmTag = input.next().charAt(0);
                    while (confirmTag != 'y' && confirmTag != 'Y' && confirmTag != 'n' && confirmTag != 'N') {
                        System.out.println("Please enter y or n");
                        confirmTag = input.next().charAt(0);
                    }
                    appleBasket.add(myProducts.get(15));
                }
            }

            System.out.println("Would you like to continue shopping? Y/N");
            addMore = input.next().charAt(0);
            while(addMore != 'y' && addMore != 'Y' && addMore != 'n' && addMore != 'N') {
                System.out.println("Please enter Y or N");
                addMore = input.next().charAt(0);
            }
        }while(addMore == 'y' || addMore == 'Y');

        double totalCost;
        //calculateFreebies(appleBasket, totalCost);
        // chatgpt INFLUENCED, wrote and changed myself based on the method it used
        int diffProducts = countDiffProducts(appleBasket);
        int numAirTags = countAirTags(appleBasket);
        double freeTag = 0;
        if(diffProducts >= 3 || calculateTotal(appleBasket) > 3000.00)
        {
            if (numAirTags == 0) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
                System.out.println("Free AirTag has been added to your basket for either purchasing three items or having a total of $3000 or more!");
            }
            else if (numAirTags > 0)
            {
                freeTag = 29.99;
                System.out.println("One AirTag is now free for purchasing three items!");
            }

        }

        if (diffProducts == 5 && numAirTags == 0) {
            for(int x = 0; x < 3; x++) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
            }
            System.out.println("3 free AirTags have been added to your cart.");
        } else if (diffProducts > 5 && numAirTags > 0) {
            for(int x = 0; x < 3; x++) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
            }
            System.out.println("3 free AirTags have been added to your cart.");
        }



        totalCost = calculateTotal(appleBasket);
        double salesTax = totalCost * .06;
        salesTax = Math.round(salesTax * 100);
        salesTax = salesTax / 100;

        for (AppleProducts oneProduct : appleBasket)
        {
            System.out.println(oneProduct);
            System.out.println(oneProduct.displaySpecs());
            System.out.println("-----------------------------------");
        }

        System.out.println("Cost: " + totalCost);
        System.out.println("Sales Tax: " + salesTax);
        System.out.println("Discount: -" + freeTag);
        double finalPrice = totalCost + salesTax - freeTag;
        finalPrice = Math.round(finalPrice * 100);
        finalPrice = finalPrice/100;
        System.out.println("Total: " + finalPrice);

    }
    //end main
/*
    static void calculateFreebies(ArrayList<AppleProducts> appleBasket, double totalPrice)
    {
        // chatgpt INFLUENCED, wrote and changed myself based on the method it used
        int diffProducts = countDiffProducts(appleBasket);
        int numAirTags = countAirTags(appleBasket);
        totalPrice = calculateTotal(appleBasket);
        if(diffProducts >= 3 || calculateTotal(appleBasket) > 3000.00)
        {
            if (numAirTags == 0) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
                totalPrice-= freeAirTag.getPrice();
                System.out.println("Free AirTag has been added to your basket for either purchasing three items or having a total of $3000 or more!");
            }
            else if (numAirTags > 0)
            {
                totalPrice -= 29.99;
                System.out.println("One AirTag is now free for purchasing three items!");
            }

        }

        if (diffProducts == 5 && numAirTags == 0) {
            for(int x = 0; x < 3; x++) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
            }
            System.out.println("3 free AirTags have been added to your cart.");
        } else if (diffProducts > 5 && numAirTags > 0) {
            for(int x = 0; x < 3; x++) {
                AppleProducts freeAirTag = new AirTag();
                freeAirTag.setPrice(0.00);
                appleBasket.add(freeAirTag);
            }
            System.out.println("3 free AirTags have been added to your cart.");
        }
    }

 */

    static int menuOptions(ArrayList<AppleProducts> myProducts, String product)
    {
        Scanner input = new Scanner(System.in);
        int productNum = 1;

        for (AppleProducts oneProduct : myProducts)
        {

            if(oneProduct.getModel().contains(product)) {
                System.out.print(productNum + ". ");
                System.out.println(oneProduct);
                productNum++;
            }
        }
        System.out.println("Which " + product + " would you like to purchase?");
        int selectedProduct = input.nextInt();
        while(selectedProduct < 1 || selectedProduct > 3)
        {
            System.out.println("Invalid option please select 1-3");
            selectedProduct = input.nextInt();
        }
        return selectedProduct;
    }

    static int countDiffProducts(ArrayList<AppleProducts> appleBasket)
    {
        ArrayList<String> diffItems = new ArrayList<>();
        for (AppleProducts oneProduct : appleBasket)
        {
            if(!diffItems.contains(oneProduct.getModel()))
            {
                diffItems.add(oneProduct.getModel());
            }
        }
        return diffItems.size();
    }

    static int countAirTags(ArrayList<AppleProducts> appleBasket)
    {
        int airTags = 0;
        for (AppleProducts oneProduct : appleBasket) {
            if (oneProduct.getModel().equals("AirTag")) {
                airTags++;
            }
        }
        return airTags;
    }

    static double calculateTotal(ArrayList<AppleProducts> appleBasket)
    {
        double totalCost = 0;
        for (AppleProducts oneProduct : appleBasket)
        {
            totalCost += oneProduct.getPrice();
        }
        //got from stack overflow to round to two places

        totalCost = Math.round(totalCost * 100);
        totalCost = totalCost/100;
        return  totalCost;
    }

    static void loadInventory(ArrayList<AppleProducts> myProducts)
    {
        myProducts.add(new IPhone(429.99,"The iPhone SE is a great up to date and budget iPhone model that we " +
                "all know and love with the 6 through 8.","iPhone SE 3rd Gen", 4.7, false, "A15 Bionic", "5G",
                "15 hours", 64, 5.45, 2.65, 0.29, 5.09, "Single main camera", "12MP",
                "No ultra-wide camera", "No telephoto camera", false, true, "1x"));

        myProducts.add(new IPhone(599.99, "The iPhone 13 is a great mid range option with the full screen display", "iPhone 13",
                6.1, false, "A15 Bionic", "Superfast 5G", "19 hours", 128, 5.78, 2.82,
                0.30, 6.14, "Dual camera", "12MP", "12MP", "No telephoto camera", true,
                true, ".5x, 1x"));

        myProducts.add(new IPhone(1199.99, "The iPhone 15 Pro Max is the best of the best with top specs in all areas", "iPhone 15 Pro Max",
                6.7, true, "A17 Pro", "Superfast 5G", "29 hours", 256, 6.29, 3.02,
                0.32, 7.81, "Pro camera", "48MP", "12MP", "12MP", true,
                true, ".5x, 1x, 2x, 5x"));

        myProducts.add(new IPad(499.99, "The iPad mini is the most portable of the lineup with the smallest size while still being a " +
                "great size and quality for entertainment use.",
                "iPad mini (6th generation)", 8.3, "A15", "WiFi 6", "10 hours", 64,
                7.69, 5.3, 0.25, .65, false, "Single camera", "12MP", "No ultrawide camera",
                "No telephoto camera", false, false, "digital zoom up to 5x"));


        myProducts.add(new IPad(599.99, "The iPad air is the best mid range option there is boasting great performance with less features for a respectable mid range price",
                "iPad Air (5th generation)", 10.9, "M1", "WiFi 6", "10 hours", 64,
                9.74, 7.02, 0.24, 1.02, true, "Single camera", "12MP", "No ultrawide camera",
                "No telephoto camera", false, false, "digital zoom up to 5x"));


        myProducts.add(new IPad(1099.99, "The iPad pro is the best iPad model you can get with the most features and compatibility",
                "iPad Pro 12.9-in (6th generation)", 12.9, "M2", "WiFi 6e", "10 hours", 128,
                11.04, 8.46, 0.25, 1.5, true, "Dual camera", "12MP", "10MP",
                "No telephoto camera", false, false, "2x optical zoom out/digital zoom up to 5x"));

        myProducts.add(new Mac(999.99, "The most affordable Mac laptop to get things done on the go", "Macbook Air", 13,
                400, "M1", "WiFi 6", "18 hours", 256, 2, 8, 0.63, 11.97, 8.36,
                2.8, "FaceTime HD camera", "720p", "No ultra-wide camera", "No telephoto camera", false,
                false));


        myProducts.add(new Mac(1499.99, "A stunning all-in-one desktop for creativity and productivity", "iMac", 24,
                1000, "M3", "WiFi 6e", "-", 256, 4, 8, 18.1, 21.5, 5.8,
                9.87, "FaceTime HD camera", "1080p", "No ultra-wide camera",
                "No telephoto camera", false, false));

        myProducts.add(new Mac(1999.99, "The most advanced Mac laptops for demanding workflows", "Macbook Pro", 14.2,
                1000, "M3 Pro", "WiFi 6e", "18 hours", 512, 3, 18, 0.61, 12.31,
                8.71, 3.5, "FaceTime HD camera", "1080p", "No ultra-wide camera",
                "No telephoto camera", false, false));

        myProducts.add(new AppleWatch(249.99, "All the essentials. Light on price.", "Apple Watch SE", 40, 1000,
                "S8 SiP", false, true, false, 50, "18 hours","GPS/Bluetooth",
                32, 40, 34,10.7, 26.4));

        myProducts.add(new AppleWatch(399.99, "Powerful sensors, advanced health features", "Apple Watch Series 9", 45,
                2000, "S9 SiP", true, true, false, 50, "18 hours/36 hours low power",
                "GPS/Bluetooth", 64, 45, 38,10.7, 31.9));

        myProducts.add(new AppleWatch(799.99, "The most rugged and capable.", "Apple Watch Ultra 2", 49, 3000,
                "S9 SiP", true, true, true, 100, "36 hours/72 hours low power",
                "LTE", 64, 49, 44,14.4, 61.4));

        myProducts.add(new AirPods(129.99, "The original AirPods that everyone knows and loves", "AirPods (2nd generation)",
                false, "H1", "5 hours listening/3 hours talk", 2.11, 1.74, 0.84, 1.35,
                "Bluetooth 5.0"));

        myProducts.add(new AirPods(249.99, "The best in ear bud model of the with the most features", "AirPods Pro (2nd generation)",
                true, "H2/U1", "6 hours listening/4.5 hours talk", 1.78, 2.39, 0.85, 1.79,
                "Bluetooth 5.3"));

        myProducts.add(new AirPods(549.99, "The only over the ear headphones apple provides with the best audio quality on the market",
                "AirPods Max", true, "H1", "20 hours", 7.37, 6.64,
                3.28, 13.6, "Bluetooth 5.0"));

        myProducts.add(new AirTag());
    }
}