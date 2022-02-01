package resources;

import java.util.ListResourceBundle;

public class locale_en_US extends ListResourceBundle {

    private static final Object[][] contents = {

            /* LANGUAGES */
            {"lang_ru", "Русский язык"},
            {"lang_no", "Norske"},
            {"lang_hr", "Hrvatski"},
            {"lang_en", "English language"},
            /* LANGUAGES */

            /* ANSWER HANDLER */
            {"message_user_not_authorized_error", "User is not authorized! Command execution prohibited!"},
            {"message_help", "help - output help for available commands\n" +
            "info - output the information about the collection to the standard output stream (type, initialization date, number of items, etc.)\n" +
            "show - output all elements of the collection in the string representation to the standard output stream\n" +
            "add {element} - add a new element to the collection {n" +
            "update id {element} - update the value of the collection item whose id is equal to the given one\n" +
            "remove_by_id id - remove the item from the collection by its id\n" +
            "clear - clear the collection\n" +
            "execute_script file_name - read and execute a script from the specified file. The script contains commands in the same form as they are entered by the user in interactive mode.\n" +
            "exit - exit the program (without saving it to a file)\n" +
            "head - display the first item in the collection\n" +
            "remove_greater {element} - remove all elements from the collection that are larger than the given one\n" +
            "remove_lower {element} - remove all elements from the collection that are smaller than the given one\n" +
            "remove_any_by_type type - remove one element from the collection whose type field value is equivalent to the given one\n" +
            "sum_of_annual_turnover - display the sum of annualTurnover values for all elements of the collection\n" +
            "auth {login} - authorization\n" +
            "reg {login} - registration\n" +
            "logout - logout\n" +
            "print_field_ascending_annual_turnover - print the values of the field annualTurnover of all elements in ascending order"},
            {"message_added_successful", "Item added to collection!"},
            {"message_server_stopped", "Server stopped!"},
            /* ANSWER HANDLER */

            /* ELEMENT */
            {"add_element", "Adding an element"},
            {"update_element", "change element"},
            {"enter_name", "enter name"},
            {"enter_cord_x", "Enter X coordinate:"},
            {"enter_cord_y", "Enter coordinate Y:"},
            {"enter_annual_turnover", "Enter annual turnover:"},
            {"enter_type", "Enter organization type:"},
            {"select_type", "Select type of organization:"},
            {"enter_street", "Enter street: "},
            {"enter_zipcode", "Enter index:"},
            /* ELEMENT */

            /* CONSOLE EVENT MESSAGES */
            {"message_enter_name_field_to_change", "Enter the name of the field you want to change:"},
            {"message_help_fields", "Help on fields:\nname - change name\ncoordinates - change coordinates\nannualTurnover - change annual turnover\ntype - change type\naddress - change address\nIn order to exit enter exit"},
            {"message_read_file_error", "An error occurred while reading the file!"},
            {"message_name_field_null_error", "The field name should not be null!"},
            {"message_name_field_incorrect_error", "Wrong field name! Call help for help!"},
            {"message_incorrect_value_error", "Invalid value entered, try again!"},
            {"message_name_not_null_error", "Name should not be null!"},
            {"message_cord_x_incorrect_error", "X value must not exceed 662!"},
            {"message_annual_turnover_incorrect_error", "Annual turnover must be a natural number!"},
            {"message_annual_turnover_not_null_error", "Annual turnover cannot be null!"},
            {"available_types_of_organizations", "Available organization types:"},
            {"message_type_incorrect_error", "Check the value of organization type! If such field is null - leave the line blank!"},
            {"message_type_incorrect_file_error", "Although the organization type can be null, the field for it must be present in the file!"},
            /* CONSOLE EVENT MESSAGES */

            /* Collection */
            {"message_add_element", "To add a new element to the collection, fill in the field values:"},
            {"message_add_element_incorrect_script_error", "All fields must be entered correctly! Check the script!"},
            /* Collection */

            /* ADDRESS */
            {"message_street_null_error", "Street field cannot be null or empty"},
            /* ADDRESS */

            /* USERS*/
            {"message_user_authorized", "User is authorized!"},
            {"message_user_not_found_error", "User not found!"},
            {"message_user_exists_error", "Name busy! Try another one!"},
            {"message_user_registered", "User with username %s is registered"},
            /* USERS */

            /* Execute */
            {"message_id_incorrect_error", "ID must be greater than 0!"},
            {"message_logout", "You are logged out!"},
            {"message_incorrect_type_error", "Wrong type specified!"},
            {"message_exit", "The close program command was called"},
            {"message_update_field_error", "An error occurred while updating the field!"},
            {"message_argument_error", "No argument specified!"},
            {"message_argument_id_error", "Error entering argument. ID must be a natural number"},
            {"message_unknown_command_error", "Non-existent command. Enter help for help."},
            {"message_update_canceled", "The field update was canceled by the user!"},
            /* Execute */

            /* Organization */
            {"message_name_null_error", "The name field cannot be null or empty"},
            {"message_cord_null_error", "The coordinate field cannot be null"},
            {"message_annual_turnover_incorrect_value_error", "The coordinate field cannot be null"},
            /* Organization */

            /* Collection */
            {"message_collection_info", "Collection type: %s, initialization date: %s, number of elements %x"},
            {"message_collection_clear", "Collection cleared!"},
            {"message_collection_clear_error", "Failed to clear the collection in the database!"},
            {"message_collection_empty_error", "Error: collection empty!"},
            {"message_collection_clear_by_author", "Collection cleared! All your items have been deleted!"},
            {"message_collection_clear_by_author_error", "Failed to clear the collection in the database or you don't own any objects!"},
            {"message_collection_clear_by_author_server_error", "An error occurred while deleting the collection on the server!"},
            {"message_collection_head", "The first collection item: "},
            {"message_collection_head_error", "Error: it is not possible to display the item because the collection is empty!"},
            {"message_collection_show_error", "Error: unable to display items as collection is empty!"},
            {"message_collection_sum_of_annual_turnover", "Amount of annual turnover for all collection items: "},
            {"message_collection_sum_of_annual_turnover_error", "Error: It is not possible to output the amount of annual turnover because the collection is empty!"},
            {"message_collection_remove_any_by_type", "Item with type %s removed (%x)"},
            {"message_collection_remove_any_by_type_error", "Error: Cannot remove element because collection is empty!"},
            {"message_collection_remove_any_by_type_not_found_error", "Error: Item with the specified type %s was not found or you cannot remove it due to lack of access rights! Try entering the command again!"},
            {"message_collection_remove_by_id", "Item removed (%x)"},
            {"message_collection_remove_by_id_error", "Error: Cannot remove item because collection is empty!"},
            {"message_collection_remove_by_id_incorrect_id_error", "Error: ID must be > 0!"},
            {"message_collection_remove_by_id_not_found_error", "Error: Item with the specified ID (%x) was not found or you cannot remove it due to lack of access rights! Try entering the command again!"},
            {"message_collection_update_name", "Name field updated!"},
            {"message_collection_update_name_error", "Failed to update organization name"},
            {"message_collection_update_coordinates", "Coordinate field updated!"},
            {"message_collection_update_coordinates_error", "Failed to update coordinates"},
            {"message_collection_update_annual_turnover", "Annual turnover field updated!"},
            {"message_collection_update_annual_turnover_error", "Failed to update annual turnover"},
            {"message_collection_update_type", "Organization type field updated!"},
            {"message_collection_update_address", "Address field updated!"},
            {"message_collection_update_exit", "The field has been updated by the user!"},
            {"message_collection_update_field_error", "An error occurred while updating the field!"},
            {"message_collection_update_author_error", "You cannot update the collection item with the specified ID (%x) since you are not its author!"},
            {"message_collection_update_incorrect_id_error", "Error: ID must be > 0!"},
            {"message_collection_update_server_error", "Error: failed to update the collection item in the database!"},
            {"message_collection_update_not_found_error", "Error: element with the specified ID (%x) not found! Try entering the command again!"},
            {"message_collection_update_error", "Unable to update items because collection is empty!"},
            {"message_collection_update", "Item updated!"},
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