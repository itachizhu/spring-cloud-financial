package org.itachi.cloud.service;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:59
 */
public interface NotificationService {
    void sendBackupNotifications();
    void sendRemindNotifications();
}
