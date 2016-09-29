/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.conference;

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

public class ParticipantUpdater extends Updater<Participant> {
    private String accountSid;
    private final String conferenceSid;
    private final String callSid;
    private Boolean muted;
    private Boolean hold;
    private URI holdUrl;
    private HttpMethod holdMethod;

    /**
     * Construct a new ParticipantUpdater.
     * 
     * @param conferenceSid The string that uniquely identifies this conference
     * @param callSid The call_sid
     */
    public ParticipantUpdater(final String conferenceSid, 
                              final String callSid) {
        this.conferenceSid = conferenceSid;
        this.callSid = callSid;
    }

    /**
     * Construct a new ParticipantUpdater.
     * 
     * @param accountSid The account_sid
     * @param conferenceSid The string that uniquely identifies this conference
     * @param callSid The call_sid
     */
    public ParticipantUpdater(final String accountSid, 
                              final String conferenceSid, 
                              final String callSid) {
        this.accountSid = accountSid;
        this.conferenceSid = conferenceSid;
        this.callSid = callSid;
    }

    /**
     * Indicates if the participant should be muted.
     * 
     * @param muted Indicates if the participant should be muted
     * @return this
     */
    public ParticipantUpdater setMuted(final Boolean muted) {
        this.muted = muted;
        return this;
    }

    /**
     * The hold.
     * 
     * @param hold The hold
     * @return this
     */
    public ParticipantUpdater setHold(final Boolean hold) {
        this.hold = hold;
        return this;
    }

    /**
     * The hold_url.
     * 
     * @param holdUrl The hold_url
     * @return this
     */
    public ParticipantUpdater setHoldUrl(final URI holdUrl) {
        this.holdUrl = holdUrl;
        return this;
    }

    /**
     * The hold_url.
     * 
     * @param holdUrl The hold_url
     * @return this
     */
    public ParticipantUpdater setHoldUrl(final String holdUrl) {
        return setHoldUrl(Promoter.uriFromString(holdUrl));
    }

    /**
     * The hold_method.
     * 
     * @param holdMethod The hold_method
     * @return this
     */
    public ParticipantUpdater setHoldMethod(final HttpMethod holdMethod) {
        this.holdMethod = holdMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Participant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Participant update(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Conferences/" + this.conferenceSid + "/Participants/" + this.callSid + ".json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Participant update failed: Unable to connect to server");
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
        
        return Participant.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (muted != null) {
            request.addPostParam("Muted", muted.toString());
        }
        
        if (hold != null) {
            request.addPostParam("Hold", hold.toString());
        }
        
        if (holdUrl != null) {
            request.addPostParam("HoldUrl", holdUrl.toString());
        }
        
        if (holdMethod != null) {
            request.addPostParam("HoldMethod", holdMethod.toString());
        }
    }
}