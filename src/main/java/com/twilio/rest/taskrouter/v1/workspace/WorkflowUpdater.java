/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace;

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
    * Twilio - Taskrouter
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.35.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class WorkflowUpdater extends Updater<Workflow>{
    private String workspaceSid;
    private String sid;
    private String friendlyName;
    private URI assignmentCallbackUrl;
    private URI fallbackAssignmentCallbackUrl;
    private String configuration;
    private Integer taskReservationTimeout;
    private String reEvaluateTasks;

    public WorkflowUpdater(final String workspaceSid, final String sid){
        this.workspaceSid = workspaceSid;
        this.sid = sid;
    }

    public WorkflowUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public WorkflowUpdater setAssignmentCallbackUrl(final URI assignmentCallbackUrl){
        this.assignmentCallbackUrl = assignmentCallbackUrl;
        return this;
    }

    public WorkflowUpdater setAssignmentCallbackUrl(final String assignmentCallbackUrl){
    this.assignmentCallbackUrl = Promoter.uriFromString(assignmentCallbackUrl);
    return this;
    }
    public WorkflowUpdater setFallbackAssignmentCallbackUrl(final URI fallbackAssignmentCallbackUrl){
        this.fallbackAssignmentCallbackUrl = fallbackAssignmentCallbackUrl;
        return this;
    }

    public WorkflowUpdater setFallbackAssignmentCallbackUrl(final String fallbackAssignmentCallbackUrl){
    this.fallbackAssignmentCallbackUrl = Promoter.uriFromString(fallbackAssignmentCallbackUrl);
    return this;
    }
    public WorkflowUpdater setConfiguration(final String configuration){
        this.configuration = configuration;
        return this;
    }
    public WorkflowUpdater setTaskReservationTimeout(final Integer taskReservationTimeout){
        this.taskReservationTimeout = taskReservationTimeout;
        return this;
    }
    public WorkflowUpdater setReEvaluateTasks(final String reEvaluateTasks){
        this.reEvaluateTasks = reEvaluateTasks;
        return this;
    }

    @Override
    public Workflow update(final TwilioRestClient client){
        String path = "/v1/Workspaces/{WorkspaceSid}/Workflows/{Sid}";

        path = path.replace("{"+"WorkspaceSid"+"}", this.workspaceSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Workflow update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Workflow.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (assignmentCallbackUrl != null) {
            request.addPostParam("AssignmentCallbackUrl", assignmentCallbackUrl.toString());
    
        }
        if (fallbackAssignmentCallbackUrl != null) {
            request.addPostParam("FallbackAssignmentCallbackUrl", fallbackAssignmentCallbackUrl.toString());
    
        }
        if (configuration != null) {
            request.addPostParam("Configuration", configuration);
    
        }
        if (taskReservationTimeout != null) {
            request.addPostParam("TaskReservationTimeout", taskReservationTimeout.toString());
    
        }
        if (reEvaluateTasks != null) {
            request.addPostParam("ReEvaluateTasks", reEvaluateTasks);
    
        }
    }
}
