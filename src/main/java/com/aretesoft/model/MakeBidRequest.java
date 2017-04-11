package com.aretesoft.model;

/**
 * Created by Ayodeji.Agboola on 4/6/2017.
 */
public class MakeBidRequest {
    private String jobId;
    private String bidDate;
    private String bidAmount;
    private String bidCompleteDate;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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
