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

package com.twilio.rest.preview.hostedNumbers;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;


import java.util.List;



/*
    * Twilio - Preview
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class HostedNumberOrderUpdater extends Updater<HostedNumberOrder>{
    private String sid;
    private String friendlyName;
    private String uniqueName;
    private String email;
    private List<String> ccEmails;
    private HostedNumberOrder.Status status;
    private String verificationCode;
    private HostedNumberOrder.VerificationType verificationType;
    private String verificationDocumentSid;
    private String extension;
    private Integer callDelay;

    public HostedNumberOrderUpdater(final String sid){
        this.sid = sid;
    }

    public HostedNumberOrderUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public HostedNumberOrderUpdater setUniqueName(final String uniqueName){
        this.uniqueName = uniqueName;
        return this;
    }
    public HostedNumberOrderUpdater setEmail(final String email){
        this.email = email;
        return this;
    }
    public HostedNumberOrderUpdater setCcEmails(final List<String> ccEmails){
        this.ccEmails = ccEmails;
        return this;
    }
    public HostedNumberOrderUpdater setStatus(final HostedNumberOrder.Status status){
        this.status = status;
        return this;
    }
    public HostedNumberOrderUpdater setVerificationCode(final String verificationCode){
        this.verificationCode = verificationCode;
        return this;
    }
    public HostedNumberOrderUpdater setVerificationType(final HostedNumberOrder.VerificationType verificationType){
        this.verificationType = verificationType;
        return this;
    }
    public HostedNumberOrderUpdater setVerificationDocumentSid(final String verificationDocumentSid){
        this.verificationDocumentSid = verificationDocumentSid;
        return this;
    }
    public HostedNumberOrderUpdater setExtension(final String extension){
        this.extension = extension;
        return this;
    }
    public HostedNumberOrderUpdater setCallDelay(final Integer callDelay){
        this.callDelay = callDelay;
        return this;
    }

    @Override
    public HostedNumberOrder update(final TwilioRestClient client){
        String path = "/HostedNumbers/HostedNumberOrders/{Sid}";

        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("HostedNumberOrder update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return HostedNumberOrder.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
    
        }
        if (email != null) {
            request.addPostParam("Email", email);
    
        }
        if (ccEmails != null) {
            for (String prop : ccEmails) {
                request.addPostParam("CcEmails", prop);
            }
    
        }
        if (status != null) {
            request.addPostParam("Status", status.toString());
    
        }
        if (verificationCode != null) {
            request.addPostParam("VerificationCode", verificationCode);
    
        }
        if (verificationType != null) {
            request.addPostParam("VerificationType", verificationType.toString());
    
        }
        if (verificationDocumentSid != null) {
            request.addPostParam("VerificationDocumentSid", verificationDocumentSid);
    
        }
        if (extension != null) {
            request.addPostParam("Extension", extension);
    
        }
        if (callDelay != null) {
            request.addPostParam("CallDelay", callDelay.toString());
    
        }
    }
}
