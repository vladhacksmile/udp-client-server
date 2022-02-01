import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс, предзначенный для ввода и проверки корректности ввода значений
 */

public class ConsoleEvent {

    /**
     * Контекстное меню для обновление поля, которое задается пользователем
     * @return корректное значение поля, которое пользователь хочет изменить
     */
    public static String update() {
        String name;
        GUIManager.setConsoleMode(false);
        while(true) {
            GUIManager.print(LocaleManager.getBundle().getString("message_enter_name_field_to_change"));
            name = (GUIManager.nextLine()).toLowerCase();
            if (name.equals("name") || name.equals("coordinates") || name.equals("annualturnover") || name.equals("type") || name.equals("address") || name.equals("exit")) {
                GUIManager.setConsoleMode(true);
                return name;
            } else if (name.equals("help")) {
                GUIManager.println(LocaleManager.getBundle().getString("message_help_fields"));
            } else {
                GUIManager.println(LocaleManager.getBundle().getString("message_name_field_incorrect_error"));
            }
        }
    }

    /**
     * Контекстное меню для обновление поля, которое задается пользователем
     * @return корректное значение поля, которое пользователь хочет изменить
     */
    public static String update(BufferedReader bufferedReader) {
        String name = "";
        Boolean scanned = false;
        GUIManager.setConsoleMode(false);
        while(true) {
            GUIManager.print(LocaleManager.getBundle().getString("message_enter_name_field_to_change"));
            if(scanned) {
                name = (GUIManager.nextLine()).toLowerCase();
            } else {
                try {
                    name = bufferedReader.readLine();
                } catch (IOException e) {
                    GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
                } catch (NullPointerException e) {
                    GUIManager.println(LocaleManager.getBundle().getString("message_name_field_null_error"));
                }
                GUIManager.print(name + "\n");
                scanned = true;
            }
            try {
                if (name.equals("name") || name.equals("coordinates") || name.equals("annualturnover") || name.equals("type") || name.equals("address") || name.equals("exit")) {
                    GUIManager.setConsoleMode(true);
                    return name;
                } else if (name.equals("help")) {
                    GUIManager.println(LocaleManager.getBundle().getString("message_help_fields"));
                } else {
                    GUIManager.println(LocaleManager.getBundle().getString("message_name_field_incorrect_error"));
                }
            } catch (NullPointerException e){
                GUIManager.println("message_name_field_null_error");
            }
        }
    }

