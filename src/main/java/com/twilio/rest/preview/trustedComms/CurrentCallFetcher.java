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

package com.twilio.rest.preview.trustedComms;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Preview
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class CurrentCallFetcher extends Fetcher<CurrentCall> {
    private String xXcnamSensitivePhoneNumberFrom;
    private String xXcnamSensitivePhoneNumberTo;

    public CurrentCallFetcher(){
    }

    public CurrentCallFetcher setXXcnamSensitivePhoneNumberFrom(final String xXcnamSensitivePhoneNumberFrom){
    this.xXcnamSensitivePhoneNumberFrom = xXcnamSensitivePhoneNumberFrom;
    return this;
    }
    public CurrentCallFetcher setXXcnamSensitivePhoneNumberTo(final String xXcnamSensitivePhoneNumberTo){
    this.xXcnamSensitivePhoneNumberTo = xXcnamSensitivePhoneNumberTo;
    return this;
    }

    @Override
    public CurrentCall fetch(final TwilioRestClient client) {
        String path = "/TrustedComms/CurrentCall";


        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            path
        );
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("CurrentCall fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return CurrentCall.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addHeaderParams(final Request request) {
        if (xXcnamSensitivePhoneNumberFrom != null) {
            request.addHeaderParam("X-Xcnam-Sensitive-Phone-Number-From", xXcnamSensitivePhoneNumberFrom);

        }
        if (xXcnamSensitivePhoneNumberTo != null) {
            request.addHeaderParam("X-Xcnam-Sensitive-Phone-Number-To", xXcnamSensitivePhoneNumberTo);

        }
    }
}

