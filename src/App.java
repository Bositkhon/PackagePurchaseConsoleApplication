import languages.ALang;
import languages.EnglishLang;
import languages.RussianLang;
import packages.InternetPackages;
import packages.MinutePackages;
import packages.SMSPackages;

import java.util.Scanner;

public class App {

    private final int LANG_EN = 1;
    private final int LANG_RU = 2;

    private final int CATEGORY_MINUTES = 1;
    private final int CATEGORY_INTERNET = 2;
    private final int CATEGORY_SMS = 3;


    private ALang lang;

    private int currentCategory;

    private double totalCost = 0;

    public void run() {
        Scanner sc = new Scanner(System.in);
        String verification = null;
        boolean retry = true;
        int selection;

        while(retry){
            this.showLanguagesList();
            selection = sc.nextInt();
            switch (selection){
                case LANG_RU:{
                    this.lang = new RussianLang();
                    retry = false;
                    break;
                }
                case LANG_EN:{
                    this.lang = new EnglishLang();
                    retry = false;
                    break;
                }
                default:{
                    System.out.println("Invalid input. Please try again");
                    retry = true;
                    break;
                }
            }
        }


        retry = true;
        while(retry){
            this.lang.showCategories();
            while (retry){
                selection = sc.nextInt();
                switch (selection){
                    case CATEGORY_INTERNET:{
                        this.lang.showInternetPackages();
                        this.currentCategory = CATEGORY_INTERNET;
                        retry = false;
                        break;
                    }
                    case CATEGORY_MINUTES:{
                        this.lang.showMinutePackages();
                        this.currentCategory = CATEGORY_MINUTES;
                        retry = false;
                        break;
                    }
                    case CATEGORY_SMS:{
                        this.lang.showSMSPackages();
                        this.currentCategory = CATEGORY_SMS;
                        retry = false;
                        break;
                    }
                    default:{
                        this.lang.showInvalidInputText();
                        retry = true;
                        break;
                    }
                }
            }

            retry = true;
            while(retry){
                selection = sc.nextInt();
                switch (this.currentCategory){
                    case CATEGORY_INTERNET:{
                        if(selection >= 1 && selection <= InternetPackages.getPackages().length){
                            this.lang.showPurchaseVerificationText();
                            verification = sc.next();
                            if(verification.equals("YES")){
                                this.addToTotalCost(InternetPackages.getPrice(selection));
                                retry = false;
                            }else if(verification.equals("NO")){
                                retry = false;
                            }else{
                                this.lang.showInvalidInputText();
                                retry = true;
                            }
                        }else{
                            this.lang.showInvalidInputText();
                            retry = true;
                        }
                        break;
                    }
                    case CATEGORY_MINUTES:{
                        if(selection >= 1  && selection <= MinutePackages.getPackages().length){
                            this.lang.showPurchaseVerificationText();
                            verification = sc.next();
                            if(verification.equals("YES")){
                                this.addToTotalCost(MinutePackages.getPrice(selection));
                                retry = false;
                            }else if(verification.equals("NO")){
                                retry = false;
                            }else{
                                this.lang.showInvalidInputText();
                                retry = true;
                            }
                        }else{
                            this.lang.showInvalidInputText();
                            retry = true;
                        }
                        break;
                    }
                    case CATEGORY_SMS:{
                        if(selection >= 1 && selection <= SMSPackages.getPackages().length){
                            this.lang.showPurchaseVerificationText();
                            verification = sc.next();
                            if(verification.equals("YES")){
                                this.addToTotalCost(SMSPackages.getPrice(selection));
                                retry = false;
                            }else if(verification.equals("NO")){
                                retry = false;
                            }else{
                                this.lang.showInvalidInputText();
                                retry = true;
                            }
                        }else{
                            this.lang.showInvalidInputText();
                            retry = true;
                        }
                        break;
                    }
                }
            }


            this.lang.showRetryText();
            verification = sc.next();
            if(verification.equals("YES")){
                retry = true;
            }else if(verification.equals("NO")){
                retry = false;
            }else{
                this.lang.showInvalidInputText();
                retry = true;
            }
        }


        this.lang.showPurchaseInfo(this.getTotalCost());

    }

    private void showLanguagesList(){
        System.out.println("Пожалуйста выберите язык / Please select the language");
        System.out.println("1. Английский / English");
        System.out.println("2. Русский / Russian");
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addToTotalCost(double price){
        this.totalCost += price;
    }

}
