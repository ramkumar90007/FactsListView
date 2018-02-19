package com.view.list.ui;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.view.list.Robot.FactsListRobot;
import com.view.list.facts.FactsActivity;
import com.view.list.facts.networking.NetworkModule;
import com.view.list.utils.FileUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;

/**
 * Created by ramkumarpachaiyappan on 20/02/18.
 */

public class FactsListActivityTest {
    @Rule
    public ActivityTestRule<FactsActivity> activityTestRule = new ActivityTestRule<>(FactsActivity.class, false, false);

    private static final String URL_PATH = "/";
    private static final String FACTS_JSON_DATA = "{\n" +
            " \"title\": \"About Canada\",\n" +
            " \"rows\": [\n" +
            " {\n" +
            "\"title\": \"Beavers\",\n" +
            "\"description\": \"Beavers are second only to humans in their ability to manipulate and change their environment. They can measure up to 1.3 metres long. A group of beavers is called a colony\",\n" +
            "\"imageHref\": \"http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/American_Beaver.jpg/220px-American_Beaver.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Flag\",\n" +
            "\"description\": null,\n" +
            "\"imageHref\": \"http://images.findicons.com/files/icons/662/world_flag/128/flag_of_canada.png\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Transportation\",\n" +
            "\"description\": \"It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.\",\n" +
            "\"imageHref\": \"http://1.bp.blogspot.com/_VZVOmYVm68Q/SMkzZzkGXKI/AAAAAAAAADQ/U89miaCkcyo/s400/the_golden_compass_still.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Hockey Night in Canada\",\n" +
            "\"description\": \"These Saturday night CBC broadcasts originally aired on radio in 1931. In 1952 they debuted on television and continue to unite (and divide) the nation each week.\",\n" +
            "\"imageHref\": \"http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Eh\",\n" +
            "\"description\": \"A chiefly Canadian interrogative utterance, usually expressing surprise or doubt or seeking confirmation.\",\n" +
            "\"imageHref\": null\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Housing\",\n" +
            "\"description\": \"Warmer than you might think.\",\n" +
            "\"imageHref\": \"http://icons.iconarchive.com/icons/iconshock/alaska/256/Igloo-icon.png\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Public Shame\",\n" +
            "\"description\": \" Sadly it's true.\",\n" +
            "\"imageHref\": \"http://static.guim.co.uk/sys-images/Music/Pix/site_furniture/2007/04/19/avril_lavigne.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": null,\n" +
            "\"description\": null,\n" +
            "\"imageHref\": null\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Space Program\",\n" +
            "\"description\": \"Canada hopes to soon launch a man to the moon.\",\n" +
            "\"imageHref\": \"http://files.turbosquid.com/Preview/Content_2009_07_14__10_25_15/trebucheta.jpgdf3f3bf4-935d-40ff-84b2-6ce718a327a9Larger.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Meese\",\n" +
            "\"description\": \"A moose is a common sight in Canada. Tall and majestic, they represent many of the values which Canadians imagine that they possess. They grow up to 2.7 metres long and can weigh over 700 kg. They swim at 10 km/h. Moose antlers weigh roughly 20 kg. The plural of moose is actually 'meese', despite what most dictionaries, encyclopedias, and experts will tell you.\",\n" +
            "\"imageHref\": \"http://caroldeckerwildlifeartstudio.net/wp-content/uploads/2011/04/IMG_2418%20majestic%20moose%201%20copy%20(Small)-96x96.jpg\"\n" +
            "},\n" +
            " {\n" +
            "\"title\": \"Geography\",\n" +
            "\"description\": \"It's really big.\",\n" +
            "\"imageHref\": null\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Kittens...\",\n" +
            "\"description\": \"�are illegal. Cats are fine.\",\n" +
            "\"imageHref\": \"http://www.donegalhimalayans.com/images/That%20fish%20was%20this%20big.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Mounties\",\n" +
            "\"description\": \"They are the law. They are also Canada's foreign espionage service. Subtle.\",\n" +
            "\"imageHref\": \"http://3.bp.blogspot.com/__mokxbTmuJM/RnWuJ6cE9cI/AAAAAAAAATw/6z3m3w9JDiU/s400/019843_31.jpg\"\n" +
            "},\n" +
            "{\n" +
            "\"title\": \"Language\",\n" +
            "\"description\": \"Nous parlons tous les langues importants.\",\n" +
            "\"imageHref\": null\n" +
            "}\n" +
            "]\n" +
            "}";
    private static final String FACTS_NOTFOUND_JSON = "{\n" +
            "  \"error\": {\n" +
            "    \"code\": 404,\n" +
            "    \"message\": \"Facts Not found\"\n" +
            "  }\n" +
            "}";

    private FactsListRobot.Eyes eyes = new FactsListRobot.Eyes();
    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        NetworkModule.BASEURL = mockWebServer.url(URL_PATH).toString();
    }

    @Test
    public void onLaunch_apiSuccess_seesAboutContent() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_OK)
                .setBody(FileUtils.getResponseFromFile(getClass(), FACTS_JSON_DATA)));

        activityTestRule.launchActivity(new Intent());

        eyes.seesSwipeRefreshLayout()
                .seesListRecyclerView();

    }

    @Test
    public void onLaunch_apiFailure_seesNoContentInfo() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_UNAVAILABLE)
                .setBody(FileUtils.getResponseFromFile(getClass(), FACTS_NOTFOUND_JSON)));

        activityTestRule.launchActivity(new Intent());

        eyes.seesSwipeRefreshLayout()
                .doesNotSeeListRecyclerView();

    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

}
