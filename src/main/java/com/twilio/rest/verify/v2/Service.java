/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2;

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
    private static final long serialVersionUID = 9486445456747L;

    public static ServiceCreator creator(final String friendlyName){
        return new ServiceCreator(friendlyName);
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
    private final Integer codeLength;
    private final Boolean lookupEnabled;
    private final Boolean psd2Enabled;
    private final Boolean skipSmsToLandlines;
    private final Boolean dtmfInputRequired;
    private final String ttsName;
    private final Boolean doNotShareWarningEnabled;
    private final Boolean customCodeEnabled;
    private final Map<String, Object> push;
    private final Map<String, Object> totp;
    private final String defaultTemplateSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Service(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("code_length")
        final Integer codeLength,

        @JsonProperty("lookup_enabled")
        final Boolean lookupEnabled,

        @JsonProperty("psd2_enabled")
        final Boolean psd2Enabled,

        @JsonProperty("skip_sms_to_landlines")
        final Boolean skipSmsToLandlines,

        @JsonProperty("dtmf_input_required")
        final Boolean dtmfInputRequired,

        @JsonProperty("tts_name")
        final String ttsName,

        @JsonProperty("do_not_share_warning_enabled")
        final Boolean doNotShareWarningEnabled,

        @JsonProperty("custom_code_enabled")
        final Boolean customCodeEnabled,

        @JsonProperty("push")
        final Map<String, Object> push,

        @JsonProperty("totp")
        final Map<String, Object> totp,

        @JsonProperty("default_template_sid")
        final String defaultTemplateSid,

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
        this.codeLength = codeLength;
        this.lookupEnabled = lookupEnabled;
        this.psd2Enabled = psd2Enabled;
        this.skipSmsToLandlines = skipSmsToLandlines;
        this.dtmfInputRequired = dtmfInputRequired;
        this.ttsName = ttsName;
        this.doNotShareWarningEnabled = doNotShareWarningEnabled;
        this.customCodeEnabled = customCodeEnabled;
        this.push = push;
        this.totp = totp;
        this.defaultTemplateSid = defaultTemplateSid;
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
        public final Integer getCodeLength() {
            return this.codeLength;
        }
        public final Boolean getLookupEnabled() {
            return this.lookupEnabled;
        }
        public final Boolean getPsd2Enabled() {
            return this.psd2Enabled;
        }
        public final Boolean getSkipSmsToLandlines() {
            return this.skipSmsToLandlines;
        }
        public final Boolean getDtmfInputRequired() {
            return this.dtmfInputRequired;
        }
        public final String getTtsName() {
            return this.ttsName;
        }
        public final Boolean getDoNotShareWarningEnabled() {
            return this.doNotShareWarningEnabled;
        }
        public final Boolean getCustomCodeEnabled() {
            return this.customCodeEnabled;
        }
        public final Map<String, Object> getPush() {
            return this.push;
        }
        public final Map<String, Object> getTotp() {
            return this.totp;
        }
        public final String getDefaultTemplateSid() {
            return this.defaultTemplateSid;
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

        Service other = (Service) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(codeLength, other.codeLength) &&  Objects.equals(lookupEnabled, other.lookupEnabled) &&  Objects.equals(psd2Enabled, other.psd2Enabled) &&  Objects.equals(skipSmsToLandlines, other.skipSmsToLandlines) &&  Objects.equals(dtmfInputRequired, other.dtmfInputRequired) &&  Objects.equals(ttsName, other.ttsName) &&  Objects.equals(doNotShareWarningEnabled, other.doNotShareWarningEnabled) &&  Objects.equals(customCodeEnabled, other.customCodeEnabled) &&  Objects.equals(push, other.push) &&  Objects.equals(totp, other.totp) &&  Objects.equals(defaultTemplateSid, other.defaultTemplateSid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, codeLength, lookupEnabled, psd2Enabled, skipSmsToLandlines, dtmfInputRequired, ttsName, doNotShareWarningEnabled, customCodeEnabled, push, totp, defaultTemplateSid, dateCreated, dateUpdated, url, links);
    }

}

