package org.itachi.cloud.domain.timeseries;

import java.math.BigDecimal;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 09:33
 */
public class ItemMetric {
    private String title;

    private BigDecimal amount;

    public ItemMetric(String title, BigDecimal amount) {
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemMetric that = (ItemMetric) o;

        return title.equalsIgnoreCase(that.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
