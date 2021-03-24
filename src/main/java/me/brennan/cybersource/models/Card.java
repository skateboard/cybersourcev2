package me.brennan.cybersource.models;

import com.google.gson.JsonObject;

/**
 * @author Brennan
 * @since 3/23/2021
 **/
public class Card {
    private final String number, securityCode, expMonth, expYear;
    private final CardTypes cardType;

    public Card(String number, String securityCode, String expMonth, String expYear, CardTypes cardType) {
        this.number = number;
        this.securityCode = securityCode;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public CardTypes getCardType() {
        return cardType;
    }

    public JsonObject toJson() {
        final JsonObject cardObject = new JsonObject();
        cardObject.addProperty("securityCode", getSecurityCode());
        cardObject.addProperty("number", getNumber());
        cardObject.addProperty("type", getCardType().getValue());
        cardObject.addProperty("expirationMonth", getExpMonth());
        cardObject.addProperty("expirationYear", getExpYear());

        return cardObject;
    }
}
