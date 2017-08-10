package com.exams.i18n;

import javax.servlet.http.Cookie;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleLocale {
    public static final String LOCAL_DEFAULT = "en";
    private static final String MESSAGES_PATH = "locale/messages";
    private ResourceBundle resourceBundle;

    public ResourceBundleLocale(Cookie[] cookies){
        Locale locale = new Locale(LOCAL_DEFAULT);
        if(cookies != null){
            for (Cookie cookie : cookies ){
                if(cookie.getName().equals("locale")){
                    locale = new Locale(cookie.getValue());
                    break;
                }
            }
        }
        resourceBundle = ResourceBundle.getBundle(MESSAGES_PATH, locale);
    }

    public ResourceBundle getResourceBundle(){
        return resourceBundle;
    }
}
