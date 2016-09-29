/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.sip.domain;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class CredentialListMappingFetcher extends Fetcher<CredentialListMapping> {
    private String accountSid;
    private final String domainSid;
    private final String sid;

    /**
     * Construct a new CredentialListMappingFetcher.
     * 
     * @param domainSid The domain_sid
     * @param sid The sid
     */
    public CredentialListMappingFetcher(final String domainSid, 
                                        final String sid) {
        this.domainSid = domainSid;
        this.sid = sid;
    }

    /**
     * Construct a new CredentialListMappingFetcher.
     * 
     * @param accountSid The account_sid
     * @param domainSid The domain_sid
     * @param sid The sid
     */
    public CredentialListMappingFetcher(final String accountSid, 
                                        final String domainSid, 
                                        final String sid) {
        this.accountSid = accountSid;
        this.domainSid = domainSid;
        this.sid = sid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched CredentialListMapping
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public CredentialListMapping fetch(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/SIP/Domains/" + this.domainSid + "/CredentialListMappings/" + this.sid + ".json",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("CredentialListMapping fetch failed: Unable to connect to server");
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
        
        return CredentialListMapping.fromJson(response.getStream(), client.getObjectMapper());
    }
}