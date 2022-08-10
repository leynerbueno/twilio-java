/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Sync
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.sync.v1.service.syncmap;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




/*
    * Twilio - Sync
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class SyncMapItemDeleter extends Deleter<SyncMapItem> {
    private String serviceSid;
    private String mapSid;
    private String key;
    private String ifMatch;

    public SyncMapItemDeleter(final String serviceSid, final String mapSid, final String key){
        this.serviceSid = serviceSid;
        this.mapSid = mapSid;
        this.key = key;
    }

    public SyncMapItemDeleter setIfMatch(final String ifMatch){
    this.ifMatch = ifMatch;
    return this;
    }

    @Override
    public boolean delete(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Maps/{MapSid}/Items/{Key}";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"MapSid"+"}", this.mapSid.toString());
        path = path.replace("{"+"Key"+"}", this.key.toString());

        Request request = new Request(
            HttpMethod.DELETE,
            Domains.SYNC.toString(),
            path
        );
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncMapItem delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }
        return response.getStatusCode() == 204;
    }
    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);

        }
    }
}

