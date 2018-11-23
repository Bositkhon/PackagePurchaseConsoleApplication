package packages;

public class SMSPackages {

    private static String[] packages = {"50", "100", "150", "300", "500", "1000", "2000"};

    private static double[] prices = {1, 2, 3, 4, 5, 6, 7};

    public static double[] getPrices() {
        return prices;
    }

    public static String[] getPackages() {
        return packages;
    }

    public static String getPackage(int id){
        return packages[id - 1];
    }

    public static double getPrice(int id){
        return prices[id - 1];
    }

//    public static g

}
