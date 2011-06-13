package org.grouptweets.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.grouptweets.util.GroupTweetsConstants;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

@UrlBinding("/signInWithTwitter.do")
public class SignInWithTwitterAction extends BaseActionBean {

	public static final String APP_KEY = "VWnXzteQ8Mnv5P6yP1GEQ";

	public static final String APP_SECRET = "4wS27N9wUXMUNb2RaRF34tWbEW2Bn8np3MAQjIGexk";

	public static final String CALLBACK_URL = "http://localhost:8080/groupTweetsWeb/signInWithTwitterCallback.do";

	@DefaultHandler
	public Resolution signIn() {

		System.setProperty("java.net.useSystemProxies", "true");

		try {

			// The factory instance is re-useable and thread safe.
			Twitter twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(APP_KEY, APP_SECRET);

			RequestToken requestToken = twitter
					.getOAuthRequestToken(CALLBACK_URL);

			String authUrl = requestToken.getAuthorizationURL();
			System.out.println("Auth URL:");
			System.out.println(authUrl);

			super.addSessionAttribute(GroupTweetsConstants.SESSON_TWITTER,
					twitter);
			super.addSessionAttribute(
					GroupTweetsConstants.SESSON_REQUEST_TOKEN, requestToken);

			return new RedirectResolution(authUrl, false);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
