/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.usage.record;

import com.google.common.collect.Range;
import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

public class MonthlyReader extends Reader<Monthly> {
    private String accountSid;
    private Monthly.Category category;
    private DateTime absoluteStartDate;
    private Range<DateTime> rangeStartDate;
    private DateTime absoluteEndDate;
    private Range<DateTime> rangeEndDate;

    /**
     * Construct a new MonthlyReader.
     */
    public MonthlyReader() {
    }

    /**
     * Construct a new MonthlyReader.
     * 
     * @param accountSid The account_sid
     */
    public MonthlyReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * The category.
     * 
     * @param category The category
     * @return this
     */
    public MonthlyReader setCategory(final Monthly.Category category) {
        this.category = category;
        return this;
    }

    /**
     * The absolute_start_date.
     * 
     * @param absoluteStartDate The absolute_start_date
     * @return this
     */
    public MonthlyReader setStartDate(final DateTime absoluteStartDate) {
        this.rangeStartDate = null;
        this.absoluteStartDate = absoluteStartDate;
        return this;
    }

    /**
     * The range_start_date.
     * 
     * @param rangeStartDate The range_start_date
     * @return this
     */
    public MonthlyReader setStartDate(final Range<DateTime> rangeStartDate) {
        this.absoluteStartDate = null;
        this.rangeStartDate = rangeStartDate;
        return this;
    }

    /**
     * The absolute_end_date.
     * 
     * @param absoluteEndDate The absolute_end_date
     * @return this
     */
    public MonthlyReader setEndDate(final DateTime absoluteEndDate) {
        this.rangeEndDate = null;
        this.absoluteEndDate = absoluteEndDate;
        return this;
    }

    /**
     * The range_end_date.
     * 
     * @param rangeEndDate The range_end_date
     * @return this
     */
    public MonthlyReader setEndDate(final Range<DateTime> rangeEndDate) {
        this.absoluteEndDate = null;
        this.rangeEndDate = rangeEndDate;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Monthly ResourceSet
     */
    @Override
    public ResourceSet<Monthly> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Monthly ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Monthly> firstPage(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/Usage/Records/Monthly.json",
            client.getRegion()
        );
        
        addQueryParams(request);
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
    public Page<Monthly> nextPage(final Page<Monthly> page, 
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
     * Generate a Page of Monthly Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Monthly> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Monthly read failed: Unable to connect to server");
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
            "usage_records",
            response.getContent(),
            Monthly.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (category != null) {
            request.addQueryParam("Category", category.toString());
        }
        
        if (absoluteStartDate != null) {
            request.addQueryParam("StartDate", absoluteStartDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeStartDate != null) {
            request.addQueryDateRange("StartDate", rangeStartDate);
        }
        
        if (absoluteEndDate != null) {
            request.addQueryParam("EndDate", absoluteEndDate.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeEndDate != null) {
            request.addQueryDateRange("EndDate", rangeEndDate);
        }
        
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}