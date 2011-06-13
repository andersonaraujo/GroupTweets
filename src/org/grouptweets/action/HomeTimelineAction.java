package org.grouptweets.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.grouptweets.util.GroupTweetsConstants;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@UrlBinding("/homeTimeline.do")
public class HomeTimelineAction extends BaseActionBean {

	private List<Status> homeTimelineList;

	@DefaultHandler
	public Resolution processCallback() {

		try {

			AccessToken accessToken = (AccessToken) super
					.getSessionAttribute(GroupTweetsConstants.SESSON_ACCESS_TOKEN);
			
			ConfigurationBuilder configBuilder = new ConfigurationBuilder();
			configBuilder.setOAuthConsumerKey(SignInWithTwitterAction.APP_KEY);
			configBuilder.setOAuthConsumerSecret(SignInWithTwitterAction.APP_SECRET);
			configBuilder.setOAuthAccessToken(accessToken.getToken());
			configBuilder.setOAuthAccessTokenSecret(accessToken.getTokenSecret());
			
			Configuration config = configBuilder.build();

			Twitter twitter = new TwitterFactory(config).getInstance();

			this.homeTimelineList = twitter.getHomeTimeline();

			return new ForwardResolution("/WEB-INF/jsps/homeTimelime.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Status> getHomeTimelineList() {
		return homeTimelineList;
	}

	public void setHomeTimelineList(List<Status> homeTimelineList) {
		this.homeTimelineList = homeTimelineList;
	}

}
