package org.itachi.cloud.repository;

import org.itachi.cloud.model.Recipient;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:52
 */
@Repository
public interface RecipientRepository extends CrudRepository<Recipient, String> {
    Recipient findByAccountName(String name);

    @Query("{ $and: [ {scheduledNotifications.BACKUP.active: true }, { $where: 'this.scheduledNotifications.BACKUP.lastNotified < " +
            "new Date(new Date().setDate(new Date().getDate() - this.scheduledNotifications.BACKUP.frequency ))' }] }")
    List<Recipient> findReadyForBackup();

    @Query("{ $and: [ {scheduledNotifications.REMIND.active: true }, { $where: 'this.scheduledNotifications.REMIND.lastNotified < " +
            "new Date(new Date().setDate(new Date().getDate() - this.scheduledNotifications.REMIND.frequency ))' }] }")
    List<Recipient> findReadyForRemind();

}
