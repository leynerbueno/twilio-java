/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Supersim
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.supersim.v1;

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
    * Twilio - Supersim
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.33.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class UsageRecordReader extends Reader<UsageRecord> {
    private String sim;
    private String fleet;
    private String network;
    private String isoCountry;
    private UsageRecord.Group group;
    private UsageRecord.Granularity granularity;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private Integer pageSize;

    public UsageRecordReader(){
    }

    public UsageRecordReader setSim(final String sim){
        this.sim = sim;
        return this;
    }
    public UsageRecordReader setFleet(final String fleet){
        this.fleet = fleet;
        return this;
    }
    public UsageRecordReader setNetwork(final String network){
        this.network = network;
        return this;
    }
    public UsageRecordReader setIsoCountry(final String isoCountry){
        this.isoCountry = isoCountry;
        return this;
    }
    public UsageRecordReader setGroup(final UsageRecord.Group group){
        this.group = group;
        return this;
    }
    public UsageRecordReader setGranularity(final UsageRecord.Granularity granularity){
        this.granularity = granularity;
        return this;
    }
    public UsageRecordReader setStartTime(final ZonedDateTime startTime){
        this.startTime = startTime;
        return this;
    }
    public UsageRecordReader setEndTime(final ZonedDateTime endTime){
        this.endTime = endTime;
        return this;
    }
    public UsageRecordReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<UsageRecord> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<UsageRecord> firstPage(final TwilioRestClient client) {
        String path = "/v1/UsageRecords";

        Request request = new Request(
            HttpMethod.GET,
            Domains.SUPERSIM.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<UsageRecord> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("UsageRecord read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "usage_records",
            response.getContent(),
            UsageRecord.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<UsageRecord> previousPage(final Page<UsageRecord> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.SUPERSIM.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<UsageRecord> nextPage(final Page<UsageRecord> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.SUPERSIM.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<UsageRecord> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (sim != null) {
    
            request.addQueryParam("Sim", sim);
        }
        if (fleet != null) {
    
            request.addQueryParam("Fleet", fleet);
        }
        if (network != null) {
    
            request.addQueryParam("Network", network);
        }
        if (isoCountry != null) {
    
            request.addQueryParam("IsoCountry", isoCountry);
        }
        if (group != null) {
    
            request.addQueryParam("Group", group.toString());
        }
        if (granularity != null) {
    
            request.addQueryParam("Granularity", granularity.toString());
        }
        if (startTime != null) {
            request.addQueryParam("StartTime", startTime.toInstant().toString());
        }

        if (endTime != null) {
            request.addQueryParam("EndTime", endTime.toInstant().toString());
        }

        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

