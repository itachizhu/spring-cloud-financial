package org.itachi.cloud.repository;

import org.itachi.cloud.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 14:27
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    Account findByName(String name);
}