/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class SubscriptionTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.EVENTS.toString(),
                                          "/v1/Subscriptions");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Subscription.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"subscriptions\": [],\"meta\": {\"page\": 0,\"page_size\": 10,\"first_page_url\": \"https://events.twilio.com/v1/Subscriptions?PageSize=10&Page=0\",\"previous_page_url\": null,\"url\": \"https://events.twilio.com/v1/Subscriptions?PageSize=10&Page=0\",\"next_page_url\": null,\"key\": \"subscriptions\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Subscription.reader().read());
    }

    @Test
    public void testReadResultsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"subscriptions\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:01:33Z\",\"sid\": \"DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sink_sid\": \"DGaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"description\": \"A subscription\",\"url\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"subscribed_events\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/SubscribedEvents\"}},{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:01:33Z\",\"sid\": \"DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\",\"sink_sid\": \"DGaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"description\": \"Another subscription\",\"url\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\",\"links\": {\"subscribed_events\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab/SubscribedEvents\"}}],\"meta\": {\"page\": 0,\"page_size\": 20,\"first_page_url\": \"https://events.twilio.com/v1/Subscriptions?PageSize=20&Page=0\",\"previous_page_url\": null,\"url\": \"https://events.twilio.com/v1/Subscriptions?PageSize=20&Page=0\",\"next_page_url\": null,\"key\": \"subscriptions\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Subscription.reader().read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.EVENTS.toString(),
                                          "/v1/Subscriptions/DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Subscription.fetcher("DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:01:33Z\",\"sid\": \"DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sink_sid\": \"DGaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"description\": \"A subscription\",\"url\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"subscribed_events\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/SubscribedEvents\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Subscription.fetcher("DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.EVENTS.toString(),
                                          "/v1/Subscriptions");
            request.addPostParam("Description", serialize("description"));
            request.addPostParam("SinkSid", serialize("DGXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
            request.addPostParam("Types", serialize(Promoter.listOfOne((java.util.Map<String, Object>)new java.util.HashMap<String, Object>())));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Subscription.creator("description", "DGXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", Promoter.listOfOne((java.util.Map<String, Object>)new java.util.HashMap<String, Object>())).create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:01:33Z\",\"sid\": \"DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sink_sid\": \"DGaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"description\": \"A subscription\",\"url\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"subscribed_events\": \"https://events.twilio.com/v1/Subscriptions/DFaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/SubscribedEvents\"}}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Subscription.creator("description", "DGXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", Promoter.listOfOne((java.util.Map<String, Object>)new java.util.HashMap<String, Object>())).create();
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.EVENTS.toString(),
                                          "/v1/Subscriptions/DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Subscription.deleter("DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Subscription.deleter("DFXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }
}