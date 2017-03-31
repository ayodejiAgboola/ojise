package com.aretesoft.model;

/**
 * Created by Ayodeji.Agboola on 3/29/2017.
 */
public class PostJobRequest {
    private String title;
    private String description;
    private String expectedPrice;
    private String expectedCompleteDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(String expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getExpectedCompleteDate() {
        return expectedCompleteDate;
    }

    public void setExpectedCompleteDate(String expectedCompleteDate) {
        this.expectedCompleteDate = expectedCompleteDate;
    }
}
