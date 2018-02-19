package com.view.list.facts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ramkumarpachaiyappan on 19/02/18.
 */

public class NewsFeed {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("imageHref")
    @Expose
    private String imageHref;
    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The imageHref
     */
    public String getImageHref() {
        return imageHref;
    }

    /**
     * @param imageHref The ImageHref
     */
    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }



}
