/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AuthorizedConnectAppFetcher extends Fetcher<AuthorizedConnectApp> {
    private String accountSid;
    private final String connectAppSid;

    /**
     * Construct a new AuthorizedConnectAppFetcher.
     * 
     * @param connectAppSid The connect_app_sid
     */
    public AuthorizedConnectAppFetcher(final String connectAppSid) {
        this.connectAppSid = connectAppSid;
    }

    /**
     * Construct a new AuthorizedConnectAppFetcher.
     * 
     * @param accountSid The account_sid
     * @param connectAppSid The connect_app_sid
     */
    public AuthorizedConnectAppFetcher(final String accountSid, 
                                       final String connectAppSid) {
        this.accountSid = accountSid;
        this.connectAppSid = connectAppSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched AuthorizedConnectApp
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AuthorizedConnectApp fetch(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/AuthorizedConnectApps/" + this.connectAppSid + ".json",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("AuthorizedConnectApp fetch failed: Unable to connect to server");
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
        
        return AuthorizedConnectApp.fromJson(response.getStream(), client.getObjectMapper());
    }
}