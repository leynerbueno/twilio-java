/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v1.service;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Ip_messaging
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class UserUpdater extends Updater<User>{
    private String serviceSid;
    private String sid;
    private String roleSid;
    private String attributes;
    private String friendlyName;

    public UserUpdater(final String serviceSid, final String sid){
        this.serviceSid = serviceSid;
        this.sid = sid;
    }

    public UserUpdater setRoleSid(final String roleSid){
        this.roleSid = roleSid;
        return this;
    }
    public UserUpdater setAttributes(final String attributes){
        this.attributes = attributes;
        return this;
    }
    public UserUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }

    @Override
    public User update(final TwilioRestClient client){
        String path = "/v1/Services/{ServiceSid}/Users/{Sid}";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("User update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return User.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
    
        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
    }
}
