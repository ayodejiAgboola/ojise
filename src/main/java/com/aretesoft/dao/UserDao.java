package com.aretesoft.dao;
import com.aretesoft.model.User;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ayodeji.Agboola on 3/27/2017.
 */
public interface UserDao extends CrudRepository<User, String> {
    User findByUsername(String username);
}
