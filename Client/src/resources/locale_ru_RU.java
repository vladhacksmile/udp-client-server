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

            /* LOGIN FORM */
            {"authorization", "Авторизация"},
            {"enter_login", "Введите логин:"},
            {"enter_password", "Введите пароль:"},
            {"auth", "Авторизоваться"},
            {"register", "Зарегистрироваться"},
            {"connecting", "Соединение с сервером..."},
            /* LOGIN FORM */

            /* LOBBY FORM */
            {"lobby", "Главное меню"},
            {"hello_user", "Привет, %s!"},
            {"console", "Консоль"},
            {"collection", "Коллекция"},
            {"visualization", "Визуализация"},
            {"send", "Отправить"},
            {"sort_by", "Сортировать по:"},
            {"update", "Обновить"},
            {"add", "Добавить"},
            {"change", "Изменить"},
            {"delete", "Удалить"},
            {"id", "ID"},
            {"name", "Имя"},
            {"cord_x", "Координата X"},
            {"cord_y", "Координата Y"},
            {"creation_date", "Дата создания"},
            {"annual_turnover", "Годовой оборот"},
            {"type", "Тип"},
            {"street", "Улица"},
            {"zipcode", "Индекс"},
            {"author", "Автор"},
            {"exit", "Выход"},
            /* LOBBY FORM */

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

            /* MESSAGE CAPTIONS */
            {"message_caption_error", "Ошибка"},
            /* MESSAGE CAPTIONS */

            /* MESSAGES ELEMENT */
            {"message_check_number_fields", "Проверьте числовые поля!"},
            {"message_annual_turnover_number_format_error", "Годовой оборот должен быть целым числом!"},
            {"message_coordinates_number_format_error", "Координаты X и Y должны быть числом с плавающей запятой!"},
            /* MESSAGES ELEMENT */

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

            /* ResponseHandler */
            {"message_connect_to_server", "Соединение установлено!"},
            {"message_resend_command", "Клиент переотправил команду заново!"},
            {"message_auth_register_warning", "Авторизуйтесь или зарегистрируйтесь!"},
            {"message_connect_to_server_error", "Не удалось подключиться к серверу! Попытка подключиться к серверу через 3 секунды"},
            {"message_connect_to_server_class_error", "Не удалось определить класс, возможно что-то с сериализацией данных или недостаток размера буфера!"},
            /* ResponseHandler */

            /* UDPSocketClient */
            {"message_client_already_run", "Клиент уже запущен!"},
            {"message_client_close", "Программа завершена по требованию пользователя!"},
            {"message_try_to_connect_to_server", "Попытка подключиться к серверу "},
            {"message_connect_to_server_failed_error", "Не удалось подключиться к серверу!"},
            {"message_socket_error", "Ошибка сокета!"},
            {"message_connect_to_host_error", "Не удалось подключиться к хосту!"},
            {"message_send_request_error", "Произошла ошибка при отправке запроса!"},
            {"message_unsupported_charset_error", "Неподдерживаемая кодировка!"},
            {"message_file_not_found_error", "Файл не найден! Проверьте название файла и повторите попытку!"},
            {"message_recursion_error", "Рекурсия запрещена!"},
            {"message_no_rights_file", "Нет прав на запись файла!"},
            /* UDPSocketClient */

            /* Utils */
            {"message_unknown_encryption_algorithm_error", "Указанный алгоритм шифрования не найден!"}
            /* Utils */
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
