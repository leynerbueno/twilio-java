/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trusthub
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trusthub.v1;

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
public class TrustProducts extends Resource {
    private static final long serialVersionUID = 3469588719072L;

    public static TrustProductsCreator creator(final String friendlyName, final String email, final String policySid){
        return new TrustProductsCreator(friendlyName, email, policySid);
    }

    public static TrustProductsFetcher fetcher(final String sid){
        return new TrustProductsFetcher(sid);
    }

    public static TrustProductsDeleter deleter(final String sid){
        return new TrustProductsDeleter(sid);
    }

    public static TrustProductsReader reader(){
        return new TrustProductsReader();
    }

    public static TrustProductsUpdater updater(final String sid){
        return new TrustProductsUpdater(sid);
    }

    /**
    * Converts a JSON String into a TrustProducts object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProducts object represented by the provided JSON
    */
    public static TrustProducts fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProducts.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a TrustProducts object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return TrustProducts object represented by the provided JSON
    */
    public static TrustProducts fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TrustProducts.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Status {
        DRAFT("draft"),
        PENDING_REVIEW("pending-review"),
        IN_REVIEW("in-review"),
        TWILIO_REJECTED("twilio-rejected"),
        TWILIO_APPROVED("twilio-approved");

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
    private final String policySid;
    private final String friendlyName;
    private final TrustProducts.Status status;
    private final ZonedDateTime validUntil;
    private final String email;
    private final URI statusCallback;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private TrustProducts(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("policy_sid")
        final String policySid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("status")
        final TrustProducts.Status status,

        @JsonProperty("valid_until")
        final String validUntil,

        @JsonProperty("email")
        final String email,

        @JsonProperty("status_callback")
        final URI statusCallback,

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
        this.policySid = policySid;
        this.friendlyName = friendlyName;
        this.status = status;
        this.validUntil = DateConverter.iso8601DateTimeFromString(validUntil);
        this.email = email;
        this.statusCallback = statusCallback;
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
        public final String getPolicySid() {
            return this.policySid;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final TrustProducts.Status getStatus() {
            return this.status;
        }
        public final ZonedDateTime getValidUntil() {
            return this.validUntil;
        }
        public final String getEmail() {
            return this.email;
        }
        public final URI getStatusCallback() {
            return this.statusCallback;
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

        TrustProducts other = (TrustProducts) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(policySid, other.policySid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(status, other.status) &&  Objects.equals(validUntil, other.validUntil) &&  Objects.equals(email, other.email) &&  Objects.equals(statusCallback, other.statusCallback) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, policySid, friendlyName, status, validUntil, email, statusCallback, dateCreated, dateUpdated, url, links);
    }

}

