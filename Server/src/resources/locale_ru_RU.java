package resources;

import java.util.ListResourceBundle;

public class locale_ru_RU extends ListResourceBundle {

    private static final Object[][] contents = {

            /* LANGUAGES */
            {"lang_ru", "Русский язык"},
            {"lang_no", "Norske"},
            {"lang_hr", "Hrvatski"},
            {"lang_en", "English language"},
            /* LANGUAGES */

            /* ANSWER HANDLER */
            {"message_user_not_authorized_error", "Пользователь не авторизован! Выполнение команд запрещено!"},
            {"message_help", "help - вывести справку по доступным командам\n" +
                    "info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                    "show - вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                    "add {element} - добавить новый элемент в коллекцию\n" +
                    "update id {element} - обновить значение элемента коллекции, id которого равен заданному\n" +
                    "remove_by_id id - удалить элемент из коллекции по его id\n" +
                    "clear - очистить коллекцию\n" +
                    "execute_script file_name - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                    "exit - завершить программу (без сохранения в файл)\n" +
                    "head - вывести первый элемент коллекции\n" +
                    "remove_greater {element} - удалить из коллекции все элементы, превышающие заданный\n" +
                    "remove_lower {element} - удалить из коллекции все элементы, меньшие, чем заданный\n" +
                    "remove_any_by_type type - удалить из коллекции один элемент, значение поля type которого эквивалентно заданному\n" +
                    "sum_of_annual_turnover - вывести сумму значений поля annualTurnover для всех элементов коллекции\n" +
                    "auth {login} - авторизация\n" +
                    "reg {login} - регистрация\n" +
                    "logout - выход из системы\n" +
                    "print_field_ascending_annual_turnover - вывести значения поля annualTurnover всех элементов в порядке возрастания"},
            {"message_added_successful", "Элемент добавлен в коллекцию!"},
            {"message_server_stopped", "Сервер остановлен!"},
            /* ANSWER HANDLER */

            /* ELEMENT */
            {"add_element", "Добавление элемента"},
            {"update_element", "Изменение элемента"},
            {"enter_name", "Введите имя: "},
            {"enter_cord_x", "Введите координату X: "},
            {"enter_cord_y", "Введите координату Y: "},
            {"enter_annual_turnover", "Введите годовой оборот: "},
            {"enter_type", "Введите тип организации: "},
            {"select_type", "Выберите тип организации: "},
            {"enter_street", "Введите улицу: "},
            {"enter_zipcode", "Введите индекс: "},
            /* ELEMENT */

            /* CONSOLE EVENT MESSAGES */
            {"message_enter_name_field_to_change", "Укажите имя поля, которое вы хотите изменить: "},
            {"message_help_fields", "Помощь по полям:\nname - изменить имя\ncoordinates - изменить координаты\nannualTurnover - изменить годовой оборот\ntype - изменить тип\naddress - изменить адрес\nДля выхода введите exit"},
            {"message_read_file_error", "Произошла ошибка при чтении файла!"},
            {"message_name_field_null_error", "Имя поля не должно быть null!"},
            {"message_name_field_incorrect_error", "Неверное имя поля! Вызовите help для помощи!"},
            {"message_incorrect_value_error", "Введено некорректное значение, повторите попытку!"},
            {"message_name_not_null_error", "Имя не должно быть null!"},
            {"message_cord_x_incorrect_error", "Значение X не должно превышать 662!"},
            {"message_annual_turnover_incorrect_error", "Годовой оборот должен быть натуральным числом!"},
            {"message_annual_turnover_not_null_error", "Годовой оборот не может быть null!"},
            {"available_types_of_organizations", "Доступные типы организации: "},
            {"message_type_incorrect_error", "Проверьте значение типа организации! Если такое поле null - оставьте строку пустой!"},
            {"message_type_incorrect_file_error", "Несмотря на то, что тип организации может быть null, поле для него должно присутствовать в файле!"},
            /* CONSOLE EVENT MESSAGES */

            /* Collection */
            {"message_add_element", "Для добавления нового элемента в коллекцию заполните значения полей:"},
            {"message_add_element_incorrect_script_error", "\nВсе поля должны быть введены корректно! Проверьте скрипт!"},
            /* Collection */

            /* ADDRESS */
            {"message_street_null_error", "Поле улицы не может быть null или пустым"},
            /* ADDRESS */

            /* USERS*/
            {"message_user_authorized", "Пользователь авторизован!"},
            {"message_user_not_found_error", "Пользовать не найден!"},
            {"message_user_exists_error", "Имя занято! Попробуйте другое!"},
            {"message_user_registered", "Пользователь с логином %s зарегистрирован"},
            /* USERS */

            /* Execute */
            {"message_id_incorrect_error", "ID должен быть больше 0!"},
            {"message_logout", "Вы вышли из системы!"},
            {"message_incorrect_type_error", "Указан неверный тип!"},
            {"message_exit", "Вызвана команда закрытия программы"},
            {"message_update_field_error", "Произошла ошибка при обновлении поля!"},
            {"message_argument_error", "Не указан аргумент!"},
            {"message_argument_id_error", "Ошибка при вводе аргумента. ID должен быть натуральным числом"},
            {"message_unknown_command_error", "Несуществующая команда. Введите help для справки."},
            {"message_update_canceled", "Обновление поля было отменено пользователем!"},
            /* Execute */

            /* Organization */
            {"message_name_null_error", "Поле имени не может быть null или пустым"},
            {"message_cord_null_error", "Поле координат не может быть null"},
            {"message_annual_turnover_incorrect_value_error", "Поле координат не может быть null"},
            /* Organization */

            /* Collection */
            {"message_collection_info", "Тип коллекции: %s, дата инициализации: %s, количество элементов %x"},
            {"message_collection_clear", "Коллекция очищена!"},
            {"message_collection_clear_error", "Не удалось очистить коллекцию в базе данных!"},
            {"message_collection_empty_error", "Ошибка: коллекция пуста!"},
            {"message_collection_clear_by_author", "Коллекция очищена! Все ваши элементы удалены!"},
            {"message_collection_clear_by_author_error", "Не удалось очистить коллекцию в базе данных или же вам не принадлежит ни один из объектов!"},
            {"message_collection_clear_by_author_server_error", "Произошла ошибка при удалении коллекции на сервере!"},
            {"message_collection_head", "Первый элемент коллекции: "},
            {"message_collection_head_error", "Ошибка: невозможно вывести элемент, так как коллекция пуста!"},
            {"message_collection_show_error", "Ошибка: невозможно вывести элементы, так как коллекция пуста!"},
            {"message_collection_sum_of_annual_turnover", "Сумма годового оборота для всех элементов коллекции: "},
            {"message_collection_sum_of_annual_turnover_error", "Ошибка: невозможно вывести сумму годового оборота, так как коллекция пуста!"},
            {"message_collection_remove_any_by_type", "Элемент с типом %s удален (%x)"},
            {"message_collection_remove_any_by_type_error", "Ошибка: невозможно удалить элемент, так как коллекция пуста!"},
            {"message_collection_remove_any_by_type_not_found_error", "Ошибка: элемент с указанным типом %s не найден или вы не можете удалить его из-за отсутствия прав доступа! Попробуйте ввести команду еще раз!"},
            {"message_collection_remove_by_id", "Элемент удален (%x)"},
            {"message_collection_remove_by_id_error", "Ошибка: невозможно удалить элемент, так как коллекция пуста!"},
            {"message_collection_remove_by_id_incorrect_id_error", "Ошибка: ID должен быть > 0!"},
            {"message_collection_remove_by_id_not_found_error", "Ошибка: элемент с указанным ID (%x) не найден или вы не можете удалить его из-за отсутствия прав доступа! Попробуйте ввести команду еще раз!"},
            {"message_collection_update_name", "Поле имени обновлено!"},
            {"message_collection_update_name_error", "Не удалось обновить имя организации "},
            {"message_collection_update_coordinates", "Поле координат обновлено!"},
            {"message_collection_update_coordinates_error", "Не удалось обновить координаты "},
            {"message_collection_update_annual_turnover", "Поле годового оборота обновлено!"},
            {"message_collection_update_annual_turnover_error", "Не удалось обновить годовой оборот "},
            {"message_collection_update_type", "Поле типа организации обновлено!"},
            {"message_collection_update_address", "Поле адреса обновлено!"},
            {"message_collection_update_exit", "Обновление поля было отменено пользователем!"},
            {"message_collection_update_field_error", "Произошла ошибка при обновлении поля!"},
            {"message_collection_update_author_error", "Вы не можете обновить элемент коллекции с указанным ID (%x), так как не являетесь его автором!"},
            {"message_collection_update_incorrect_id_error", "Ошибка: ID должен быть > 0!"},
            {"message_collection_update_server_error", "Ошибка: не удалось обновить элемент коллекции в базе данных!"},
            {"message_collection_update_not_found_error", "Ошибка: элемент с указанным ID (%x) не найден! Попробуйте ввести команду еще раз!"},
            {"message_collection_update_error", "Невозможно обновить элементы, так как коллекция пуста!"},
            {"message_collection_update", "Элемент обновлен!"},
            {"message_collection_print_field_ascending_annual_turnover_error", "Ошибка: невозможно вывести элементы, так как коллекция пуста!"},
            {"message_collection_remove_greater", "Из коллекции удалено %x элементов, превышающиих годовой оборот на %x"},
            {"message_collection_remove_greater_server_error", "Ошибка: не удалось удалить элемент коллекции в базе данных или вы не можете удалить его из-за отсутствия прав доступа!"},
            {"message_collection_remove_greater_error", "Ошибка: невозможно удалить элементы, так как коллекция пуста!"},
            {"message_collection_remove_lower", "Из коллекции удалено %x элементов, меньших по годовому обороту чем %x"},
            {"message_collection_remove_lower_server_error", "Ошибка: не удалось удалить элемент коллекции в базе данных или вы не можете удалить его из-за отсутствия прав доступа!"},
            {"message_collection_remove_lower_error", "Ошибка: невозможно удалить элементы, так как коллекция пуста!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}