package ua.training.controller;

import java.util.ResourceBundle;

public class Endpoint {
    private static Endpoint instance;
    private ResourceBundle resourceBundle;

    public static final String LOGIN_FORM = "LOGIN_FORM";
    public static final String REGISTER_FORM = "REGISTER_FORM";
    public static final String INDEX_FORM = "INDEX_FORM";
    public static final String ERROR_FORM = "ERROR_FORM";
    public static final String COUNTRY_FORM = "COUNTRY_FORM";
    public static final String COUNTRY_LIST_FORM = "COUNTRY_LIST_FORM";
    public static final String SHIP_LIST_FORM = "SHIP_LIST_FORM";
    public static final String EXCURSION_LIST_FORM = "EXCURSION_LIST_FORM";
    public static final String CRUISE_LIST_FORM = "CRUISE_LIST_FORM";
    public static final String CARD_LIST_FORM = "CARD_LIST_FORM";
    public static final String SUCCES_FORM = "SUCCES_FORM";
    public static final String PROFILE_FORM = "PROFILE_FORM";
    public static final String ABOUT_FORM = "ABOUT_FORM";
    public static final String CONTACT_FORM = "CONTACT_FORM";
    public static final String ORDER_ALL_FORM = "ORDER_ALL_FORM";


    public static Endpoint getInstance() {
        if (instance == null) {
            instance = new Endpoint();
            instance.resourceBundle = ResourceBundle.getBundle("endpoint");
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
