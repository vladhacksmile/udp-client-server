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

            /* SVAR-PROTOKOLLBEHANDLEREN */
            {"message_user_not_authorized_error", " brukeren er ikke logget inn! Utførelse av kommandoer er forbudt!"},
            {"message_help", "hjelp - utgang hjelp til kommandoer som er tilgjengelige,\n" +
            "info - utgang informasjon om samlingen (type, initialisering dato, antall elementer, etc.) til standard ut-strømmen\n" +
            "vis-utgang til standard output stream alle deler av samlingen i streng representasjon\n" +
            "legg til {element} - legge til et nytt element til samlingen\n" +
            "update id {element} - oppdatere verdien av en samling element hvis id er lik den angitte\n" +
            "remove_by_id id - fjerne et element fra samlingen av sin id\n" +
            "clear - klart samlingen\n" +
            "execute_script filnavn - lese og kjøre skriptet fra den angitte filen. Skriptet inneholder kommandoer i samme form som brukeren går inn i dem interaktivt\n" +
            "avslutt-avslutt programmet (uten å lagre den i en fil)\n" +
            "head-skrive ut den første delen av samlingen\n" +
            "remove_greater {element} - du vil slette fra samlingen av alle elementer som er større enn den konfigurerte\n" +
            "remove_lower {element} - du vil slette fra samlingen av alle elementer som er mindre enn den angitte\n" +
            "remove_any_by_type type - fjern fra samling enkelt element type-feltet verdi som tilsvarer den angitte\n" +
            "sum_of_annual_turnover - viser summen av verdiene i feltet annualTurnover for alle elementer i samlingen\n" +
            "auth {logg} - autorisasjon\n" +
            "reg {logg} - registrering\n" +
            "logg av-logg\n" +
            "print_field_ascending_annual_turnover ut verdier av annualTurnover feltet av alle elementer i stigende rekkefølge"},
            {"message_added_successful", " Elementet lagt til i samlingen!"},
            {"message_server_stopped", " Server stoppet!"},
            /* SVAR-PROTOKOLLBEHANDLEREN */

            /* ELEMENT */
            {"add_element", " å Legge til et element"},
            {"update_element", " Endre et element"},
            {"enter_name", " skriv Inn et navn: "},
            {"enter_cord_x", " skriv Inn X-koordinaten: "},
            {"enter_cord_y", " skriv Inn Y-koordinaten: "},
            {"enter_annual_turnover", " Inn i årlig omsetning: "},
            {"enter_type", " Inn i organisasjonen type: "},
            {"select_type", " Velg den type organisasjon: "},
            {"enter_street", " Skriv en gate: "},
            {"enter_zipcode", " Inn i indeksen: "},
            /* ELEMENT */

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

            /* BRUKEREN*/
            {"message_user_authorized", " Brukeren er logget inn!"},
            {"message_user_not_found_error", " Bruk ikke funnet!"},
            {"message_user_exists_error", " Name er opptatt! Prøv noe annet!"},
            {"message_user_registered", " Bruker med brukernavn %s registrert"},
            /* BRUKEREN */

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

            /* Samling */
            {"message_collection_info", "Samling skriv: %s, initialisering dato: %s, antall elementer %x"},
            {"message_collection_clear", " Samling slettet!"},
            {"message_collection_clear_error", "klarte ikke å fjerne samling i databasen!"},
            {"message_collection_empty_error", " Feil: samling er tom!"},
            {"message_collection_clear_by_author", " Samling slettet! Alle elementene er fjernet!"},
            {"message_collection_clear_by_author_error", "Kunne ikke klart det samling i databasen, eller du ikke eier noen av objektene!"},
            {"message_collection_clear_by_author_server_error", "En feil oppstod under sletting samling på serveren!"},
            {"message_collection_head", "Første element i samlingen: "},
            {"message_collection_head_error", " Feil: elementet kan ikke være utdata fordi samlingen er tom!"},
            {"message_collection_show_error", " Feil: kan ikke utgang elementer fordi samlingen er tom!"},
            {"message_collection_sum_of_annual_turnover", " summen av årlig omsetning for alle elementer i samlingen: "},
            {"message_collection_sum_of_annual_turnover_error", " Feil: kan ikke sende ut den årlige omsetningen beløp fordi samlingen er tom!"},
            {"message_collection_remove_any_by_type", " Element med type %s slettet (%x)"},
            {"message_collection_remove_any_by_type_error", " Feil: kan ikke slette elementet, fordi samlingen er tom!"},
            {"message_collection_remove_any_by_type_not_found_error", " Feil: element med den angitte typen %s ble ikke funnet eller du kan ikke slette det på grunn av mangel på tilgang til rettigheter! Prøv å skrive kommandoen på nytt!"},
            {"message_collection_remove_by_id", " Element som er slettet (%x)"},
            {"message_collection_remove_by_id_error", " Feil: kan ikke slette elementet, fordi samlingen er tom!"},
            {"message_collection_remove_by_id_incorrect_id_error", " Feil: ID må være > 0!"},
            {"message_collection_remove_by_id_not_found_error", " Feil: element med den angitte ID-en (%x) ikke ble funnet, eller du kan ikke slette det på grunn av mangel på tilgang til rettigheter! Prøv å skrive kommandoen på nytt!"},
            {"message_collection_update_name", "Name feltet oppdatert!"},
            {"message_collection_update_name_error", "klarte ikke å oppdatere organisasjon "},
            {"message_collection_update_coordinates", " Koordinere feltet oppdatert!"},
            {"message_collection_update_coordinates_error", "klarte ikke å oppdatere koordinater "},
            {"message_collection_update_annual_turnover", "Årlig omsetning feltet oppdatert!"},
            {"message_collection_update_annual_turnover_error", "klarte ikke å oppdatere årlig omsetning "},
            {"message_collection_update_type", " Organisasjon type-feltet, oppdatert!"},
            {"message_collection_update_address", " Adresse-feltet oppdatert!"},
            {"message_collection_update_exit", "feltet oppdateringen ble avbrutt av bruker!"},
            {"message_collection_update_field_error", "det oppstod En feil under oppdatering av feltet!"},
            {"message_collection_update_author_error", "Du kan ikke oppdatere en samling elementet med den angitte ID-en (%x) fordi du er ikke dens forfatter!"},
            {"message_collection_update_incorrect_id_error", " Feil: ID må være > 0!"},
            {"message_collection_update_server_error", " Error: kunne ikke oppdatere en samling element i databasen!"},
            {"message_collection_update_not_found_error", " Feil: element med den angitte ID-en (%x) ble ikke funnet! Prøv å skrive kommandoen på nytt!"},
            {"message_collection_update_error", " kan Ikke oppdatere elementer fordi samlingen er tom!"},
            {"message_collection_update", " Element oppdatert!"},
            {"message_collection_print_field_ascending_annual_turnover_error", " Feil: kan ikke utgang elementer fordi samlingen er tom!"},
            {"message_collection_remove_greater", "%x elementer som overstiger den årlige omsetningen av %x ble fjernet fra samlingen"},
            {"message_collection_remove_greater_server_error", " Error: kunne ikke slette en samling element i databasen, eller du ikke kan slette den, fordi du ikke har tilgang til rettigheter!"},
            {"message_collection_remove_greater_error", " Feil: kan ikke slette elementer fordi samlingen er tom!"},
            {"message_collection_remove_lower", "%x elementer mindre enn %x i årlig omsetning ble fjernet fra samlingen"},
            {"message_collection_remove_lower_server_error", " Error: kunne ikke slette en samling element i databasen, eller du ikke kan slette den, fordi du ikke har tilgang til rettigheter!"},
            {"message_collection_remove_lower_error", " Feil: kan ikke slette elementer fordi samlingen er tom!"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}