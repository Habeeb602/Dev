package com.se2.locale;

import java.util.Locale;

public class LocaleExample {

    public static void main(String[] args) {

        LocaleExample localeExample = new LocaleExample();

        localeExample.createLocale();
    }


    private void createLocale(){

        Locale defaultLocale = Locale.getDefault();
        System.out.println("defaultLocale = " + defaultLocale);

        // 1) using Constructors
        Locale localeEnglish = new Locale("English");
        System.out.println("localeEnglish = " + localeEnglish);

        Locale localeGB = new Locale("en", "GB");
        System.out.println("localeGB.getDisplayLanguage() = " + localeGB.getDisplayLanguage());
        System.out.println("localeGB.getDisplayCountry() = " + localeGB.getDisplayCountry());

        System.out.println();

        // 2) using Built-in constants
        Locale localeFrance = Locale.FRANCE;
        System.out.println("localeFrance = " + localeFrance);
        System.out.println("localeFrance.getDisplayCountry() = " + localeFrance.getDisplayCountry());
        System.out.println("localeFrance.getDisplayLanguage() = " + localeFrance.getDisplayLanguage());

        System.out.println();

        // 3) using Builder() pattern
        Locale localeKuwait = new Locale.Builder()
                .setRegion("KW")
                .setLanguage("ar")
                .build();
        System.out.println("localeKuwait = " + localeKuwait);
        System.out.println("localeKuwait.getDisplayLanguage() = " + localeKuwait.getDisplayLanguage());
        System.out.println("localeKuwait.getDisplayCountry() = " + localeKuwait.getDisplayCountry());
    }

}
