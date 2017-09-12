package org.itachi.cloud.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:43
 */
public class NotificationSettings {
    @NotNull
    private Boolean active;

    @NotNull
    private Frequency frequency;

    private Date lastNotified;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Date getLastNotified() {
        return lastNotified;
    }

    public void setLastNotified(Date lastNotified) {
        this.lastNotified = lastNotified;
    }
}
