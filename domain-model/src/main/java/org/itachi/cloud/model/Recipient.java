package org.itachi.cloud.model;

import org.hibernate.validator.constraints.Email;
import org.itachi.cloud.domain.NotificationSettings;
import org.itachi.cloud.domain.NotificationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:45
 */
@Document(collection = "recipients")
public class Recipient {

    @Id
    private String accountName;

    @NotNull
    @Email
    private String email;

    @Valid
    private Map<NotificationType, NotificationSettings> scheduledNotifications;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<NotificationType, NotificationSettings> getScheduledNotifications() {
        return scheduledNotifications;
    }

    public void setScheduledNotifications(Map<NotificationType, NotificationSettings> scheduledNotifications) {
        this.scheduledNotifications = scheduledNotifications;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
