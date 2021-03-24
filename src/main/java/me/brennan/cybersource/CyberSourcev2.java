package me.brennan.cybersource;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.jwk.RSAKey;
import me.brennan.cybersource.models.Card;

import java.util.Base64;

/**
 * @author Brennan
 * @since 3/19/2021
 **/
public class CyberSourcev2 {
    private final JWEHeader header;
    private final RSAKey rsaKey;

    private final JsonObject encryptObject = new JsonObject();

    public CyberSourcev2(String keyID) throws Exception {
        final String keyBody = new String(Base64.getDecoder().decode(keyID.split("\\.")[1]));
        final JsonObject jsonObject = JsonParser.parseString(keyBody).getAsJsonObject();
        final String kid = jsonObject.get("flx").getAsJsonObject().get("jwk").getAsJsonObject().get("kid").getAsString();

        this.rsaKey = RSAKey.parse(jsonObject.get("flx").getAsJsonObject().get("jwk").toString());

        this.header = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP,
                EncryptionMethod.A256GCM)
                .jwk(rsaKey)
                .keyID(kid).build();

        encryptObject.addProperty("context", keyID);
        encryptObject.addProperty("index", 0);
    }

    public String encrypt(Card card) throws JOSEException {
        encryptObject.add("data", card.toJson());

        final JWEObject jwe = new JWEObject(header, new Payload(encryptObject.toString()));
        jwe.encrypt(new RSAEncrypter(rsaKey));

        return jwe.serialize();
    }

}
