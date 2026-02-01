package com.se2.locale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormatterExample {

    public static void main(String[] args) {
        DateTimeFormatterExample dateTimeFormatterExample = new DateTimeFormatterExample();
        dateTimeFormatterExample.localizingDates();

    }

    public void localizingDates(){

        Locale localeUS = Locale.US;
        Locale localeFrance = new Locale("fr", "FR");
        Locale localeGermany = Locale.GERMANY;

        LocalDateTime ldt = LocalDateTime.now();

        DateTimeFormatter dtfDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("DateTimeFormatter date format with locale: ");
        System.out.println("dtf.localizedBy(localeUS).format(ldt) = " + dtfDate.localizedBy(localeUS).format(ldt));
        System.out.println("dtf.localizedBy(localeFrance).format(ldt) = " + dtfDate.localizedBy(localeFrance).format(ldt));
        System.out.println("dtf.localizedBy(localeGermany).format(ldt) = " + dtfDate.localizedBy(localeGermany).format(ldt));

        System.out.println();

        DateTimeFormatter dtfTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

        System.out.println("DateTimeFormatter time format with locale: ");
        System.out.println("dtfTime.localizedBy(localeUS).format(ldt) = " + dtfTime.localizedBy(localeUS).format(ldt));
        System.out.println("dtfTime.localizedBy(localeFrance).format(ldt) = " + dtfTime.localizedBy(localeFrance).format(ldt));
        System.out.println("dtfTime.localizedBy(localeGermany).format(ldt) = " + dtfTime.localizedBy(localeGermany).format(ldt));

        System.out.println();

        DateTimeFormatter dtfDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println("DateTimeFormatter dateTime format with locale: ");
        System.out.println("dtfDateTime.localizedBy(localeUS).format(ldt) = " + dtfDateTime.localizedBy(localeUS).format(ldt));
        System.out.println("dtfDateTime.localizedBy(localeFrance).format(ldt) = " + dtfDateTime.localizedBy(localeFrance).format(ldt));
        System.out.println("dtfDateTime.localizedBy(localeGermany).format(ldt) = " + dtfDateTime.localizedBy(localeGermany).format(ldt));
    }

}
