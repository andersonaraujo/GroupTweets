package org.grouptweets.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.grouptweets.util.GroupTweetsConstants;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@UrlBinding("/signInWithTwitterCallback.do")
public class SignInWithTwitterCallbackAction extends BaseActionBean {

	@DefaultHandler
	public Resolution processCallback() {

		try {

			AccessToken accessToken = null;

			Twitter twitter = (Twitter) super
					.getSessionAttribute(GroupTweetsConstants.SESSON_TWITTER);

			RequestToken requestToken = (RequestToken) super
					.getSessionAttribute(GroupTweetsConstants.SESSON_REQUEST_TOKEN);

			String verifier = super
					.getRequestParameter(GroupTweetsConstants.SESSON_OAUTH_VERIFIER);

			accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

			// persist to the accessToken for future reference.
			super.addSessionAttribute(GroupTweetsConstants.SESSON_ACCESS_TOKEN,
					accessToken);

			super
					.removeSessionAttribute(GroupTweetsConstants.SESSON_REQUEST_TOKEN);

			return new RedirectResolution(HomeTimelineAction.class);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
