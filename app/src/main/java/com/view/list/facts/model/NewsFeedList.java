package com.view.list.facts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class NewsFeedList {
    @SerializedName("title")
    @Expose
    private String newsheadertitle;
    @SerializedName("rows")
    @Expose
    private ArrayList<NewsFeed> newsfeed = new ArrayList<>();
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private int status;

    /**
     * @return The NewsFeed
     */
    public ArrayList<NewsFeed> getNewsFeed() {
        return newsfeed;
    }

    /**
     * @param newsfeed The NewsFeed
     */
    public void setNewsFeed(ArrayList<NewsFeed> newsfeed) {
        this.newsfeed = newsfeed;
    }

    public String getNewsheadertitle() {
        return newsheadertitle;
    }

    public void setNewsheadertitle(String newsheadertitle) {
        this.newsheadertitle = newsheadertitle;
    }
    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
