/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Bulkexports
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.bulkexports.v1;

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
    * Twilio - Bulkexports
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class ExportConfigurationUpdater extends Updater<ExportConfiguration>{
    private String resourceType;
    private Boolean enabled;
    private URI webhookUrl;
    private String webhookMethod;

    public ExportConfigurationUpdater(final String resourceType){
        this.resourceType = resourceType;
    }

    public ExportConfigurationUpdater setEnabled(final Boolean enabled){
        this.enabled = enabled;
        return this;
    }
    public ExportConfigurationUpdater setWebhookUrl(final URI webhookUrl){
        this.webhookUrl = webhookUrl;
        return this;
    }

    public ExportConfigurationUpdater setWebhookUrl(final String webhookUrl){
    this.webhookUrl = Promoter.uriFromString(webhookUrl);
    return this;
    }
    public ExportConfigurationUpdater setWebhookMethod(final String webhookMethod){
        this.webhookMethod = webhookMethod;
        return this;
    }

    @Override
    public ExportConfiguration update(final TwilioRestClient client){
        String path = "/v1/Exports/{ResourceType}/Configuration";

        path = path.replace("{"+"ResourceType"+"}", this.resourceType.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.BULKEXPORTS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("ExportConfiguration update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExportConfiguration.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
    
        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl.toString());
    
        }
        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod);
    
        }
    }
}
