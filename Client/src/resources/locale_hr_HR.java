package resources;

import java.util.ListResourceBundle;

public class locale_hr_HR extends ListResourceBundle {

    private static final Object[][] contents = {

            /* LANGUAGES */
            {"lang_ru", "Русский язык"},
            {"lang_no", "Norske"},
            {"lang_hr", "Hrvatski"},
            {"lang_en", "English language"},
            /* LANGUAGES */

            /* LOGIN FORM */
            {"authorization", " autorizacija"},
            {"enter_login", " unesite prijavu:"},
            {"enter_password", " unesite lozinku:"},
            {"auth", " Prijava"},
            {"register", "Registriraj se"},
            {"connecting", "povezivanje s poslužiteljem..."},
            /* LOGIN FORM */

            /* LOBBY FORM */
            {"lobby", " glavni izbornik"},
            {"hello_user", " bok, %s!"},
            {"console", " konzola"},
            {"collection", " Zbirka"},
            {"visualization", " vizualizacija"},
            {"send", " Pošalji"},
            {"sort_by", " Sortiraj po:"},
            {"update", " Ažuriraj"},
            {"add", " Dodaj"},
            {"change", " uredi"},
            {"delete", " Uninstall"},
            {"id", "ID"},
            {"name", " Ime"},
            {"cord_x", " x koordinata"},
            {"cord_y", " koordinata Y"},
            {"creation_date", " datum stvaranja"},
            {"annual_turnover", " godišnji promet"},
            {"type", " Tip"},
            {"street", " Ulica"},
            {"zipcode", " indeks"},
            {"author", " Autor"},
            {"exit", " Izlaz"},
            /* LOBBY FORM */

            /* ELEMENT */
            {"add_element", " dodavanje stavke"},
            {"update_element", " promjena stavke"},
            {"enter_name", " unesite ime: "},
            {"enter_cord_x", " unesite X koordinatu: "},
            {"enter_cord_y", " unesite koordinatu Y: "},
            {"enter_annual_turnover", " unesite godišnji promet: "},
            {"enter_type", " unesite vrstu organizacije: "},
            {"select_type", " odaberite vrstu organizacije: "},
            {"enter_street", " unesite ulicu: "},
            {"enter_zipcode", " unesite indeks: "},
            /* ELEMENT */

            /* MESSAGE CAPTIONS */
            {"message_caption_error", " greška"},
            /* MESSAGE CAPTIONS */

            /* MESSAGES ELEMENT */
            {"message_check_number_fields", " provjerite brojčana polja!"},
            {"message_annual_turnover_number_format_error", " godišnji promet mora biti cijeli broj !"},
            {"message_coordinates_number_format_error", " koordinate X i Y moraju biti broj s pomičnim zarezom!"},
            /* MESSAGES ELEMENT */

            /* CONSOLE EVENT MESSAGES */
            {"message_enter_name_field_to_change", " navedite naziv polja koje želite promijeniti: "},
            {"message_help_fields", "\npomoć polja:\nname-promjena imena\ncoordinates-promjena koordinata \nannualTurnover-promjena godišnjeg prometa \ntype-promjena vrste \naddress-promjena adrese \ndza izlaz upišite exit"},
            {"message_read_file_error", " došlo je do pogreške prilikom čitanja datoteke!"},
            {"message_name_field_null_error", " naziv polja ne smije biti null!"},
            {"message_name_field_incorrect_error", " Pogrešno ime polja! Nazovite pomoć za pomoć!"},
            {"message_incorrect_value_error", " unesena netočna vrijednost, pokušajte ponovo!"},
            {"message_name_not_null_error", " ime ne bi trebalo biti null!"},
            {"message_cord_x_incorrect_error", " vrijednost X ne smije prelaziti 662!"},
            {"message_annual_turnover_incorrect_error", " godišnji promet mora biti prirodni broj!"},
            {"message_annual_turnover_not_null_error", " godišnji promet ne može biti null!"},
            {"available_types_of_organizations", " dostupne vrste organizacije: "},
            {"message_type_incorrect_error", " provjerite vrijednost vrste organizacije! Ako je takvo polje null - ostavite redak prazan!"},
            {"message_type_incorrect_file_error", " iako vrsta organizacije može biti null, polje za to mora biti prisutno u datoteci!"},
            /* CONSOLE EVENT MESSAGES */

            /* Collection */
            {"message_add_element", " da biste dodali novu stavku u zbirku, ispunite vrijednosti polja:"},
            {"message_add_element_incorrect_script_error", " \npvse polja moraju biti ispravno unesena! Provjerite skriptu!"},
            /* Collection */

            /* ADDRESS */
            {"message_street_null_error", " polje ulice ne može biti null ili prazno"},
            /* ADDRESS */

            /* Execute */
            {"message_id_incorrect_error", " ID mora biti veći od 0!"},
            {"message_logout", " odjavili ste se!"},
            {"message_incorrect_type_error", " navedena je pogrešna vrsta!"},
            {"message_exit", " pozvana je naredba za zatvaranje programa"},
            {"message_update_field_error", " došlo je do pogreške prilikom ažuriranja polja!"},
            {"message_argument_error", " nije naveden argument!"},
            {"message_argument_id_error", "greška prilikom unosa argumenta. ID mora biti prirodni broj"},
            {"message_unknown_command_error", " nepostojeća naredba. Unesite pomoć za pomoć."},
            {"message_update_canceled", " ažuriranje polja je otkazano od strane korisnika!"},
            /* Execute */

            /* Organization */
            {"message_name_null_error", " polje imena ne može biti null ili prazno"},
            {"message_cord_null_error", " polje koordinata ne može biti null"},
            {"message_annual_turnover_incorrect_value_error", " polje koordinata ne može biti null"},
            /* Organization */

            /* ResponseHandler */
            {"message_connect_to_server", " veza uspostavljena!"},
            {"message_resend_command", " klijent je ponovno proslijedio naredbu!"},
            {"message_auth_register_warning", " prijavite se ili se registrirajte!"},
            {"message_connect_to_server_error", " povezivanje s poslužiteljem nije uspjelo! Pokušaj povezivanja s poslužiteljem nakon 3 sekunde"},
            {"message_connect_to_server_class_error", " nije moguće definirati klasu, možda nešto s serijalizacijom podataka ili nedostatak veličine međuspremnika!"},
            /* ResponseHandler */

            /* UDPSocketClient */
            {"message_client_already_run", " klijent je već pokrenut!"},
            {"message_client_close", " program je završen na zahtjev korisnika!"},
            {"message_try_to_connect_to_server", " pokušaj povezivanja s poslužiteljem "},
            {"message_connect_to_server_failed_error", " povezivanje s poslužiteljem nije uspjelo!"},
            {"message_socket_error", " greška utičnice!"},
            {"message_connect_to_host_error", " povezivanje s hostom nije uspjelo!"},
            {"message_send_request_error", " došlo je do pogreške prilikom slanja zahtjeva!"},
            {"message_unsupported_charset_error", " nepodržano kodiranje!"},
            {"message_file_not_found_error", " datoteka nije pronađena! Provjerite naziv datoteke i pokušajte ponovo!"},
            {"message_recursion_error", " rekurzija je zabranjena!"},
            {"message_no_rights_file", " nema prava na pisanje datoteke!"},
            /* UDPSocketClient */

            /* Utils */
            {"message_unknown_encryption_algorithm_error", " navedeni algoritam šifriranja nije pronađen!"}
            /* Utils */
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
