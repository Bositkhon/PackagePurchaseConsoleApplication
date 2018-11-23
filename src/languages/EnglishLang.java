package languages;

import packages.InternetPackages;
import packages.MinutePackages;
import packages.SMSPackages;

public class EnglishLang extends ALang {

    private String[] keys = {"MINUTES", "SMS", "MB", "PRICE"};
    private String[] translations = {"MINUTES", "SMS", "MB", "PRICE"};

    @Override
    public String get(String key) {
        String value = null;
        for(int i = 0; i < this.keys.length; i++){
            if(key.equals(this.keys[i])){
                value = this.translations[i];
            }
        }

        return value;
    }

    public void showMinutePackages(){
        String[] packages = MinutePackages.getPackages();
        double[] prices = MinutePackages.getPrices();

        for (int i = 0; i < packages.length; i++){
            System.out.println((i+1) + ". " + packages[i] + " " + this.get("MINUTES"));
            System.out.println("    " + this.get("PRICE") + ": $" + prices[i]);
        }
    }

    @Override
    public void showInternetPackages() {
        String[] packages = InternetPackages.getPackages();
        double[] prices = InternetPackages.getPrices();

        for (int i = 0; i < packages.length; i++){
            System.out.println((i+1) + ". " + packages[i] + " " + this.get("MB"));
            System.out.println("    " + this.get("PRICE") + ": $" + prices[i]);
        }
    }

    @Override
    public void showSMSPackages() {
        String[] packages = SMSPackages.getPackages();
        double[] prices = SMSPackages.getPrices();

        for (int i = 0; i < packages.length; i++){
            System.out.println((i+1) + ". " + packages[i] + " " + this.get("SMS"));
            System.out.println("    " + this.get("PRICE") + ": $" + prices[i]);
        }
    }

    @Override
    public void showCategories() {
        System.out.println("Please select a category");
        System.out.println("1. Minutes");
        System.out.println("2. Internet packages");
        System.out.println("3. SMS packages");
    }

    public void showPurchaseVerificationText(){
        System.out.println("Do you really want to buy this package? (YES / NO)");
    }

    @Override
    public void showRetryText() {
        System.out.println("Do you want to purchase more packages? (YES / NO)");
    }

    @Override
    public void showPurchaseInfo(double cost) {
        System.out.println("The amount of money you have spent $" + cost);
    }

    @Override
    public void showInvalidInputText() {
        System.out.println("Invalid input. Please try again");
    }
}
