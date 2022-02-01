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

            /* LOGIN FORM */
            {"authorization", "authorization"},
            {"enter_login", "enter login:"},
            {"enter_password", "enter password:"},
            {"auth", "Authorize"},
            {"register", "Register"},
            {"connecting", "connecting to server..."},
            /* LOGIN FORM */

            /* LOBBY FORM */
            {"lobby", "main menu"},
            {"hello_user", "Hello, %s!"},
            {"console", "console"},
            {"collection", "collection"},
            {"visualization", "visualization"},
            { "send", "send"},
            {"sort_by", "sort by:"},
            {"update", "update"},
            {"add", "add"},
            {"change", "change"},
            {"delete", "Delete"},
            {"id", "ID"},
            {"name", "name"},
            {"cord_x", "X coordinate"},
            {"cord_y", "coordinate Y"},
            {"creation_date", "creation date"},
            {"annual_turnover", "annual turnover"},
            {"type", "type"},
            {"street", "street"},
            {"zipcode", "index"},
            {"author", "author"},
            {"exit", "exit"},
            /* LOBBY FORM */

            /* ELEMENT */
            {"add_element", "add element"},
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

            /* MESSAGE CAPTIONS */
            {"message_caption_error", "Error"},
            /* MESSAGE CAPTIONS */

            /* MESSAGES ELEMENT */
            {"message_check_number_fields", "Check numeric fields!"},
            {"message_annual_turnover_number_format_error", "Annual turnover must be an integer!"},
            {"message_coordinates_number_format_error", "X and Y coordinates must be a floating point number!"},
            /* MESSAGES ELEMENT */

            /* CONSOLE EVENT MESSAGES */
            {"message_enter_name_field_to_change", "Specify the name of the field you want to change:"},
            {"message_help_fields", "Help on fields:\nname - change name\ncoordinates - change coordinates\nannualTurnover - change annual turnover\ntype - change type\naddress - change address\nTo exit enter exit"},
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

            /* Execute */
            {"message_id_incorrect_error", "ID must be greater than 0!"},
            {"message_logout", "You are logged out!"},
            {"message_incorrect_type_error", "Wrong type specified!"},
            {"message_exit", "The close program command was called"},
            {"message_update_field_error", "An error occurred while updating the field!"},
            {"message_argument_error", "No argument specified!"},
            {"message_argument_id_error", "Error entering argument. ID must be a natural number"},
            {"message_unknown_command_error", "Non-existent command. Enter help for help."},
            {"message_update_canceled", "The field update was cancelled by the user!"},
            /* Execute */

            /* Organization */
            {"message_name_null_error", "The name field cannot be null or empty"},
            {"message_cord_null_error", "The coordinate field cannot be null"},
            {"message_annual_turnover_incorrect_value_error", "The coordinate field cannot be null"},
            /* Organization */

            /* ResponseHandler */
            {"message_connect_to_server", "Connection established!"},
            {"message_resend_command", "Client resend command!"},
            {"message_auth_register_warning", "Authorize or register!"},
            {"message_connect_to_server_error", "Failed to connect to the server! Attempted to connect to the server after 3 seconds"},
            {"message_connect_to_server_class_error", "Failed to identify the class, possibly something with data serialization or lack of buffer size!"},
            /* ResponseHandler */

            /* UDPSocketClient */
            {"message_client_already_run", "The client is already running!"},
            {"message_client_close", "Program terminated on user demand!"},
            {"message_try_to_connect_to_server", "Attempting to connect to the server"},
            {"message_connect_to_server_failed_error", "Failed to connect to the server!"},
            {"message_socket_error", "Socket error!"},
            {"message_connect_to_host_error", "Failed to connect to host!"},
            {"message_send_request_error", "An error occurred while sending the request!"},
            {"message_unsupported_charset_error", "Unsupported encoding!"},
            {"message_file_not_found_error", "File not found! Check the file name and try again!"},
            {"message_recursion_error", "Recursion denied!"},
            {"message_no_rights_file", "No rights to write the file!"},
            /* UDPSocketClient */

            /* Utils */
            {"message_unknown_encryption_algorithm_error", "The specified encryption algorithm was not found!"}
            /* Utils */
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
