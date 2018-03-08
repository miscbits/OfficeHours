package com.miscbits.officehours.daos;

import com.miscbits.officehours.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
