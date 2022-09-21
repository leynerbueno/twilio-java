/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Notify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.notify.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
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
public class Service extends Resource {
    private static final long serialVersionUID = 212409990270052L;

    public static ServiceCreator creator(){
        return new ServiceCreator();
    }

    public static ServiceFetcher fetcher(final String sid){
        return new ServiceFetcher(sid);
    }

    public static ServiceDeleter deleter(final String sid){
        return new ServiceDeleter(sid);
    }

    public static ServiceReader reader(){
        return new ServiceReader();
    }

    public static ServiceUpdater updater(final String sid){
        return new ServiceUpdater(sid);
    }

    /**
    * Converts a JSON String into a Service object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Service object represented by the provided JSON
    */
    public static Service fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Service object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Service object represented by the provided JSON
    */
    public static Service fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Service.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String apnCredentialSid;
    private final String gcmCredentialSid;
    private final String fcmCredentialSid;
    private final String messagingServiceSid;
    private final String facebookMessengerPageId;
    private final String defaultApnNotificationProtocolVersion;
    private final String defaultGcmNotificationProtocolVersion;
    private final String defaultFcmNotificationProtocolVersion;
    private final Boolean logEnabled;
    private final URI url;
    private final Map<String, String> links;
    private final String alexaSkillId;
    private final String defaultAlexaNotificationProtocolVersion;
    private final String deliveryCallbackUrl;
    private final Boolean deliveryCallbackEnabled;

    @JsonCreator
    private Service(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("apn_credential_sid")
        final String apnCredentialSid,

        @JsonProperty("gcm_credential_sid")
        final String gcmCredentialSid,

        @JsonProperty("fcm_credential_sid")
        final String fcmCredentialSid,

        @JsonProperty("messaging_service_sid")
        final String messagingServiceSid,

        @JsonProperty("facebook_messenger_page_id")
        final String facebookMessengerPageId,

        @JsonProperty("default_apn_notification_protocol_version")
        final String defaultApnNotificationProtocolVersion,

        @JsonProperty("default_gcm_notification_protocol_version")
        final String defaultGcmNotificationProtocolVersion,

        @JsonProperty("default_fcm_notification_protocol_version")
        final String defaultFcmNotificationProtocolVersion,

        @JsonProperty("log_enabled")
        final Boolean logEnabled,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("links")
        final Map<String, String> links,

        @JsonProperty("alexa_skill_id")
        final String alexaSkillId,

        @JsonProperty("default_alexa_notification_protocol_version")
        final String defaultAlexaNotificationProtocolVersion,

        @JsonProperty("delivery_callback_url")
        final String deliveryCallbackUrl,

        @JsonProperty("delivery_callback_enabled")
        final Boolean deliveryCallbackEnabled
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.apnCredentialSid = apnCredentialSid;
        this.gcmCredentialSid = gcmCredentialSid;
        this.fcmCredentialSid = fcmCredentialSid;
        this.messagingServiceSid = messagingServiceSid;
        this.facebookMessengerPageId = facebookMessengerPageId;
        this.defaultApnNotificationProtocolVersion = defaultApnNotificationProtocolVersion;
        this.defaultGcmNotificationProtocolVersion = defaultGcmNotificationProtocolVersion;
        this.defaultFcmNotificationProtocolVersion = defaultFcmNotificationProtocolVersion;
        this.logEnabled = logEnabled;
        this.url = url;
        this.links = links;
        this.alexaSkillId = alexaSkillId;
        this.defaultAlexaNotificationProtocolVersion = defaultAlexaNotificationProtocolVersion;
        this.deliveryCallbackUrl = deliveryCallbackUrl;
        this.deliveryCallbackEnabled = deliveryCallbackEnabled;
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
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final String getApnCredentialSid() {
            return this.apnCredentialSid;
        }
        public final String getGcmCredentialSid() {
            return this.gcmCredentialSid;
        }
        public final String getFcmCredentialSid() {
            return this.fcmCredentialSid;
        }
        public final String getMessagingServiceSid() {
            return this.messagingServiceSid;
        }
        public final String getFacebookMessengerPageId() {
            return this.facebookMessengerPageId;
        }
        public final String getDefaultApnNotificationProtocolVersion() {
            return this.defaultApnNotificationProtocolVersion;
        }
        public final String getDefaultGcmNotificationProtocolVersion() {
            return this.defaultGcmNotificationProtocolVersion;
        }
        public final String getDefaultFcmNotificationProtocolVersion() {
            return this.defaultFcmNotificationProtocolVersion;
        }
        public final Boolean getLogEnabled() {
            return this.logEnabled;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }
        public final String getAlexaSkillId() {
            return this.alexaSkillId;
        }
        public final String getDefaultAlexaNotificationProtocolVersion() {
            return this.defaultAlexaNotificationProtocolVersion;
        }
        public final String getDeliveryCallbackUrl() {
            return this.deliveryCallbackUrl;
        }
        public final Boolean getDeliveryCallbackEnabled() {
            return this.deliveryCallbackEnabled;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Service other = (Service) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(apnCredentialSid, other.apnCredentialSid) &&  Objects.equals(gcmCredentialSid, other.gcmCredentialSid) &&  Objects.equals(fcmCredentialSid, other.fcmCredentialSid) &&  Objects.equals(messagingServiceSid, other.messagingServiceSid) &&  Objects.equals(facebookMessengerPageId, other.facebookMessengerPageId) &&  Objects.equals(defaultApnNotificationProtocolVersion, other.defaultApnNotificationProtocolVersion) &&  Objects.equals(defaultGcmNotificationProtocolVersion, other.defaultGcmNotificationProtocolVersion) &&  Objects.equals(defaultFcmNotificationProtocolVersion, other.defaultFcmNotificationProtocolVersion) &&  Objects.equals(logEnabled, other.logEnabled) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links) &&  Objects.equals(alexaSkillId, other.alexaSkillId) &&  Objects.equals(defaultAlexaNotificationProtocolVersion, other.defaultAlexaNotificationProtocolVersion) &&  Objects.equals(deliveryCallbackUrl, other.deliveryCallbackUrl) &&  Objects.equals(deliveryCallbackEnabled, other.deliveryCallbackEnabled)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, dateCreated, dateUpdated, apnCredentialSid, gcmCredentialSid, fcmCredentialSid, messagingServiceSid, facebookMessengerPageId, defaultApnNotificationProtocolVersion, defaultGcmNotificationProtocolVersion, defaultFcmNotificationProtocolVersion, logEnabled, url, links, alexaSkillId, defaultAlexaNotificationProtocolVersion, deliveryCallbackUrl, deliveryCallbackEnabled);
    }

}

