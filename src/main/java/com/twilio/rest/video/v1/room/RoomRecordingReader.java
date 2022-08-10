/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Video
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.video.v1.room;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;
import java.time.ZonedDateTime;





/*
    * Twilio - Video
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class RoomRecordingReader extends Reader<RoomRecording> {
    private String roomSid;
    private RoomRecording.Status status;
    private String sourceSid;
    private ZonedDateTime dateCreatedAfter;
    private ZonedDateTime dateCreatedBefore;
    private Integer pageSize;

    public RoomRecordingReader(final String roomSid){
        this.roomSid = roomSid;
    }

    public RoomRecordingReader setStatus(final RoomRecording.Status status){
        this.status = status;
        return this;
    }
    public RoomRecordingReader setSourceSid(final String sourceSid){
        this.sourceSid = sourceSid;
        return this;
    }
    public RoomRecordingReader setDateCreatedAfter(final ZonedDateTime dateCreatedAfter){
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }
    public RoomRecordingReader setDateCreatedBefore(final ZonedDateTime dateCreatedBefore){
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }
    public RoomRecordingReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<RoomRecording> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<RoomRecording> firstPage(final TwilioRestClient client) {
        String path = "/v1/Rooms/{RoomSid}/Recordings";
        path = path.replace("{"+"RoomSid"+"}", this.roomSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.VIDEO.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<RoomRecording> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("RoomRecording read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "recordings",
            response.getContent(),
            RoomRecording.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<RoomRecording> previousPage(final Page<RoomRecording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.VIDEO.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<RoomRecording> nextPage(final Page<RoomRecording> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.VIDEO.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<RoomRecording> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (status != null) {
    
            request.addQueryParam("Status", status.toString());
        }
        if (sourceSid != null) {
    
            request.addQueryParam("SourceSid", sourceSid);
        }
        if (dateCreatedAfter != null) {
            request.addQueryParam("DateCreatedAfter", dateCreatedAfter.toInstant().toString());
        }

        if (dateCreatedBefore != null) {
            request.addQueryParam("DateCreatedBefore", dateCreatedBefore.toInstant().toString());
        }

        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

