/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.availablephonenumbercountry;

import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import com.twilio.base.Page;





/*
    * Twilio - Api
    *
    * This is the public Twilio REST API.
    *
    * API version: 1.35.0
    * Contact: support@twilio.com
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.


public class MachineToMachineReader extends Reader<MachineToMachine> {
    private String countryCode;
    private String accountSid;
    private Integer areaCode;
    private String contains;
    private Boolean smsEnabled;
    private Boolean mmsEnabled;
    private Boolean voiceEnabled;
    private Boolean excludeAllAddressRequired;
    private Boolean excludeLocalAddressRequired;
    private Boolean excludeForeignAddressRequired;
    private Boolean beta;
    private com.twilio.type.PhoneNumber nearNumber;
    private String nearLatLong;
    private Integer distance;
    private String inPostalCode;
    private String inRegion;
    private String inRateCenter;
    private String inLata;
    private String inLocality;
    private Boolean faxEnabled;
    private Integer pageSize;

    public MachineToMachineReader(final String countryCode){
        this.countryCode = countryCode;
    }
    public MachineToMachineReader(final String accountSid, final String countryCode){
        this.accountSid = accountSid;
        this.countryCode = countryCode;
    }

    public MachineToMachineReader setAreaCode(final Integer areaCode){
        this.areaCode = areaCode;
        return this;
    }
    public MachineToMachineReader setContains(final String contains){
        this.contains = contains;
        return this;
    }
    public MachineToMachineReader setSmsEnabled(final Boolean smsEnabled){
        this.smsEnabled = smsEnabled;
        return this;
    }
    public MachineToMachineReader setMmsEnabled(final Boolean mmsEnabled){
        this.mmsEnabled = mmsEnabled;
        return this;
    }
    public MachineToMachineReader setVoiceEnabled(final Boolean voiceEnabled){
        this.voiceEnabled = voiceEnabled;
        return this;
    }
    public MachineToMachineReader setExcludeAllAddressRequired(final Boolean excludeAllAddressRequired){
        this.excludeAllAddressRequired = excludeAllAddressRequired;
        return this;
    }
    public MachineToMachineReader setExcludeLocalAddressRequired(final Boolean excludeLocalAddressRequired){
        this.excludeLocalAddressRequired = excludeLocalAddressRequired;
        return this;
    }
    public MachineToMachineReader setExcludeForeignAddressRequired(final Boolean excludeForeignAddressRequired){
        this.excludeForeignAddressRequired = excludeForeignAddressRequired;
        return this;
    }
    public MachineToMachineReader setBeta(final Boolean beta){
        this.beta = beta;
        return this;
    }
    public MachineToMachineReader setNearNumber(final com.twilio.type.PhoneNumber nearNumber){
        this.nearNumber = nearNumber;
        return this;
    }

    public MachineToMachineReader setNearNumber(final String nearNumber){
    this.nearNumber = Promoter.phoneNumberFromString(nearNumber);
    return this;
    }
    public MachineToMachineReader setNearLatLong(final String nearLatLong){
        this.nearLatLong = nearLatLong;
        return this;
    }
    public MachineToMachineReader setDistance(final Integer distance){
        this.distance = distance;
        return this;
    }
    public MachineToMachineReader setInPostalCode(final String inPostalCode){
        this.inPostalCode = inPostalCode;
        return this;
    }
    public MachineToMachineReader setInRegion(final String inRegion){
        this.inRegion = inRegion;
        return this;
    }
    public MachineToMachineReader setInRateCenter(final String inRateCenter){
        this.inRateCenter = inRateCenter;
        return this;
    }
    public MachineToMachineReader setInLata(final String inLata){
        this.inLata = inLata;
        return this;
    }
    public MachineToMachineReader setInLocality(final String inLocality){
        this.inLocality = inLocality;
        return this;
    }
    public MachineToMachineReader setFaxEnabled(final Boolean faxEnabled){
        this.faxEnabled = faxEnabled;
        return this;
    }
    public MachineToMachineReader setPageSize(final Integer pageSize){
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<MachineToMachine> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<MachineToMachine> firstPage(final TwilioRestClient client) {
        String path = "/2010-04-01/Accounts/{AccountSid}/AvailablePhoneNumbers/{CountryCode}/MachineToMachine.json";
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"CountryCode"+"}", this.countryCode.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            path
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    private Page<MachineToMachine> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("MachineToMachine read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "available_phone_numbers",
            response.getContent(),
            MachineToMachine.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<MachineToMachine> previousPage(final Page<MachineToMachine> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }


    @Override
    public Page<MachineToMachine> nextPage(final Page<MachineToMachine> page, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<MachineToMachine> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }
    private void addQueryParams(final Request request) {
        if (areaCode != null) {
    
            request.addQueryParam("AreaCode", areaCode.toString());
        }
        if (contains != null) {
    
            request.addQueryParam("Contains", contains);
        }
        if (smsEnabled != null) {
    
            request.addQueryParam("SmsEnabled", smsEnabled.toString());
        }
        if (mmsEnabled != null) {
    
            request.addQueryParam("MmsEnabled", mmsEnabled.toString());
        }
        if (voiceEnabled != null) {
    
            request.addQueryParam("VoiceEnabled", voiceEnabled.toString());
        }
        if (excludeAllAddressRequired != null) {
    
            request.addQueryParam("ExcludeAllAddressRequired", excludeAllAddressRequired.toString());
        }
        if (excludeLocalAddressRequired != null) {
    
            request.addQueryParam("ExcludeLocalAddressRequired", excludeLocalAddressRequired.toString());
        }
        if (excludeForeignAddressRequired != null) {
    
            request.addQueryParam("ExcludeForeignAddressRequired", excludeForeignAddressRequired.toString());
        }
        if (beta != null) {
    
            request.addQueryParam("Beta", beta.toString());
        }
        if (nearNumber != null) {
    
            request.addQueryParam("NearNumber", nearNumber.toString());
        }
        if (nearLatLong != null) {
    
            request.addQueryParam("NearLatLong", nearLatLong);
        }
        if (distance != null) {
    
            request.addQueryParam("Distance", distance.toString());
        }
        if (inPostalCode != null) {
    
            request.addQueryParam("InPostalCode", inPostalCode);
        }
        if (inRegion != null) {
    
            request.addQueryParam("InRegion", inRegion);
        }
        if (inRateCenter != null) {
    
            request.addQueryParam("InRateCenter", inRateCenter);
        }
        if (inLata != null) {
    
            request.addQueryParam("InLata", inLata);
        }
        if (inLocality != null) {
    
            request.addQueryParam("InLocality", inLocality);
        }
        if (faxEnabled != null) {
    
            request.addQueryParam("FaxEnabled", faxEnabled.toString());
        }
        if (pageSize != null) {
    
            request.addQueryParam("PageSize", pageSize.toString());
        }
    }
}

