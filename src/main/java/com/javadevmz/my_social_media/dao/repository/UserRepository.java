package com.javadevmz.my_social_media.dao.repository;

import com.javadevmz.my_social_media.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
}
