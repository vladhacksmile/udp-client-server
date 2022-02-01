package resources;

import java.util.ListResourceBundle;

public class locale_no_NO extends ListResourceBundle {

    private static final Object[][] contents = {

            /* LANGUAGES */
            {"lang_ru", "Русский язык"},
            {"lang_no", "Norske"},
            {"lang_hr", "Hrvatski"},
            {"lang_en", "English language"},
            /* LANGUAGES */

            /* SKJEMA FOR PÅLOGGING */
            {"authorization", "Godkjenning"},
            {"enter_login", "skriv Inn brukernavn:"},
            {"enter_password", "Oppgi passord:"},
            {"auth", "Logg inn"},
            {"register", "Registrer deg"},
            {"connecting", "Tilkobling til serveren..."},
            /* SKJEMA FOR PÅLOGGING */

            /*  LOBBYEN FORM */
            {"lobby", "Main menu"},
            {"hello_user", "Hallo, %s!"},
            {"console", "Konsoll"},
            {"collection", "Samling"},
            {"visualization", "Visualisering"},
            {"send", "Send"},
            {"sort_by", "Sorter etter:"},
            {"update", "Oppdatering"},
            {"add", " Legg til"},
            {"change", " Endre"},
            {"delete", " Slett"},
            {"id"," ID"},
            {"name", " Name"},
            {"cord_x", "X-koordinaten"},
            {"cord_y", "Y-koordinaten"},
            {"creation_date", "Creation date"},
            {"annual_turnover", "Årlig omsetning"},
            {"type", "Type"},
            {"street", "Street"},
            {"zipcode", "Index"},
            {"author", "Author"},
            {"exit", "Exit"},
            /* LOBBYEN FORM */

            /* ELEMENT */
            {"add_element", "å Legge til et element"},
            {"update_element", "Endre et element"},
            {"enter_name", "skriv Inn et navn: "},
            {"enter_cord_x", "skriv Inn X-koordinaten: "},
            {"enter_cord_y", "skriv Inn Y-koordinaten: "},
            {"enter_annual_turnover", "Inn i årlig omsetning: "},
            {"enter_type", "Inn i organisasjonen type: "},
            {"select_type", "Velg den type organisasjon: "},
            {"enter_street", "Skriv en gate: "},
            {"enter_zipcode", "fInn i indeksen: "},
            /* ELEMENT */

            /* MELDING BILDETEKSTER */
            {"message_caption_error", " Feil"},
            /* MELDING BILDETEKSTER */

            /* MELDINGER ELEMENT */
            {"message_check_number_fields", " Sjekk den numeriske felt!"},
            {"message_annual_turnover_number_format_error", " Den årlige omsetningen må være et heltall!"},
            {"message_coordinates_number_format_error", "X-og Y-koordinatene må være en flytende-punkt nummer!"},
            /* MELDINGER ELEMENT */

            /* KONSOLLEN EVENT MELDINGER */
            {"message_enter_name_field_to_change", " Angi navnet på feltet du ønsker å endre: "},
            {"message_help_fields", " Hjelp for felt:\nname - endre navn\ncoordinates - endre koordinatene\nannualTurnover - endre årlig omsetning\ntype - endre type\naddress - endre adresse\nFor exit, skriv inn exit"},
            {"message_read_file_error", "En feil oppstod under lesing av filen!"},
            {"message_name_field_null_error", " feltet navnet må ikke være null!"},
            {"message_name_field_incorrect_error", " Ugyldig felt navn! Ring hjelpe for hjelp!"},
            {"message_incorrect_value_error", "Ugyldig verdi oppgitt, vennligst prøv igjen!"},
            {"message_name_not_null_error", " navnet må ikke være null!"},
            {"message_cord_x_incorrect_error", "verdien av X må ikke overstige 662!"},
            {"message_annual_turnover_incorrect_error", " Den årlige omsetningen må være et naturlig tall!"},
            {"message_annual_turnover_not_null_error", " Årlig omsetning kan ikke være null!"},
            {"available_types_of_organizations", " Tilgjengelig organisasjonstypene: "},
            {"message_type_incorrect_error", " Sjekk organisasjonen type verdi! Hvis dette feltet er null, la strengen er tom!"},
            {"message_type_incorrect_file_error", "Selv om organisasjonen typen kan være null, feltet for det må være til stede i filen!"},
            /* KONSOLLEN EVENT MELDINGER */

            /* Samling */
            {"message_add_element", " Å legge til et nytt element til innsamling, fyll ut feltet verdier:"},
            {"message_add_element_incorrect_script_error", " \nAlle felter må angis på riktig måte! Sjekk script!"},
            /* Samling */

            /* ADRESSE */
            {"message_street_null_error", " gaten feltet kan ikke være null eller tom"},
            /* ADRESSE */

            /* Utføre */
            {"message_id_incorrect_error", " ID må være større enn 0!"},
            {"message_logout", "Du er logget ut!"},
            {"message_incorrect_type_error", " Ugyldig typen som er angitt!"},
            {"message_exit", "Program nær kommando som heter"},
            {"message_update_field_error", "det oppstod En feil under oppdatering av feltet!"},
            {"message_argument_error", "Ingen argumenter som er spesifisert!"},
            {"message_argument_id_error", " Feil ved å legge et argument. ID må være en naturlig nummer"},
            {"message_unknown_command_error", " ikke-Eksisterende kommando. Skriv inn help for å få hjelp."},
            {"message_update_canceled", "feltet oppdateringen ble avbrutt av bruker!"},
            /* Utføre */

            /* Organisasjon */
            {"message_name_null_error", "navn-feltet kan ikke være null eller tom"},
            {"message_cord_null_error", " koordinering-feltet kan ikke være null"},
            {"message_annual_turnover_incorrect_value_error", " koordinering-feltet kan ikke være null"},
            /* Organisasjon */

            /* ResponseHandler */
            {"message_connect_to_server", " Forbindelsen er opprettet!"},
            {"message_resend_command", " klienten videresendt kommandoen igjen!"},
            {"message_auth_register_warning", " Logg deg på eller registrere deg!"},
            {"message_connect_to_server_error", "kunne ikke koble til server! Forsøk å koble til serveren etter 3 sekunder"},
            {"message_connect_to_server_class_error", "Klasse kan ikke være definert, kanskje noe med data serialisering eller bufferen feil!"},
            /* ResponseHandler */

            /* UDPSocketClient */
            {"message_client_already_run", " klienten er allerede i gang!"},
            {"message_client_close", " programmet er avsluttet på brukerens forespørsel!"},
            {"message_try_to_connect_to_server", " Forsøk på å koble til serveren "},
            {"message_connect_to_server_failed_error", "kunne ikke koble til server!"},
            {"message_socket_error", " Socket-feil!"},
            {"message_connect_to_host_error", "kunne ikke koble til verten!"},
            {"message_send_request_error", "det oppstod En feil mens du sender forespørsel!"},
            {"message_unsupported_charset_error", " ikke Støttes, koding!"},
            {"message_file_not_found_error", " Fil ikke funnet! Sjekk fil og prøv igjen!"},
            {"message_recursion_error", " Recursion er forbudt!"},
            {"message_no_rights_file", " Ingen fil skriv rettigheter!"},
            /* UDPSocketClient */

            /* Utils */
            {"message_unknown_encryption_algorithm_error", "Den angitte krypteringsalgoritme ble ikke funnet!"}
            /* Utils */
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
