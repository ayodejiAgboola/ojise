package com.aretesoft.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Ayodeji.Agboola on 3/28/2017.
 */
@Document(collection = "jobs")
public class Job {
    @Id
    private String id;
    private String title;
    private String description;
    private String client;
    private String freelancer;
    private String createdDate;
    private String assignedDate;
    private String CompleteDate;
    private String expectedCompleteDate;
    private String proposedCompleteDate;
    private String price;
    private String expectedPrice;
    private String proposedPrice;

}
