package org.itachi.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.itachi.cloud.domain.NotificationType;
import org.itachi.cloud.model.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:57
 */
@Slf4j
@Component
@RefreshScope
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    @Override
    public void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException {
        final String subject = env.getProperty(type.getSubject());
        final String text = MessageFormat.format(env.getProperty(type.getText()), recipient.getAccountName());

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipient.getEmail());
        helper.setSubject(subject);
        helper.setText(text);

        if (StringUtils.hasLength(attachment)) {
            helper.addAttachment(env.getProperty(type.getAttachment()), new ByteArrayResource(attachment.getBytes()));
        }

        mailSender.send(message);

        log.info("{} email notification has been send to {}", type, recipient.getEmail());
    }
}
