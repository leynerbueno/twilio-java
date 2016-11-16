/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.accounts.v1.credential;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class PublicKeyUpdater extends Updater<PublicKey> {
    private final String sid;
    private String friendlyName;
    private String publicKey;

    /**
     * Construct a new PublicKeyUpdater.
     * 
     * @param sid The sid
     */
    public PublicKeyUpdater(final String sid) {
        this.sid = sid;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public PublicKeyUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The public_key.
     * 
     * @param publicKey The public_key
     * @return this
     */
    public PublicKeyUpdater setPublicKey(final String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated PublicKey
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PublicKey update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.ACCOUNTS.toString(),
            "/v1/Credentials/PublicKeys/" + this.sid + "",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("PublicKey update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return PublicKey.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (publicKey != null) {
            request.addPostParam("PublicKey", publicKey);
        }
    }
}