/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;




/*
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ConferenceUpdater extends Updater<Conference>{
    private String sid;
    private String accountSid;
    private Conference.UpdateStatus status;
    private URI announceUrl;
    private HttpMethod announceMethod;

    public ConferenceUpdater(final String sid){
        this.sid = sid;
    }
    public ConferenceUpdater(final String accountSid, final String sid){
        this.accountSid = accountSid;
        this.sid = sid;
    }

    public ConferenceUpdater setStatus(final Conference.UpdateStatus status){
        this.status = status;
        return this;
    }
    public ConferenceUpdater setAnnounceUrl(final URI announceUrl){
        this.announceUrl = announceUrl;
        return this;
    }

    public ConferenceUpdater setAnnounceUrl(final String announceUrl){
    this.announceUrl = Promoter.uriFromString(announceUrl);
    return this;
    }
    public ConferenceUpdater setAnnounceMethod(final HttpMethod announceMethod){
        this.announceMethod = announceMethod;
        return this;
    }

    @Override
    public Conference update(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/Conferences/{Sid}.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Conference update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Conference.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());
    
        }
        if (announceUrl != null) {
            request.addPostParam("AnnounceUrl", announceUrl.toString());
    
        }
        if (announceMethod != null) {
            request.addPostParam("AnnounceMethod", announceMethod.toString());
    
        }
    }
}
