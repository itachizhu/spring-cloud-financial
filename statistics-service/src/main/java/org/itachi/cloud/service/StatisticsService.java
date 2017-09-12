package org.itachi.cloud.service;

import org.itachi.cloud.model.Account;
import org.itachi.cloud.model.DataPoint;

import java.util.List;

/**
 * Created by itachi on 2017/9/11.
 * User: itachi
 * Date: 2017/9/11
 * Time: 17:50
 */
public interface StatisticsService {
    /**
     * Finds account by given name
     *
     * @param accountName
     * @return found account
     */
    List<DataPoint> findByAccountName(String accountName);

    /**
     * Converts given {@link Account} object to {@link DataPoint} with
     * a set of significant statistic metrics.
     *
     * Compound {@link DataPoint#id} forces to rewrite the object
     * for each account within a day.
     *
     * @param accountName
     * @param account
     */
    DataPoint save(String accountName, Account account);
}
