package com.aretesoft.dao;

import com.aretesoft.model.Bid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ayodeji.Agboola on 4/6/2017.
 */
public interface BidDao extends CrudRepository<Bid,String> {
    List<Bid> findByJobId(String jobId);
    Bid findById(String id);
}
