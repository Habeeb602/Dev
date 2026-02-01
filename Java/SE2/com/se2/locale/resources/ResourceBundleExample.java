package com.se2.locale.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
//        resourceBundles();
//        resourceBundlesRetrieveDefaultLocale();
        resourceBundlesRetrieveDefaultFile();
    }

    private static void resourceBundles(){
        Locale franceLocale = new Locale("fr", "FR");

        ResourceBundle rb = ResourceBundle.getBundle("com.se2.locale.resources.Prop", franceLocale);

        System.out.println("rb.getString(\"name\") = " + rb.getString("name"));
    }

    private static void resourceBundlesRetrieveDefaultLocale(){
        Locale germanyLocale = new Locale("de", "DE");

        ResourceBundle rb = ResourceBundle.getBundle("com.se2.locale.resources.Prop", germanyLocale);

        System.out.println("rb.getString(\"name\") = " + rb.getString("name"));
    }

    private static void resourceBundlesRetrieveDefaultFile(){
        Locale.setDefault(new Locale("ar", "EG"));

        Locale germanyLocale = new Locale("de", "DE");

        ResourceBundle rb = ResourceBundle.getBundle("com.se2.locale.resources.Prop", germanyLocale);

        System.out.println("rb.getString(\"name\") = " + rb.getString("name"));

    }
}
