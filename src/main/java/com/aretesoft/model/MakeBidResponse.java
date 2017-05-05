package com.aretesoft.model;

/**
 * Created by Ayodeji.Agboola on 4/6/2017.
 */
public class MakeBidResponse {
    private Bid bid;

    public MakeBidResponse(Bid bid){
        this.setBid(bid);
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }
}
