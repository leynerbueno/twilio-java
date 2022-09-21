/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service;

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
public class User extends Resource {
    private static final long serialVersionUID = 270629422616663L;

    public static UserCreator creator(final String chatServiceSid, final String identity){
        return new UserCreator(chatServiceSid, identity);
    }

    public static UserFetcher fetcher(final String chatServiceSid, final String sid){
        return new UserFetcher(chatServiceSid, sid);
    }

    public static UserDeleter deleter(final String chatServiceSid, final String sid){
        return new UserDeleter(chatServiceSid, sid);
    }

    public static UserReader reader(final String chatServiceSid){
        return new UserReader(chatServiceSid);
    }

    public static UserUpdater updater(final String chatServiceSid, final String sid){
        return new UserUpdater(chatServiceSid, sid);
    }

    /**
    * Converts a JSON String into a User object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return User object represented by the provided JSON
    */
    public static User fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a User object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return User object represented by the provided JSON
    */
    public static User fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum WebhookEnabledType {
        TRUE("true"),
        FALSE("false");

        private final String value;

        private WebhookEnabledType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static WebhookEnabledType forValue(final String value) {
            return Promoter.enumFromString(value, WebhookEnabledType.values());
        }
    }

    private final String sid;
    private final String accountSid;
    private final String chatServiceSid;
    private final String roleSid;
    private final String identity;
    private final String friendlyName;
    private final String attributes;
    private final Boolean isOnline;
    private final Boolean isNotifiable;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private User(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("chat_service_sid")
        final String chatServiceSid,

        @JsonProperty("role_sid")
        final String roleSid,

        @JsonProperty("identity")
        final String identity,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("attributes")
        final String attributes,

        @JsonProperty("is_online")
        final Boolean isOnline,

        @JsonProperty("is_notifiable")
        final Boolean isNotifiable,

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
        this.chatServiceSid = chatServiceSid;
        this.roleSid = roleSid;
        this.identity = identity;
        this.friendlyName = friendlyName;
        this.attributes = attributes;
        this.isOnline = isOnline;
        this.isNotifiable = isNotifiable;
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
        public final String getChatServiceSid() {
            return this.chatServiceSid;
        }
        public final String getRoleSid() {
            return this.roleSid;
        }
        public final String getIdentity() {
            return this.identity;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final String getAttributes() {
            return this.attributes;
        }
        public final Boolean getIsOnline() {
            return this.isOnline;
        }
        public final Boolean getIsNotifiable() {
            return this.isNotifiable;
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

        User other = (User) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(chatServiceSid, other.chatServiceSid) &&  Objects.equals(roleSid, other.roleSid) &&  Objects.equals(identity, other.identity) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(attributes, other.attributes) &&  Objects.equals(isOnline, other.isOnline) &&  Objects.equals(isNotifiable, other.isNotifiable) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, chatServiceSid, roleSid, identity, friendlyName, attributes, isOnline, isNotifiable, dateCreated, dateUpdated, url, links);
    }

}

