package com.twilio.sdk.resource.list.taskrouter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.json.simple.JSONObject;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.TwilioTaskRouterClient;
import com.twilio.sdk.resource.NextGenListResource;
import com.twilio.sdk.resource.factory.taskrouter.WorkerFactory;
import com.twilio.sdk.resource.instance.taskrouter.Worker;

/**
 * WorkerList to work with {@link com.twilio.sdk.resource.instance.taskrouter.Worker}.
 */
public class WorkerList extends NextGenListResource<Worker, TwilioTaskRouterClient> implements WorkerFactory {

	private String workspaceSid;

	/**
	 * Instantiates a worker list.
	 *
	 * @param client the client
	 * @param workspaceSid the workspace sid
	 */
	public WorkerList(final TwilioTaskRouterClient client, final String workspaceSid) {
		super(client);
		this.workspaceSid = workspaceSid;
	}

	/**
	 * Instantiates a worker list.
	 *
	 * @param client the client
	 * @param workspaceSid the workspace sid
	 * @param filters the filters
	 */
	public WorkerList(final TwilioTaskRouterClient client, final String workspaceSid,
			final Map<String, String> filters) {
		super(client, filters);
		this.workspaceSid = workspaceSid;
	}

	@Override
	public Worker create(final Map<String, String> params) throws TwilioRestException {
		TwilioRestResponse response = getClient().safeRequest(getResourceLocation(), "POST", params);
		return makeNew(getClient(), response.toMap());
	}

	@Override
	public Worker create(final List<NameValuePair> params) throws TwilioRestException {
		TwilioRestResponse response = getClient().safeRequest(getResourceLocation(), "POST", params);
		return makeNew(getClient(), response.toMap());
	}

	@Override
	public Worker create(final String friendlyName, final Map attributes, final String activitySid) throws TwilioRestException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("FriendlyName", friendlyName);

		if(attributes != null) {
			params.put("Attributes", JSONObject.toJSONString(attributes));
		}else {
			params.put("Attributes", "{}");
		}
		if(activitySid != null) {
			params.put("ActivitySid", activitySid);
		}

		TwilioRestResponse response = getClient().safeRequest(getResourceLocation(), "POST", params);
		return makeNew(getClient(), response.toMap());
	}

	@Override
	protected Worker makeNew(final TwilioTaskRouterClient client, final Map<String, Object> params) {
		return new Worker(client, params);
	}

	@Override
	protected String getResourceLocation() {
		return "/" + TwilioTaskRouterClient.DEFAULT_VERSION + "/Workspaces/" + workspaceSid + "/Workers";
	}
}
