/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;




/*
    * Twilio - Verify
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class VerificationAttemptsSummaryFetcher extends Fetcher<VerificationAttemptsSummary> {
    private String verifyServiceSid;
    private ZonedDateTime dateCreatedAfter;
    private ZonedDateTime dateCreatedBefore;
    private String country;
    private VerificationAttemptsSummary.Channels channel;
    private String destinationPrefix;

    public VerificationAttemptsSummaryFetcher(){
    }

    public VerificationAttemptsSummaryFetcher setVerifyServiceSid(final String verifyServiceSid){
    this.verifyServiceSid = verifyServiceSid;
    return this;
    }
    public VerificationAttemptsSummaryFetcher setDateCreatedAfter(final ZonedDateTime dateCreatedAfter){
    this.dateCreatedAfter = dateCreatedAfter;
    return this;
    }
    public VerificationAttemptsSummaryFetcher setDateCreatedBefore(final ZonedDateTime dateCreatedBefore){
    this.dateCreatedBefore = dateCreatedBefore;
    return this;
    }
    public VerificationAttemptsSummaryFetcher setCountry(final String country){
    this.country = country;
    return this;
    }
    public VerificationAttemptsSummaryFetcher setChannel(final VerificationAttemptsSummary.Channels channel){
    this.channel = channel;
    return this;
    }
    public VerificationAttemptsSummaryFetcher setDestinationPrefix(final String destinationPrefix){
    this.destinationPrefix = destinationPrefix;
    return this;
    }

    @Override
    public VerificationAttemptsSummary fetch(final TwilioRestClient client) {
        String path = "/v2/Attempts/Summary";


        Request request = new Request(
            HttpMethod.GET,
            Domains.VERIFY.toString(),
            path
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("VerificationAttemptsSummary fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return VerificationAttemptsSummary.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addQueryParams(final Request request) {
        if (verifyServiceSid != null) {
    
            request.addQueryParam("VerifyServiceSid", verifyServiceSid);
        }
        if (dateCreatedAfter != null) {
            request.addQueryParam("DateCreatedAfter", dateCreatedAfter.toInstant().toString());
        }

        if (dateCreatedBefore != null) {
            request.addQueryParam("DateCreatedBefore", dateCreatedBefore.toInstant().toString());
        }

        if (country != null) {
    
            request.addQueryParam("Country", country);
        }
        if (channel != null) {
    
            request.addQueryParam("Channel", channel.toString());
        }
        if (destinationPrefix != null) {
    
            request.addQueryParam("DestinationPrefix", destinationPrefix);
        }
    }
}

