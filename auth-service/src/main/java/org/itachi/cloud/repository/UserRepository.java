package org.itachi.cloud.repository;

import org.itachi.cloud.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 10:15
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
