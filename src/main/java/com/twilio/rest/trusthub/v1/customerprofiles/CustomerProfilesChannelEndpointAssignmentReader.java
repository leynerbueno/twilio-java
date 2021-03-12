/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trusthub.v1.customerprofiles;

import com.twilio.base.Page;
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

public class CustomerProfilesChannelEndpointAssignmentReader extends Reader<CustomerProfilesChannelEndpointAssignment> {
    private final String pathCustomerProfileSid;
    private String channelEndpointSid;
    private String channelEndpointSids;

    /**
     * Construct a new CustomerProfilesChannelEndpointAssignmentReader.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     */
    public CustomerProfilesChannelEndpointAssignmentReader(final String pathCustomerProfileSid) {
        this.pathCustomerProfileSid = pathCustomerProfileSid;
    }

    /**
     * The SID of an channel endpoint.
     *
     * @param channelEndpointSid The sid of an channel endpoint
     * @return this
     */
    public CustomerProfilesChannelEndpointAssignmentReader setChannelEndpointSid(final String channelEndpointSid) {
        this.channelEndpointSid = channelEndpointSid;
        return this;
    }

    /**
     * comma separated list of channel endpoint sids.
     *
     * @param channelEndpointSids comma separated list of channel endpoint sids
     * @return this
     */
    public CustomerProfilesChannelEndpointAssignmentReader setChannelEndpointSids(final String channelEndpointSids) {
        this.channelEndpointSids = channelEndpointSids;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesChannelEndpointAssignment ResourceSet
     */
    @Override
    public ResourceSet<CustomerProfilesChannelEndpointAssignment> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesChannelEndpointAssignment ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<CustomerProfilesChannelEndpointAssignment> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUSTHUB.toString(),
            "/v1/CustomerProfiles/" + this.pathCustomerProfileSid + "/ChannelEndpointAssignments"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return CustomerProfilesChannelEndpointAssignment ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<CustomerProfilesChannelEndpointAssignment> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<CustomerProfilesChannelEndpointAssignment> nextPage(final Page<CustomerProfilesChannelEndpointAssignment> page,
                                                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<CustomerProfilesChannelEndpointAssignment> previousPage(final Page<CustomerProfilesChannelEndpointAssignment> page,
                                                                        final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TRUSTHUB.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of CustomerProfilesChannelEndpointAssignment Resources for a
     * given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<CustomerProfilesChannelEndpointAssignment> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("CustomerProfilesChannelEndpointAssignment read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "results",
            response.getContent(),
            CustomerProfilesChannelEndpointAssignment.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (channelEndpointSid != null) {
            request.addQueryParam("ChannelEndpointSid", channelEndpointSid);
        }

        if (channelEndpointSids != null) {
            request.addQueryParam("ChannelEndpointSids", channelEndpointSids);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}