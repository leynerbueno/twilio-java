/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WorkerCreator extends Creator<Worker> {
    private final String workspaceSid;
    private final String friendlyName;
    private String activitySid;
    private String attributes;

    /**
     * Construct a new WorkerCreator.
     * 
     * @param workspaceSid The workspace_sid
     * @param friendlyName The friendly_name
     */
    public WorkerCreator(final String workspaceSid, 
                         final String friendlyName) {
        this.workspaceSid = workspaceSid;
        this.friendlyName = friendlyName;
    }

    /**
     * The activity_sid.
     * 
     * @param activitySid The activity_sid
     * @return this
     */
    public WorkerCreator setActivitySid(final String activitySid) {
        this.activitySid = activitySid;
        return this;
    }

    /**
     * The attributes.
     * 
     * @param attributes The attributes
     * @return this
     */
    public WorkerCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Worker
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Worker create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.workspaceSid + "/Workers",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Worker creation failed: Unable to connect to server");
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
        
        return Worker.fromJson(response.getStream(), client.getObjectMapper());
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
        
        if (activitySid != null) {
            request.addPostParam("ActivitySid", activitySid);
        }
        
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
    }
}