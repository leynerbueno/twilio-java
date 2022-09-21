/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.sync.service.synclist;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;


import java.util.Map;



/*
    * Twilio - Preview
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.35.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class SyncListItemUpdater extends Updater<SyncListItem>{
    private String serviceSid;
    private String listSid;
    private Integer index;
    private Map<String, Object> data;
    private String ifMatch;

    public SyncListItemUpdater(final String serviceSid, final String listSid, final Integer index, final Map<String, Object> data){
        this.serviceSid = serviceSid;
        this.listSid = listSid;
        this.index = index;
        this.data = data;
    }

    public SyncListItemUpdater setData(final Map<String, Object> data){
        this.data = data;
        return this;
    }
    public SyncListItemUpdater setIfMatch(final String ifMatch){
        this.ifMatch = ifMatch;
        return this;
    }

    @Override
    public SyncListItem update(final TwilioRestClient client){
        String path = "/Sync/Services/{ServiceSid}/Lists/{ListSid}/Items/{Index}";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"ListSid"+"}", this.listSid.toString());
        path = path.replace("{"+"Index"+"}", this.index.toString());
        path = path.replace("{"+"Data"+"}", this.data.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("SyncListItem update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncListItem.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data",  Converter.mapToJson(data));
    
        }
    }
    private void addHeaderParams(final Request request) {
        if (ifMatch != null) {
            request.addHeaderParam("If-Match", ifMatch);

        }
    }
}
