package org.itachi.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.domain.NotificationType;
import org.itachi.cloud.model.Recipient;
import org.itachi.cloud.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 17:00
 */
@Slf4j
@Component
public class RecipientServiceImpl implements RecipientService {
    @Autowired
    private RecipientRepository repository;

    @Override
    public Recipient findByAccountName(String accountName) {
        Assert.hasLength(accountName, "[Assertion failed] - [accountName] must not be null or empty");
        return repository.findByAccountName(accountName);
    }

    @Override
    public List<Recipient> findReadyToNotify(NotificationType type) {
        switch (type) {
            case BACKUP:
                return repository.findReadyForBackup();
            case REMIND:
                return repository.findReadyForRemind();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Recipient save(String accountName, Recipient recipient) {
        recipient.setAccountName(accountName);
        recipient.getScheduledNotifications().values()
                .forEach(settings -> {
                    if (settings.getLastNotified() == null) {
                        settings.setLastNotified(new Date());
                    }
                });

        repository.save(recipient);

        log.info("recipient {} settings has been updated", recipient);

        return recipient;
    }

    @Override
    public void markNotified(NotificationType type, Recipient recipient) {
        recipient.getScheduledNotifications().get(type).setLastNotified(new Date());
        repository.save(recipient);
    }
}
