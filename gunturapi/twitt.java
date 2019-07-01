import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class twitt {
    private final static String CONSUMER_KEY = "bJy3qxmj6ObumdRJLmn5ffvvF";
    private final static String CONSUMER_KEY_SECRET = "Pzb9pc3AKHQ3ZnmmI4o85SDeWWXeX6qtMNvBjVIsFBmRaXRns5";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "elasDMfVF8TdwHV3EvrsM9Vvi91Z4v8558MO0wiyiN4QL";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140922998301454337-CQNNPlx9KXfnR7QnV0c9uhnAtnC4DR";
    }

    public static void main(String[] args) throws Exception {
	new twitt().start();
    }
}