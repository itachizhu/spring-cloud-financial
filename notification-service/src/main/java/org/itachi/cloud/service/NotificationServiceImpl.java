package org.itachi.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.client.AccountServiceClient;
import org.itachi.cloud.domain.NotificationType;
import org.itachi.cloud.model.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 17:03
 */
@Slf4j
@Component
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private AccountServiceClient client;

    @Autowired
    private RecipientService recipientService;

    @Autowired
    private EmailService emailService;

    @Override
    @Scheduled(cron = "${backup.cron}")
    public void sendBackupNotifications() {
        final NotificationType type = NotificationType.BACKUP;

        List<Recipient> recipients = recipientService.findReadyToNotify(type);
        log.info("found {} recipients for backup notification", recipients.size());

        recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
            try {
                String attachment = client.getAccount(recipient.getAccountName());
                emailService.send(type, recipient, attachment);
                recipientService.markNotified(type, recipient);
            } catch (Throwable t) {
                log.error("an error during backup notification for {}", recipient, t);
            }
        }));
    }

    @Override
    @Scheduled(cron = "${remind.cron}")
    public void sendRemindNotifications() {
        final NotificationType type = NotificationType.REMIND;

        List<Recipient> recipients = recipientService.findReadyToNotify(type);
        log.info("found {} recipients for remind notification", recipients.size());

        recipients.forEach(recipient -> CompletableFuture.runAsync(() -> {
            try {
                emailService.send(type, recipient, null);
                recipientService.markNotified(type, recipient);
            } catch (Throwable t) {
                log.error("an error during remind notification for {}", recipient, t);
            }
        }));
    }
}
