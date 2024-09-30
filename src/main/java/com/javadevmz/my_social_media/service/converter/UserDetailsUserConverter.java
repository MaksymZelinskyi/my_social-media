package com.javadevmz.my_social_media.service.converter;

import com.javadevmz.my_social_media.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsUserConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDetails convertUserToUserDetails(User user) {
      return org.springframework.security.core.userdetails.User.
               builder()
               .username(user.getUsername())
               .password(passwordEncoder.encode(user.getPassword()))
               .password(user.getPassword())
               .authorities(user.getRoles().toArray(String[]::new))
              .build();
    }
}
