/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip.domain;

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

public class IpAccessControlListMappingReader extends Reader<IpAccessControlListMapping> {
    private String pathAccountSid;
    private final String pathDomainSid;

    /**
     * Construct a new IpAccessControlListMappingReader.
     * 
     * @param pathDomainSid A string that uniquely identifies the SIP Domain
     */
    public IpAccessControlListMappingReader(final String pathDomainSid) {
        this.pathDomainSid = pathDomainSid;
    }

    /**
     * Construct a new IpAccessControlListMappingReader.
     * 
     * @param pathAccountSid The unique id of the Account that is responsible for
     *                       this resource.
     * @param pathDomainSid A string that uniquely identifies the SIP Domain
     */
    public IpAccessControlListMappingReader(final String pathAccountSid, 
                                            final String pathDomainSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathDomainSid = pathDomainSid;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return IpAccessControlListMapping ResourceSet
     */
    @Override
    public ResourceSet<IpAccessControlListMapping> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return IpAccessControlListMapping ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<IpAccessControlListMapping> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/Domains/" + this.pathDomainSid + "/IpAccessControlListMappings.json",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return IpAccessControlListMapping ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<IpAccessControlListMapping> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
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
    public Page<IpAccessControlListMapping> nextPage(final Page<IpAccessControlListMapping> page, 
                                                     final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
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
    public Page<IpAccessControlListMapping> previousPage(final Page<IpAccessControlListMapping> page, 
                                                         final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of IpAccessControlListMapping Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<IpAccessControlListMapping> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAccessControlListMapping read failed: Unable to connect to server");
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

        return Page.fromJson(
            "ip_access_control_list_mappings",
            response.getContent(),
            IpAccessControlListMapping.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}