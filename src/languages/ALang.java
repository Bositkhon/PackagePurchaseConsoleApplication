package languages;

public abstract class ALang {

    public abstract String get(String key);

    public abstract void showMinutePackages();

    public abstract void showCategories();

    public abstract void showInternetPackages();

    public abstract void showSMSPackages();

    public abstract void showPurchaseVerificationText();

    public abstract void showRetryText();

    public abstract void showPurchaseInfo(double cost);

    public abstract void showInvalidInputText();

}
