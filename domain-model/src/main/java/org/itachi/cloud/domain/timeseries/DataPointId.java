package org.itachi.cloud.domain.timeseries;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 17:59
 */
public class DataPointId implements Serializable {
    private String account;

    private Date date;

    public DataPointId(String account, Date date) {
        this.account = account;
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DataPointId{" +
                "account='" + account + '\'' +
                ", date=" + date +
                '}';
    }
}
