package me.brennan.cybersource.models;

/**
 * @author Brennan
 * @since 3/23/2021
 **/
public enum CardTypes {
    VISA("001"),
    MASTER_CARD("002"),
    AMERICAN_EXPRESS("003"),
    DISCOVER("004");

    private final String value;

    CardTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
