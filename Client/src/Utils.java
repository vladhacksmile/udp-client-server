import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Вспомогательные утилиты
 */
public class Utils {
    /**
     * Преобразование строки в OrganizationType
     *
     * @param typeName тип организации
     * @return объект перечисления OrganizationType или null
     */
    public static OrganizationType StrToType(String typeName) {
        try {
            return OrganizationType.valueOf(typeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Преобразование OrganizationType в строку
     *
     * @param type тип организации
     * @return объект OrganizationType в строковом представленнии или пустая строка
     */
    public static String TypeToStr(OrganizationType type) {
        try {
            return String.valueOf(type);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Представление строки в виде хэш-суммы
     *
     * @param inputBytes массив байт
     * @param algorithm  алгоритм шифрования
     * @return хэш-строка
     */
    public static String getHash(String inputBytes, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] messageDigest = md.digest(inputBytes.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            System.err.println(LocaleManager.getBundle().getString("message_unknown_encryption_algorithm_error") + algorithm);
        }
        return null;
    }

    public static String getStreet(Address address) {
        if(address != null) return address.getStreet();
        else return "";
    }

    public static String getZipCode(Address address) {
        if(address != null) return address.getZipCode();
        else return "";
    }

    public static String[] formRequest(String command) {
        String[] request = {command};
        return request;
    }

}
