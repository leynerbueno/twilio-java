/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.incomingphonenumber;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.type.PhoneNumberCapabilities;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Local extends Resource {
    private static final long serialVersionUID = 40781203062485L;

    public enum AddressRequirement {
        NONE("none"),
        ANY("any"),
        LOCAL("local"),
        FOREIGN("foreign");
    
        private final String value;
        
        private AddressRequirement(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a AddressRequirement from a string.
         * @param value string value
         * @return generated AddressRequirement
         */
        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return AddressRequirement.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a LocalReader to execute read.
     * 
     * @param ownerAccountSid The owner_account_sid
     * @return LocalReader capable of executing the read
     */
    public static LocalReader reader(final String ownerAccountSid) {
        return new LocalReader(ownerAccountSid);
    }

    /**
     * Create a LocalReader to execute read.
     * 
     * @return LocalReader capable of executing the read
     */
    public static LocalReader reader() {
        return new LocalReader();
    }

    /**
     * Create a LocalCreator to execute create.
     * 
     * @param ownerAccountSid The owner_account_sid
     * @param phoneNumber The phone_number
     * @return LocalCreator capable of executing the create
     */
    public static LocalCreator creator(final String ownerAccountSid, 
                                       final com.twilio.type.PhoneNumber phoneNumber) {
        return new LocalCreator(ownerAccountSid, phoneNumber);
    }

    /**
     * Create a LocalCreator to execute create.
     * 
     * @param phoneNumber The phone_number
     * @return LocalCreator capable of executing the create
     */
    public static LocalCreator creator(final com.twilio.type.PhoneNumber phoneNumber) {
        return new LocalCreator(phoneNumber);
    }

    /**
     * Converts a JSON String into a Local object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Local object represented by the provided JSON
     */
    public static Local fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Local.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Local object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Local object represented by the provided JSON
     */
    public static Local fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Local.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Local.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final PhoneNumberCapabilities capabilities;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String sid;
    private final String smsApplicationSid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String uri;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;

    @JsonCreator
    private Local(@JsonProperty("account_sid")
                  final String accountSid, 
                  @JsonProperty("address_requirements")
                  final Local.AddressRequirement addressRequirements, 
                  @JsonProperty("api_version")
                  final String apiVersion, 
                  @JsonProperty("beta")
                  final Boolean beta, 
                  @JsonProperty("capabilities")
                  final PhoneNumberCapabilities capabilities, 
                  @JsonProperty("date_created")
                  final String dateCreated, 
                  @JsonProperty("date_updated")
                  final String dateUpdated, 
                  @JsonProperty("friendly_name")
                  final String friendlyName, 
                  @JsonProperty("phone_number")
                  final com.twilio.type.PhoneNumber phoneNumber, 
                  @JsonProperty("sid")
                  final String sid, 
                  @JsonProperty("sms_application_sid")
                  final String smsApplicationSid, 
                  @JsonProperty("sms_fallback_method")
                  final HttpMethod smsFallbackMethod, 
                  @JsonProperty("sms_fallback_url")
                  final URI smsFallbackUrl, 
                  @JsonProperty("sms_method")
                  final HttpMethod smsMethod, 
                  @JsonProperty("sms_url")
                  final URI smsUrl, 
                  @JsonProperty("status_callback")
                  final URI statusCallback, 
                  @JsonProperty("status_callback_method")
                  final HttpMethod statusCallbackMethod, 
                  @JsonProperty("uri")
                  final String uri, 
                  @JsonProperty("voice_application_sid")
                  final String voiceApplicationSid, 
                  @JsonProperty("voice_caller_id_lookup")
                  final Boolean voiceCallerIdLookup, 
                  @JsonProperty("voice_fallback_method")
                  final HttpMethod voiceFallbackMethod, 
                  @JsonProperty("voice_fallback_url")
                  final URI voiceFallbackUrl, 
                  @JsonProperty("voice_method")
                  final HttpMethod voiceMethod, 
                  @JsonProperty("voice_url")
                  final URI voiceUrl) {
        this.accountSid = accountSid;
        this.addressRequirements = addressRequirements;
        this.apiVersion = apiVersion;
        this.beta = beta;
        this.capabilities = capabilities;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.phoneNumber = phoneNumber;
        this.sid = sid;
        this.smsApplicationSid = smsApplicationSid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.uri = uri;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The address_requirements.
     * 
     * @return The address_requirements
     */
    public final Local.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    /**
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The beta.
     * 
     * @return The beta
     */
    public final Boolean getBeta() {
        return this.beta;
    }

    /**
     * Returns The The capabilities.
     * 
     * @return The capabilities
     */
    public final PhoneNumberCapabilities getCapabilities() {
        return this.capabilities;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The phone_number.
     * 
     * @return The phone_number
     */
    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The sms_application_sid.
     * 
     * @return The sms_application_sid
     */
    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    /**
     * Returns The The sms_fallback_method.
     * 
     * @return The sms_fallback_method
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * Returns The The sms_fallback_url.
     * 
     * @return The sms_fallback_url
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * Returns The The sms_method.
     * 
     * @return The sms_method
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * Returns The The sms_url.
     * 
     * @return The sms_url
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * Returns The The status_callback.
     * 
     * @return The status_callback
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * Returns The The status_callback_method.
     * 
     * @return The status_callback_method
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The voice_application_sid.
     * 
     * @return The voice_application_sid
     */
    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    /**
     * Returns The The voice_caller_id_lookup.
     * 
     * @return The voice_caller_id_lookup
     */
    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    /**
     * Returns The The voice_fallback_method.
     * 
     * @return The voice_fallback_method
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * Returns The The voice_fallback_url.
     * 
     * @return The voice_fallback_url
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * Returns The The voice_method.
     * 
     * @return The voice_method
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    /**
     * Returns The The voice_url.
     * 
     * @return The voice_url
     */
    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Local other = (Local) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(addressRequirements, other.addressRequirements) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(beta, other.beta) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(smsApplicationSid, other.smsApplicationSid) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(statusCallback, other.statusCallback) && 
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(voiceApplicationSid, other.voiceApplicationSid) && 
               Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup) && 
               Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) && 
               Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) && 
               Objects.equals(voiceMethod, other.voiceMethod) && 
               Objects.equals(voiceUrl, other.voiceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            addressRequirements,
                            apiVersion,
                            beta,
                            capabilities,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            phoneNumber,
                            sid,
                            smsApplicationSid,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            statusCallback,
                            statusCallbackMethod,
                            uri,
                            voiceApplicationSid,
                            voiceCallerIdLookup,
                            voiceFallbackMethod,
                            voiceFallbackUrl,
                            voiceMethod,
                            voiceUrl);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("addressRequirements", addressRequirements)
                          .add("apiVersion", apiVersion)
                          .add("beta", beta)
                          .add("capabilities", capabilities)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("phoneNumber", phoneNumber)
                          .add("sid", sid)
                          .add("smsApplicationSid", smsApplicationSid)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("uri", uri)
                          .add("voiceApplicationSid", voiceApplicationSid)
                          .add("voiceCallerIdLookup", voiceCallerIdLookup)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceUrl", voiceUrl)
                          .toString();
    }
}