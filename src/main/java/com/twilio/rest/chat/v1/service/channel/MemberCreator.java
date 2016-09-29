/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.chat.v1.service.channel;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MemberCreator extends Creator<Member> {
    private final String serviceSid;
    private final String channelSid;
    private final String identity;
    private String roleSid;

    /**
     * Construct a new MemberCreator.
     * 
     * @param serviceSid The service_sid
     * @param channelSid The channel_sid
     * @param identity The identity
     */
    public MemberCreator(final String serviceSid, 
                         final String channelSid, 
                         final String identity) {
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
        this.identity = identity;
    }

    /**
     * The role_sid.
     * 
     * @param roleSid The role_sid
     * @return this
     */
    public MemberCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Member
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Member create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            "/v1/Services/" + this.serviceSid + "/Channels/" + this.channelSid + "/Members",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Member creation failed: Unable to connect to server");
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
        
        return Member.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }
        
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
        }
    }
}