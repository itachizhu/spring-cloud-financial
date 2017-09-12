package org.itachi.cloud.repository.converter;

import org.itachi.cloud.domain.Frequency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 16:53
 */
@Component
public class FrequencyReaderConverter implements Converter<Integer, Frequency> {
    @Override
    public Frequency convert(Integer days) {
        return Frequency.withDays(days);
    }
}
