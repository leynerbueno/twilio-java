package com.twilio.example;


import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.http.ValidationClient;
import com.twilio.rest.accounts.v1.credential.PublicKey;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.NewSigningKey;
import com.twilio.twiml.TwiMLException;
import com.twilio.type.PhoneNumber;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class ValidationExample {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    /**
     * Example Twilio usage.
     *
     * @param args command line args
     * @throws TwiMLException if unable to generate TwiML
     */
    public static void main(String[] args) throws Exception {

        // Generate public/private key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        java.security.PublicKey pk = pair.getPublic();

        // Use the default rest client
        TwilioRestClient client =
            new TwilioRestClient.Builder(ACCOUNT_SID, AUTH_TOKEN)
                .build();
        Twilio.setRestClient(client);

        // Create a public key and signing key using the default client
        PublicKey key = PublicKey.creator(
            Base64.encodeBase64String(pk.getEncoded())
        ).setFriendlyName("Public Key").create();
        NewSigningKey signingKey = NewSigningKey.creator().create();

        // Switch to validation client as the default client
        client = new TwilioRestClient.Builder(signingKey.getSid(), signingKey.getSecret())
            .accountSid(ACCOUNT_SID)
            .httpClient(new ValidationClient(ACCOUNT_SID, key.getSid(), signingKey.getSid(), pair.getPrivate()))
            .build();
        Twilio.setRestClient(client);

        // Make REST API requests
        Iterable<Message> messages = Message.reader().read();
        for (Message m : messages) {
            System.out.println(m.getBody());
        }

        Message m = Message.creator(
            new PhoneNumber("+11234567890"),
            new PhoneNumber("+10987654321"),
            "Asymmetric Auth Test"
        ).create();
        System.out.println(m.getSid());

    }
}