/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.insights.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AnnotationUpdater extends Updater<Annotation> {
    private final String pathCallSid;
    private Annotation.AnsweredBy answeredBy;
    private Annotation.ConnectivityIssue connectivityIssue;
    private String qualityIssues;
    private Boolean spam;
    private Integer callScore;
    private String comment;
    private String incident;

    /**
     * Construct a new AnnotationUpdater.
     *
     * @param pathCallSid The call_sid
     */
    public AnnotationUpdater(final String pathCallSid) {
        this.pathCallSid = pathCallSid;
    }

    /**
     * The answered_by.
     *
     * @param answeredBy The answered_by
     * @return this
     */
    public AnnotationUpdater setAnsweredBy(final Annotation.AnsweredBy answeredBy) {
        this.answeredBy = answeredBy;
        return this;
    }

    /**
     * The connectivity_issue.
     *
     * @param connectivityIssue The connectivity_issue
     * @return this
     */
    public AnnotationUpdater setConnectivityIssue(final Annotation.ConnectivityIssue connectivityIssue) {
        this.connectivityIssue = connectivityIssue;
        return this;
    }

    /**
     * The quality_issues.
     *
     * @param qualityIssues The quality_issues
     * @return this
     */
    public AnnotationUpdater setQualityIssues(final String qualityIssues) {
        this.qualityIssues = qualityIssues;
        return this;
    }

    /**
     * The spam.
     *
     * @param spam The spam
     * @return this
     */
    public AnnotationUpdater setSpam(final Boolean spam) {
        this.spam = spam;
        return this;
    }

    /**
     * The call_score.
     *
     * @param callScore The call_score
     * @return this
     */
    public AnnotationUpdater setCallScore(final Integer callScore) {
        this.callScore = callScore;
        return this;
    }

    /**
     * The comment.
     *
     * @param comment The comment
     * @return this
     */
    public AnnotationUpdater setComment(final String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * The incident.
     *
     * @param incident The incident
     * @return this
     */
    public AnnotationUpdater setIncident(final String incident) {
        this.incident = incident;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Annotation
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Annotation update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.INSIGHTS.toString(),
            "/v1/Voice/" + this.pathCallSid + "/Annotation"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Annotation update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Annotation.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (answeredBy != null) {
            request.addPostParam("AnsweredBy", answeredBy.toString());
        }

        if (connectivityIssue != null) {
            request.addPostParam("ConnectivityIssue", connectivityIssue.toString());
        }

        if (qualityIssues != null) {
            request.addPostParam("QualityIssues", qualityIssues);
        }

        if (spam != null) {
            request.addPostParam("Spam", spam.toString());
        }

        if (callScore != null) {
            request.addPostParam("CallScore", callScore.toString());
        }

        if (comment != null) {
            request.addPostParam("Comment", comment);
        }

        if (incident != null) {
            request.addPostParam("Incident", incident);
        }
    }
}