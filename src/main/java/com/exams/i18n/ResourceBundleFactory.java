package com.exams.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleFactory {
    public static final String LOCAL_DEFAULT = "en";
    private static final String MESSAGES_PATH = "locale/messages";
    private static ResourceBundle resourceBundle;
    private static Locale locale;

    static{
        locale = new Locale(LOCAL_DEFAULT);
        resourceBundle = ResourceBundle.getBundle(MESSAGES_PATH, locale);
    }

    public static void setLocale(Locale locale){
        if(!ResourceBundleFactory.locale.equals(locale)){
            ResourceBundleFactory.locale = locale;
            resourceBundle = ResourceBundle.getBundle(MESSAGES_PATH, locale);
        }
    }

    public static ResourceBundle getResourceBundle(){
        return resourceBundle;
    }
}
