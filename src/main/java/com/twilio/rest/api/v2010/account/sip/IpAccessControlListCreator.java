/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class IpAccessControlListCreator extends Creator<IpAccessControlList> {
    private String pathAccountSid;
    private final String friendlyName;

    /**
     * Construct a new IpAccessControlListCreator.
     * 
     * @param friendlyName A human readable description of this resource
     */
    public IpAccessControlListCreator(final String friendlyName) {
        this.friendlyName = friendlyName;
    }

    /**
     * Construct a new IpAccessControlListCreator.
     * 
     * @param pathAccountSid The unique sid that identifies this account
     * @param friendlyName A human readable description of this resource
     */
    public IpAccessControlListCreator(final String pathAccountSid, 
                                      final String friendlyName) {
        this.pathAccountSid = pathAccountSid;
        this.friendlyName = friendlyName;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created IpAccessControlList
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IpAccessControlList create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/IpAccessControlLists.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAccessControlList creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return IpAccessControlList.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
    }
}