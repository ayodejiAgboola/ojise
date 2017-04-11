package com.aretesoft.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by Ayodeji.Agboola on 3/31/2017.
 */
public class Bid {
    @Id
    private String id;
    private String jobId;
    private String bidderId;
    private String bidDate;
    private String bidAmount;
    private String bidCompleteDate;
public Bid(String jobId, String bidderId, String bidDate, String bidAmount, String bidCompleteDate){
    this.jobId=jobId;
    this.bidderId=bidderId;
    this.bidDate=bidDate;
    this.bidAmount=bidAmount;
    this.bidCompleteDate=bidCompleteDate;
}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getBidderId() {
        return bidderId;
    }

    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public String getBidDate() {
        return bidDate;
    }

    public void setBidDate(String bidDate) {
        this.bidDate = bidDate;
    }

    public String getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(String bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getBidCompleteDate() {
        return bidCompleteDate;
    }

    public void setBidCompleteDate(String bidCompleteDate) {
        this.bidCompleteDate = bidCompleteDate;
    }
}
