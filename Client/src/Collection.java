import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Класс для работы с коллекцией PriorityQueue "Очередь с приоритетом"
 */

public class Collection {
    private static SimpleDateFormat formatEn = new SimpleDateFormat("MMMM dd yyyy HH:mm:ss", new Locale("en"));
    private static SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    /**
     * Контекстное меню для добавления нового элемента в коллекцию (с заполнением полей) и вывода информации о новом элементе
     */
    public Organization add() {
        GUIManager.println(LocaleManager.getBundle().getString("message_add_element"));
        try {
            return new Organization(ConsoleEvent.getName(), ConsoleEvent.getCoordinates(), ConsoleEvent.getAnnualTurnover(), ConsoleEvent.getType(), ConsoleEvent.getAddress());
        } catch (IncorrectValueException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Контекстное меню для добавления нового элемента в коллекцию (с заполнением полей) и вывода информации о новом элементе
     * @param bufferedReader сканнер
     */
    public Organization add(BufferedReader bufferedReader) {
        GUIManager.println(LocaleManager.getBundle().getString("message_add_element"));
        try {
            return new Organization(ConsoleEvent.getName(bufferedReader), ConsoleEvent.getCoordinates(bufferedReader), ConsoleEvent.getAnnualTurnover(bufferedReader), ConsoleEvent.getType(bufferedReader), ConsoleEvent.getAddress(bufferedReader));
        } catch (IncorrectValueException e) {
            GUIManager.println(e.getMessage());
        } catch(NullPointerException e) {
            GUIManager.println(LocaleManager.getBundle().getString("message_add_element_incorrect_script_error"));
        }
        return null;
    }

    public static SimpleDateFormat getFormat() {
        if(LocaleManager.getLanguageId() == 3) {return formatEn; } else return format;
    }
}