package languages;

import packages.InternetPackages;
import packages.MinutePackages;
import packages.SMSPackages;

public class RussianLang extends ALang {

    private String[] keys = {"MINUTES", "SMS", "MB", "PRICE"};
    private String[] translations = {"МИНУТ", "СМС", "МБ", "СТОИМОСТЬ"};


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
            System.out.println((i+1) + ". " + packages[i] + " " + this.get("MINUTES"));
            System.out.println("    " + this.get("PRICE") + ": $" + prices[i]);
        }
    }

    @Override
    public void showCategories() {
        System.out.println("Пожалуйста выберите категорию");
        System.out.println("1. Минуты");
        System.out.println("2. Интернет-пакеты");
        System.out.println("3. СМС-пакеты");
    }

    public void showPurchaseVerificationText(){
        System.out.println("Вы действительно хотите приобрести этот пакет? (YES / NO)");
    }

    @Override
    public void showRetryText() {
        System.out.println("Хотите пробрести еще пакеты? (YES / NO)");
    }

    @Override
    public void showPurchaseInfo(double cost) {
        System.out.println("Общий счет который вы оплатили составляет $" + cost);
    }

    public void showInvalidInputText() {
        System.out.println("Неправильный ввод. Пожалуйста повторите попытку");
    }

}
