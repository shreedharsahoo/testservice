/**
 * 
 */
package com.ge.testservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.ge.testservice.model.User;


/**
 * @author shreedhar sahoo
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Nullable
    User findUserByusernameEquals(String username);

}
