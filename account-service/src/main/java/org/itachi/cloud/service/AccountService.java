package org.itachi.cloud.service;

import org.itachi.cloud.domain.User;
import org.itachi.cloud.model.Account;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 11:38
 */
public interface AccountService {
    String hello();

    /**
     * Finds account by given name
     *
     * @param accountName
     * @return found account
     */
    Account findByName(String accountName);

    /**
     * Checks if account with the same name already exists
     * Invokes Auth Service user creation
     * Creates new account with default parameters
     *
     * @param user
     * @return created account
     */
    Account create(User user);

    /**
     * Validates and applies incoming account updates
     * Invokes Statistics Service update
     *
     * @param name
     * @param update
     */
    void saveChanges(String name, Account update);
}
