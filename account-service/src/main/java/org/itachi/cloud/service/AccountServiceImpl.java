package org.itachi.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.client.AuthServiceClient;
import org.itachi.cloud.client.StatisticsServiceClient;
import org.itachi.cloud.domain.Currency;
import org.itachi.cloud.domain.Saving;
import org.itachi.cloud.domain.User;
import org.itachi.cloud.model.Account;
import org.itachi.cloud.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 11:38
 */
@Slf4j
@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AuthServiceClient authClient;

    @Autowired
    private StatisticsServiceClient statisticsClient;

    @Autowired
    private AccountRepository repository;

    @Override
    public String hello() {
        return authClient.hello();
    }

    @Override
    public Account findByName(String accountName) {
        Assert.hasLength(accountName, "[Assertion failed] - [accountName] must not be null or empty");
        return repository.findByName(accountName);
    }

    @Override
    public Account create(User user) {
        Account existing = repository.findByName(user.getUsername());
        Assert.isNull(existing, "account already exists: " + user.getUsername());

        authClient.createUser(user);

        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());
        saving.setInterest(new BigDecimal(0));
        saving.setDeposit(false);
        saving.setCapitalization(false);

        Account account = new Account();
        account.setName(user.getUsername());
        account.setLastSeen(new Date());
        account.setSaving(saving);

        repository.save(account);

        log.info("new account has been created: " + account.getName());

        return account;
    }

    @Override
    public void saveChanges(String name, Account update) {
        Account account = repository.findByName(name);
        Assert.notNull(account, "can't find account with name " + name);

        account.setIncomes(update.getIncomes());
        account.setExpenses(update.getExpenses());
        account.setSaving(update.getSaving());
        account.setNote(update.getNote());
        account.setLastSeen(new Date());
        repository.save(account);

        log.debug("account {} changes has been saved", name);

        statisticsClient.updateStatistics(name, account);
    }
}
