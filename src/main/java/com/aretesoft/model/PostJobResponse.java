package com.aretesoft.model;

/**
 * Created by Ayodeji.Agboola on 3/29/2017.
 */
public class PostJobResponse {
    private Job job;

public PostJobResponse(Job job){
    this.job=job;

}
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
