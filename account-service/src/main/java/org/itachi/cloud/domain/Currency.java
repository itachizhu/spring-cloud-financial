package org.itachi.cloud.domain;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 15:57
 */
public enum Currency {
    USD, EUR, RUB, CNY;

    public static Currency getDefault() {
        return CNY;
    }
}
