package com.miscbits.officehours.services.users;

import com.miscbits.officehours.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User findByUsername(String username);
}