    /**
     * Контекстное меню для получение имени организации, которое задается пользователем
     * @return корректное значение имени организации, заданное пользователем
     */
    public static String getName() {
        String name;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_name"));
                name = GUIManager.nextLine();
                if(name.isEmpty()) {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_incorrect_value_error"));
                } else {
                    GUIManager.setConsoleMode(true);
                    return name;
                }
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            }
        }
    }

    /**
     * Контекстное меню для получение имени организации, которое задается пользователем
     * @param bufferedReader сканнер
     * @return корректное значение имени организации, заданное пользователем
     */
    public static String getName(BufferedReader bufferedReader) {
        String name;
        Boolean scanned = false;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_name"));
                if(scanned) {
                    name = GUIManager.nextLine();
                } else {
                    name = bufferedReader.readLine();
                    GUIManager.print(name + "\n");
                    scanned = true;
                }
                if(name.isEmpty()) {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_incorrect_value_error"));
                } else {
                    GUIManager.setConsoleMode(true);
                    return name;
                }
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            } catch (IOException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
            } catch (NullPointerException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_name_not_null_error"));
            }
        }
    }

    /**
     * Контекстное меню для получение координат организации, которое задается пользователем
     * @return корректное значение объекта класса Coordinates с заданными пользователем координатами организации
     */
    public static Coordinates getCoordinates() {
        float x, y;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_cord_x"));
                x = Float.parseFloat(GUIManager.nextLine());
                if(x > 662) {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_cord_x_incorrect_error"));
                } else {
                    while (true) {
                        try {
                            GUIManager.print(LocaleManager.getBundle().getString("enter_cord_y"));
                            y = Float.parseFloat(GUIManager.nextLine());
                            GUIManager.setConsoleMode(true);
                            return new Coordinates(x, y);
                        } catch (InputMismatchException | NumberFormatException e) {
                            GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
                        }
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            }
        }
    }

    /**
     * Контекстное меню для получение координат организации, которое задается пользователем
     * @param bufferedReader сканнер
     * @return корректное значение объекта класса Coordinates с заданными пользователем координатами организации
     */
    public static Coordinates getCoordinates(BufferedReader bufferedReader) {
        float x, y;
        Boolean scannedX = false, scannedY = false;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_cord_x"));
                if(scannedX) {
                    x = Float.parseFloat(GUIManager.nextLine());
                } else {
                    x = Float.parseFloat(bufferedReader.readLine());
                    GUIManager.print(x + "\n");
                    scannedX = true;
                }
                if(x > 662){
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_cord_x_incorrect_error"));
                } else {
                    while (true) {
                        try {
                            GUIManager.print(LocaleManager.getBundle().getString("enter_cord_x"));
                            if(scannedY) {
                                y = Float.parseFloat(GUIManager.nextLine());
                            } else {
                                y = Float.parseFloat(bufferedReader.readLine());
                                GUIManager.print(y + "\n");
                                scannedY = true;
                            }
                            GUIManager.setConsoleMode(true);
                            return new Coordinates(x, y);
                        } catch (InputMismatchException | NumberFormatException e) {
                            GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
                        }
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            } catch (IOException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
            }
        }
    }

    /**
     * Контекстное меню для получение годового оборота организации, которое задается пользователем
     * @return корректное значение годового оборота, заданное пользователем
     */
    public static int getAnnualTurnover() {
        int annualTurnover;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_annual_turnover"));
                annualTurnover = Integer.parseInt(GUIManager.nextLine());
                if(annualTurnover > 0) {
                    GUIManager.setConsoleMode(true);
                    return annualTurnover;
                } else {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_annual_turnover_incorrect_error"));
                }
            } catch (InputMismatchException | NumberFormatException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            }
        }
    }

    /**
     * Контекстное меню для получение годового оборота организации, которое задается пользователем
     * @param bufferedReader сканнер
     * @return корректное значение годового оборота, заданное пользователем
     */
    public static int getAnnualTurnover(BufferedReader bufferedReader) {
        int annualTurnover = 0;
        Boolean scanned = false;
        GUIManager.setConsoleMode(false);
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_annual_turnover"));
                if(scanned) {
                    annualTurnover = Integer.parseInt(GUIManager.nextLine());
                } else {
                    try {
                        annualTurnover = Integer.parseInt(bufferedReader.readLine());
                    } catch(InputMismatchException | NumberFormatException e) {
                        GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
                    }
                    GUIManager.print(annualTurnover + "\n");
                    scanned = true;
                }
                if(annualTurnover > 0) {
                    GUIManager.setConsoleMode(true);
                    return annualTurnover;
                } else {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_annual_turnover_incorrect_error"));
                }
            } catch (InputMismatchException | NumberFormatException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_incorrect_value_error"));
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            } catch (IOException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
            } catch (NullPointerException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_annual_turnover_not_null_error"));
            }
        }
    }

    /**
     * Контекстное меню для типа организации, которое задается пользователем
     * @return корректное значение объекта класса OrganizationType
     */
    public static OrganizationType getType() {
        OrganizationType type;
        String typeName;
        GUIManager.setConsoleMode(false);
        GUIManager.println(LocaleManager.getBundle().getString("available_types_of_organizations") + Stream.of(OrganizationType.values()).
                map(OrganizationType::name).
                collect(Collectors.joining(", ")));
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_type"));
                typeName = GUIManager.nextLine();
                type = Utils.StrToType(typeName);
                if (!typeName.isEmpty() && type == null) {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_type_incorrect_error"));
                } else {
                    GUIManager.setConsoleMode(true);
                    return type;
                }
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            }
        }
    }

    /**
     * Контекстное меню для типа организации, которое задается пользователем
     * @param bufferedReader сканнер
     * @return корректное значение объекта класса OrganizationType
     */
    public static OrganizationType getType(BufferedReader bufferedReader) {
        OrganizationType type;
        String typeName;
        Boolean scanned = false;
        GUIManager.setConsoleMode(false);
        GUIManager.println(LocaleManager.getBundle().getString("available_types_of_organizations") + Stream.of(OrganizationType.values()).
                map(OrganizationType::name).
                collect(Collectors.joining(", ")));
        while(true) {
            try {
                GUIManager.print(LocaleManager.getBundle().getString("enter_type"));
                if(scanned) {
                    typeName = GUIManager.nextLine();
                } else {
                    typeName = bufferedReader.readLine();
                    GUIManager.print(typeName + "\n");
                    scanned = true;
                }
                type = Utils.StrToType(typeName);
                if (!typeName.isEmpty() && type == null) {
                    throw new IncorrectValueException(LocaleManager.getBundle().getString("message_type_incorrect_error"));
                } else {
                    GUIManager.setConsoleMode(true);
                    return type;
                }
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            } catch (IOException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
            } catch (NullPointerException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_type_incorrect_file_error"));
            }
        }
    }

    /**
     * Контекстное меню для получение адреса организации, который задается пользователем
     * @return корректное значение объекта класса Address с заданными пользователем улицей и индексом
     */
    public static Address getAddress() {
        String street, zipcode;
        GUIManager.setConsoleMode(false);
        GUIManager.print(LocaleManager.getBundle().getString("enter_street"));
        street = GUIManager.nextLine();
        if (!street.isEmpty()) {
            GUIManager.print(LocaleManager.getBundle().getString("enter_zipcode"));
            zipcode = GUIManager.nextLine();
            try {
                GUIManager.setConsoleMode(true);
                return new Address(street, zipcode);
            } catch (IncorrectValueException e) {
               GUIManager.println(e.getMessage());
            }
        }
        GUIManager.setConsoleMode(true);
        return null;
    }

    /**
     * Контекстное меню для получение адреса организации, который задается пользователем
     * @param bufferedReader сканнер
     * @return корректное значение объекта класса Address с заданными пользователем улицей и индексом
     */
    public static Address getAddress(BufferedReader bufferedReader) {
        String street = "", zipcode = "";
        Boolean scannedStreet = false, scannedZipcode = false;
        GUIManager.setConsoleMode(false);
        GUIManager.print(LocaleManager.getBundle().getString("enter_street"));
        if(scannedStreet) {
            street = GUIManager.nextLine();
        } else {
            try {
                street = bufferedReader.readLine();
            } catch (IOException e) {
                GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
            }
            GUIManager.print(street + "\n");
            scannedStreet = true;
        }
        if (!street.isEmpty()) {
            GUIManager.print(LocaleManager.getBundle().getString("enter_zipcode"));
            if(scannedZipcode) {
                zipcode = GUIManager.nextLine();
            } else {
                try {
                    zipcode = bufferedReader.readLine();
                } catch (IOException e) {
                    GUIManager.println(LocaleManager.getBundle().getString("message_read_file_error"));
                }
                GUIManager.print(zipcode + "\n");
                scannedZipcode = true;
            }
            try {
                GUIManager.setConsoleMode(true);
                return new Address(street, zipcode);
            } catch (IncorrectValueException e) {
                GUIManager.println(e.getMessage());
            }
        }
        GUIManager.setConsoleMode(true);
        return null;
    }
}