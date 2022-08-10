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

package com.twilio.rest.verify.v2.service;

import com.twilio.base.Creator;
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
import com.twilio.converter.Converter;

import java.util.Map;




/*
    * Twilio - Verify
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class VerificationCreator extends Creator<Verification>{
    private String serviceSid;
    private String to;
    private String channel;
    private String customFriendlyName;
    private String customMessage;
    private String sendDigits;
    private String locale;
    private String customCode;
    private String amount;
    private String payee;
    private Map<String, Object> rateLimits;
    private Map<String, Object> channelConfiguration;
    private String appHash;
    private String templateSid;
    private String templateCustomSubstitutions;

    public VerificationCreator(final String serviceSid, final String to, final String channel) {
        this.serviceSid = serviceSid;
        this.to = to;
        this.channel = channel;
    }

    public VerificationCreator setTo(final String to){
        this.to = to;
        return this;
    }
    public VerificationCreator setChannel(final String channel){
        this.channel = channel;
        return this;
    }
    public VerificationCreator setCustomFriendlyName(final String customFriendlyName){
        this.customFriendlyName = customFriendlyName;
        return this;
    }
    public VerificationCreator setCustomMessage(final String customMessage){
        this.customMessage = customMessage;
        return this;
    }
    public VerificationCreator setSendDigits(final String sendDigits){
        this.sendDigits = sendDigits;
        return this;
    }
    public VerificationCreator setLocale(final String locale){
        this.locale = locale;
        return this;
    }
    public VerificationCreator setCustomCode(final String customCode){
        this.customCode = customCode;
        return this;
    }
    public VerificationCreator setAmount(final String amount){
        this.amount = amount;
        return this;
    }
    public VerificationCreator setPayee(final String payee){
        this.payee = payee;
        return this;
    }
    public VerificationCreator setRateLimits(final Map<String, Object> rateLimits){
        this.rateLimits = rateLimits;
        return this;
    }
    public VerificationCreator setChannelConfiguration(final Map<String, Object> channelConfiguration){
        this.channelConfiguration = channelConfiguration;
        return this;
    }
    public VerificationCreator setAppHash(final String appHash){
        this.appHash = appHash;
        return this;
    }
    public VerificationCreator setTemplateSid(final String templateSid){
        this.templateSid = templateSid;
        return this;
    }
    public VerificationCreator setTemplateCustomSubstitutions(final String templateCustomSubstitutions){
        this.templateCustomSubstitutions = templateCustomSubstitutions;
        return this;
    }

    @Override
    public Verification create(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/Verifications";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"To"+"}", this.to.toString());
        path = path.replace("{"+"Channel"+"}", this.channel.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Verification creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Verification.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to);
    
        }
        if (channel != null) {
            request.addPostParam("Channel", channel);
    
        }
        if (customFriendlyName != null) {
            request.addPostParam("CustomFriendlyName", customFriendlyName);
    
        }
        if (customMessage != null) {
            request.addPostParam("CustomMessage", customMessage);
    
        }
        if (sendDigits != null) {
            request.addPostParam("SendDigits", sendDigits);
    
        }
        if (locale != null) {
            request.addPostParam("Locale", locale);
    
        }
        if (customCode != null) {
            request.addPostParam("CustomCode", customCode);
    
        }
        if (amount != null) {
            request.addPostParam("Amount", amount);
    
        }
        if (payee != null) {
            request.addPostParam("Payee", payee);
    
        }
        if (rateLimits != null) {
            request.addPostParam("RateLimits",  Converter.mapToJson(rateLimits));
    
        }
        if (channelConfiguration != null) {
            request.addPostParam("ChannelConfiguration",  Converter.mapToJson(channelConfiguration));
    
        }
        if (appHash != null) {
            request.addPostParam("AppHash", appHash);
    
        }
        if (templateSid != null) {
            request.addPostParam("TemplateSid", templateSid);
    
        }
        if (templateCustomSubstitutions != null) {
            request.addPostParam("TemplateCustomSubstitutions", templateCustomSubstitutions);
    
        }
    }
}
