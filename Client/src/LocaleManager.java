import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {

    private static final ResourceBundle bundleRu = ResourceBundle.getBundle("resources.locale", new Locale("ru", "RU"));
    private static final ResourceBundle bundleNo = ResourceBundle.getBundle("resources.locale", new Locale("no", "NO"));
    private static final ResourceBundle bundleHr = ResourceBundle.getBundle("resources.locale", new Locale("hr", "HR"));
    private static final ResourceBundle bundleEn = ResourceBundle.getBundle("resources.locale", new Locale("en", "US"));
    private static int languageId;

    public static ResourceBundle getBundleRu() {
        return bundleRu;
    }

    public static ResourceBundle getBundle() {
        switch (languageId) {
            case 0:
                return bundleRu;
            case 1:
                return bundleNo;
            case 2:
                return bundleHr;
            case 3:
                return bundleEn;
        }
        return bundleRu;
    }

    public static void setLanguageId(int languageId) {
        LocaleManager.languageId = languageId;
    }

    public static int getLanguageId() {
        return languageId;
    }

}
