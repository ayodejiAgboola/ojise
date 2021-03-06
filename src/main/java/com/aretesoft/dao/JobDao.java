package com.aretesoft.dao;

import com.aretesoft.model.Job;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Ayodeji.Agboola on 3/29/2017.
 */
public interface JobDao extends CrudRepository<Job, String> {
List<Job> findByCategory(String category);
Job findById(String id);
List<Job> findByClient(String client);
}
