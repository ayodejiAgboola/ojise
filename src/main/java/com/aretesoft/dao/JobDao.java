package com.aretesoft.dao;

import com.aretesoft.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by Ayodeji.Agboola on 3/29/2017.
 */
public interface JobDao extends CrudRepository<Job, String> {

}
