package org.grouptweets.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.grouptweets.util.GroupTweetsConstants;

import twitter4j.auth.AccessToken;

@UrlBinding("/index.do")
public class IndexPageActionBean extends BaseActionBean {

	@DefaultHandler
	public Resolution exibir() {

		AccessToken accessToken = (AccessToken) super
				.getSessionAttribute(GroupTweetsConstants.SESSON_ACCESS_TOKEN);

		if (accessToken != null) {

			return new RedirectResolution(HomeTimelineAction.class);

		}

		return new ForwardResolution("/WEB-INF/jsps/index.jsp");
	}

}
