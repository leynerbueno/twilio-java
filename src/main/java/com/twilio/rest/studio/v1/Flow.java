/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.studio.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Flow extends Resource {
    private static final long serialVersionUID = 8879052558661L;


    public static FlowFetcher fetcher(final String sid){
        return new FlowFetcher(sid);
    }

    public static FlowDeleter deleter(final String sid){
        return new FlowDeleter(sid);
    }

    public static FlowReader reader(){
        return new FlowReader();
    }


    /**
    * Converts a JSON String into a Flow object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Flow object represented by the provided JSON
    */
    public static Flow fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Flow object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Flow object represented by the provided JSON
    */
    public static Flow fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Flow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Status {
        DRAFT("draft"),
        PUBLISHED("published");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final Flow.Status status;
    private final Integer version;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Flow(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("status")
        final Flow.Status status,

        @JsonProperty("version")
        final Integer version,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("links")
        final Map<String, String> links
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.status = status;
        this.version = version;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final Flow.Status getStatus() {
            return this.status;
        }
        public final Integer getVersion() {
            return this.version;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Flow other = (Flow) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(status, other.status) &&  Objects.equals(version, other.version) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, status, version, dateCreated, dateUpdated, url, links);
    }

}

