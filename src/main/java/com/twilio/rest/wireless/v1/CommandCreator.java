/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class CommandCreator extends Creator<Command> {
    private final String command;
    private String sim;
    private HttpMethod callbackMethod;
    private URI callbackUrl;
    private Command.CommandMode commandMode;
    private String includeSid;
    private Boolean deliveryReceiptRequested;

    /**
     * Construct a new CommandCreator.
     * 
     * @param command The message body of the Command or a Base64 encoded byte
     *                string in binary mode.
     */
    public CommandCreator(final String command) {
        this.command = command;
    }

    /**
     * The Sid or UniqueName of the
     * [SIM](https://www.twilio.com/docs/api/wireless/rest-api/sim) to send the
     * Command to..
     * 
     * @param sim The Sid or UniqueName of the SIM to send the Command to.
     * @return this
     */
    public CommandCreator setSim(final String sim) {
        this.sim = sim;
        return this;
    }

    /**
     * The HTTP method Twilio will use when making a request to the callback URL
     * (valid options are GET or POST). Defaults to POST..
     * 
     * @param callbackMethod The HTTP method Twilio will use when making a request
     *                       to the callback URL.
     * @return this
     */
    public CommandCreator setCallbackMethod(final HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * Twilio will make a request to this URL when the Command has finished sending
     * (delivered or failed)..
     * 
     * @param callbackUrl Twilio will make a request to this URL when the Command
     *                    has finished sending.
     * @return this
     */
    public CommandCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * Twilio will make a request to this URL when the Command has finished sending
     * (delivered or failed)..
     * 
     * @param callbackUrl Twilio will make a request to this URL when the Command
     *                    has finished sending.
     * @return this
     */
    public CommandCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * A string representing which mode to send the SMS message using. May be `text`
     * or `binary`. If omitted, the default SMS mode is `text`..
     * 
     * @param commandMode A string representing which mode to send the SMS message
     *                    using.
     * @return this
     */
    public CommandCreator setCommandMode(final Command.CommandMode commandMode) {
        this.commandMode = commandMode;
        return this;
    }

    /**
     * When sending a Command to a SIM in text mode, Twilio can automatically
     * include the Sid of the Command in the message body, which could be used to
     * ensure that the device does not process the same Command more than once. The
     * options for inclusion are `none`, `start` and `end`. The default behavior is
     * `none`. When using `start` or `end`, the CommandSid will be prepended or
     * appended to the message body, with a space character separating the
     * CommandSid and the message body. The length of the CommandSid contributes
     * toward the 160 character limit, i.e. the SMS body must be 128 characters or
     * less before the Command Sid is included..
     * 
     * @param includeSid When sending a Command to a SIM in text mode, Twilio can
     *                   automatically include the Sid of the Command in the message
     *                   body, which could be used to ensure that the device does
     *                   not process the same Command more than once.
     * @return this
     */
    public CommandCreator setIncludeSid(final String includeSid) {
        this.includeSid = includeSid;
        return this;
    }

    /**
     * A boolean representing whether to request delivery receipt from the
     * recipient. For Commands that request delivery receipt, the Command state
     * transitions to 'delivered' once the server has received a delivery receipt
     * from the device. Defaults to true..
     * 
     * @param deliveryReceiptRequested A boolean representing whether to request
     *                                 delivery receipt from the recipient.
     * @return this
     */
    public CommandCreator setDeliveryReceiptRequested(final Boolean deliveryReceiptRequested) {
        this.deliveryReceiptRequested = deliveryReceiptRequested;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Command
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Command create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.WIRELESS.toString(),
            "/v1/Commands",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Command creation failed: Unable to connect to server");
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

        return Command.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (command != null) {
            request.addPostParam("Command", command);
        }

        if (sim != null) {
            request.addPostParam("Sim", sim);
        }

        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());
        }

        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }

        if (commandMode != null) {
            request.addPostParam("CommandMode", commandMode.toString());
        }

        if (includeSid != null) {
            request.addPostParam("IncludeSid", includeSid);
        }

        if (deliveryReceiptRequested != null) {
            request.addPostParam("DeliveryReceiptRequested", deliveryReceiptRequested.toString());
        }
    }
}