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

            /* ANSWER HANDLER */
            {"message_user_not_authorized_error", " korisnik nije ovlašten! Izvršenje naredbi je zabranjeno!"},
            {"message_help", "help-izvedi pomoć za dostupne naredbe\n" +
            "info-prikaz podataka o zbirci (vrsta, Datum inicijalizacije, broj stavki itd.)\n" +
            "show-izvedite sve elemente zbirke u prikazu niza\n" +
            "add {element} - dodajte novu stavku u zbirku\n" +
            "update id {element} - Osvježi vrijednost stavke zbirke čiji je id jednak određenom\n" +
            "remove_by_id id-uklonite stavku iz zbirke po id \n" +
            "clear - očistite zbirku \n" +
            "execute_script file_name-brojati i izvršavati skriptu iz navedene datoteke. Skripta sadrži naredbe u istom obliku u kojem ih korisnik interaktivno upisuje.\n" +
            "exit-dovrši program (bez spremanja u datoteku)\n" +
            "head-izvedi prvi element zbirke\n" +
            "remove_greater {element} - Izbriši sve stavke iznad zadanog\n" +
            "remove_lower {element} - ukloni iz zbirke sve stavke manje od zadanog\n" +
            "remove_any_by_type type-Izbriši jednu stavku iz zbirke čija je vrijednost polja tipa jednaka zadanom\n" +
            "sum_of_annual_turnover-povući zbroj vrijednosti polja annualTurnover za sve stavke zbirke\n" +
            "auth {login} - autorizacija\n" +
            "reg {login} - registracija\n" +
            "logout - Odjava\n" +
            "print_field_ascending_annual_turnover-izvedi vrijednosti polja annualTurnover svih stavki u uzlaznom redoslijedu"},
            {"message_added_successful", " stavka je dodana u zbirku!"},
            {"message_server_stopped", " poslužitelj je zaustavljen!"},
            /* ANSWER HANDLER */

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

            /* CONSOLE EVENT MESSAGES */
            {"message_enter_name_field_to_change", " navedite naziv polja koje želite promijeniti: "},
            {"message_help_fields", "pomoć polja:\nname-promjena imena\ncoordinates-promjena koordinata \nannualTurnover-promjena godišnjeg prometa \ntype-promjena vrste \naddress-promjena adrese \ndza izlaz upišite exit"},
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

            /* USERS*/
            {"message_user_authorized", " korisnik je ovlašten!"},
            {"message_user_not_found_error", " koristi nije pronađen!"},
            {"message_user_exists_error", " ime je zauzeto! Pokušajte drugačije!"},
            {"message_user_registered", " prijavljeni korisnik %s"},
            /* USERS */

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

            /* Collection */
            {"message_collection_info", " vrsta zbirke: %s, datum inicijalizacije: %s, broj stavki %x"},
            {"message_collection_clear", " zbirka je izbrisana!"},
            {"message_collection_clear_error", " nije moguće očistiti zbirku u bazi podataka!"},
            {"message_collection_empty_error", " greška: zbirka je prazna!"},
            {"message_collection_clear_by_author", " Zbirka je izbrisana! Sve vaše stavke su uklonjene!"},
            {"message_collection_clear_by_author_error", " nije moguće očistiti zbirku u bazi podataka ili ne posjedujete niti jedan od objekata!"},
            {"message_collection_clear_by_author_server_error", " došlo je do pogreške prilikom brisanja zbirke na poslužitelju !"},
            {"message_collection_head", " prva stavka zbirke: "},
            {"message_collection_head_error", "pogreška: nije moguće prikazati stavku jer je zbirka prazna!"},
            {"message_collection_show_error", "pogreška: nije moguće prikazati stavke jer je zbirka prazna!"},
            {"message_collection_sum_of_annual_turnover", " zbroj godišnjeg prometa za sve elemente zbirke: "},
            {"message_collection_sum_of_annual_turnover_error", " pogreška: nije moguće povući iznos godišnjeg prometa jer je zbirka prazna!"},
            {"message_collection_remove_any_by_type", " uklonjena je stavka tipa %s (%x)"},
            {"message_collection_remove_any_by_type_error", " greška: Nije moguće ukloniti stavku jer je zbirka prazna!"},
            {"message_collection_remove_any_by_type_not_found_error", " pogreška: stavka s navedenom vrstom %s nije pronađena ili ga ne možete izbrisati zbog nedostatka dopuštenja! Pokušajte ponovno unijeti naredbu!"},
            {"message_collection_remove_by_id", " stavka je izbrisana (%x)"},
            {"message_collection_remove_by_id_error", "greška: Nije moguće izbrisati stavku jer je zbirka prazna!"},
            {"message_collection_remove_by_id_incorrect_id_error", " pogreška: ID mora biti > 0!"},
            {"message_collection_remove_by_id_not_found_error", " greška: stavka s navedenim ID-om (%x) nije pronađena ili ga ne možete izbrisati zbog nedostatka dopuštenja! Pokušajte ponovno unijeti naredbu!"},
            {"message_collection_update_name", " ažurirano polje imena!"},
            {"message_collection_update_name_error", " nije moguće ažurirati naziv organizacije "},
            {"message_collection_update_coordinates", " polje koordinata ažurirano!"},
            {"message_collection_update_coordinates_error", " nije moguće ažurirati koordinate "},
            {"message_collection_update_annual_turnover", " polje godišnjeg prometa ažurirano!"},
            {"message_collection_update_annual_turnover_error", " nije moguće ažurirati godišnji promet "},
            {"message_collection_update_type", " polje vrste organizacije je ažurirano!"},
            {"message_collection_update_address", " polje adrese ažurirano!"},
            {"message_collection_update_exit", " ažuriranje polja je otkazano od strane korisnika!"},
            {"message_collection_update_field_error", " došlo je do pogreške prilikom ažuriranja polja!"},
            {"message_collection_update_author_error", " ne možete ažurirati stavku zbirke s navedenim ID-om (%x) jer niste autor!"},
            {"message_collection_update_incorrect_id_error", " pogreška: ID mora biti > 0!"},
            {"message_collection_update_server_error", "pogreška: nije moguće ažurirati stavku zbirke u bazi podataka!"},
            {"message_collection_update_not_found_error", " greška: stavka s navedenim ID-om (%x) nije pronađena! Pokušajte ponovno unijeti naredbu!"},
            {"message_collection_update_error", " nije moguće ažurirati stavke jer je zbirka prazna!"},
            {"message_collection_update", " stavka je ažurirana!"},
            {"message_collection_print_field_ascending_annual_turnover_error", "pogreška: nije moguće prikazati stavke jer je zbirka prazna!"},
            {"message_collection_remove_greater", " %x stavki koje prelaze godišnji promet na %x uklonjeno je iz zbirke"},
            {"message_collection_remove_greater_server_error", "pogreška: nije moguće izbrisati stavku zbirke u bazi podataka ili ga ne možete izbrisati zbog nedostatka dopuštenja!"},
            {"message_collection_remove_greater_error", "pogreška: nije moguće ukloniti stavke jer je zbirka prazna!"},
            {"message_collection_remove_lower", " %x stavki koje su manje godišnje od %x uklonjene su iz zbirke"},
            {"message_collection_remove_lower_server_error", "pogreška: nije moguće izbrisati stavku zbirke u bazi podataka ili ga ne možete izbrisati zbog nedostatka dopuštenja!"},
            {"message_collection_remove_lower_error", "pogreška: nije moguće ukloniti stavke jer je zbirka prazna!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}