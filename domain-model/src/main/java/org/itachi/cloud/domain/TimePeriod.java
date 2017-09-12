package org.itachi.cloud.domain;

import java.math.BigDecimal;

/**
 * Created by itachi on 2017/9/8.
 * User: itachi
 * Date: 2017/9/8
 * Time: 15:55
 */
public enum TimePeriod {
    YEAR(365.2425), QUARTER(91.3106), MONTH(30.4368), DAY(1), HOUR(0.0416);

    private double baseRatio;

    TimePeriod(double baseRatio) {
        this.baseRatio = baseRatio;
    }

    public BigDecimal getBaseRatio() {
        return new BigDecimal(baseRatio);
    }

    public static TimePeriod getBase() {
        return DAY;
    }
}
