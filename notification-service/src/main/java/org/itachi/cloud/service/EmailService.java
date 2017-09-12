package org.itachi.cloud.service;

import org.itachi.cloud.domain.NotificationType;
import org.itachi.cloud.model.Recipient;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:56
 */
public interface EmailService {
    void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;
}
