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

package com.twilio.rest.api.v2010.account.sip.ipaccesscontrollist;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;





/*
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class IpAddressCreator extends Creator<IpAddress>{
    private String ipAccessControlListSid;
    private String friendlyName;
    private String ipAddress;
    private String accountSid;
    private Integer cidrPrefixLength;

    public IpAddressCreator(final String ipAccessControlListSid, final String friendlyName, final String ipAddress) {
        this.ipAccessControlListSid = ipAccessControlListSid;
        this.friendlyName = friendlyName;
        this.ipAddress = ipAddress;
    }
    public IpAddressCreator(final String accountSid, final String ipAccessControlListSid, final String friendlyName, final String ipAddress) {
        this.accountSid = accountSid;
        this.ipAccessControlListSid = ipAccessControlListSid;
        this.friendlyName = friendlyName;
        this.ipAddress = ipAddress;
    }

    public IpAddressCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public IpAddressCreator setIpAddress(final String ipAddress){
        this.ipAddress = ipAddress;
        return this;
    }
    public IpAddressCreator setCidrPrefixLength(final Integer cidrPrefixLength){
        this.cidrPrefixLength = cidrPrefixLength;
        return this;
    }

    @Override
    public IpAddress create(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/IpAccessControlLists/{IpAccessControlListSid}/IpAddresses.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"IpAccessControlListSid"+"}", this.ipAccessControlListSid.toString());
        path = path.replace("{"+"FriendlyName"+"}", this.friendlyName.toString());
        path = path.replace("{"+"IpAddress"+"}", this.ipAddress.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("IpAddress creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return IpAddress.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (ipAddress != null) {
            request.addPostParam("IpAddress", ipAddress);
    
        }
        if (cidrPrefixLength != null) {
            request.addPostParam("CidrPrefixLength", cidrPrefixLength.toString());
    
        }
    }
}
